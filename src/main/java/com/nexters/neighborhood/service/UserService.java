package com.nexters.neighborhood.service;

import com.nexters.neighborhood.controller.Authentication;
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
        String token = Authentication.issueToken();
        user.setToken(token);

        userRepository.save(user);

        Authentication authentication = new Authentication();
        authentication.setToken(token);
        return authentication;
    }

    public Authentication signIn(String id, String password) {
        User savedUser = userRepository.findByIdAndPassword(id, password);

        if (savedUser != null) {
            Authentication authentication = new Authentication();
            authentication.setToken(savedUser.getToken());
            return authentication;
        }

        return null;
    }
}
