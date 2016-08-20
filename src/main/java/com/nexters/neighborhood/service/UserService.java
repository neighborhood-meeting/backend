package com.nexters.neighborhood.service;

import com.nexters.neighborhood.controller.model.Authentication;
import com.nexters.neighborhood.exception.InvalidAccessException;
import com.nexters.neighborhood.entity.User;
import com.nexters.neighborhood.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Dark on 2016. 8. 13..
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Authentication save(User user) {
        String issuedToken = Authentication.issueToken();
        user.setToken(issuedToken);

        userRepository.save(user);

        return getAuthentication(issuedToken);
    }

    public Authentication signIn(String id, String password) {
        User savedUser = userRepository.findByEmailAndPassword(id, password);

        if (isSignInSuccess(savedUser)) {
            return getAuthentication(savedUser.getToken());
        }

        throw new InvalidAccessException();
    }

    private boolean isSignInSuccess(User savedUser) {
        return savedUser != null;
    }

    private Authentication getAuthentication(String token) {
        Authentication authentication = new Authentication();
        authentication.setToken(token);
        return authentication;
    }

    public User findByEmail(String account) {
        return userRepository.findByEmail(account);
    }

    public User findById(Long id) {
        return userRepository.findOne(id);
    }
}
