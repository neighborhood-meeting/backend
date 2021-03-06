package com.nexters.neighborhood.interceptor;

import com.nexters.neighborhood.entity.User;
import com.nexters.neighborhood.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Dark on 2016. 8. 13..
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    private static final Boolean GO_CONTROLLER = true;

    private static final String HEADER_TOKEN_NAME = "Authentication-Token";

    private static final String SIGN_UP_URL = "/api/signUp";
    private static final String SIGN_IN_URL = "/api/signIn";

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();

        if (SIGN_UP_URL.equals(requestURI) || SIGN_IN_URL.equals(requestURI)) {
            return GO_CONTROLLER;
        }

        String authenticationToken = request.getHeader(HEADER_TOKEN_NAME);

        if (authenticationToken == null) {
            response.setStatus(400);

            return false;
        } else {
            boolean isValidate = validateCheckToken(authenticationToken);

            if (isValidate) {
                return GO_CONTROLLER;
            } else {
                response.setStatus(400);

                return false;
            }
        }
    }

    private boolean validateCheckToken(String authenticationToken) {
        User user = userRepository.findByToken(authenticationToken);

        if (user != null) {
            return true;
        }

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
