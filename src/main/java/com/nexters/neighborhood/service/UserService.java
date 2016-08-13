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

        return new Authentication(token);
    }

    public Authentication login(User user) {
        User savedUser = userRepository.findOne(user.getId());

        if (savedUser.getPassword() != null && user.getPassword().equals(savedUser.getPassword())) {
            return new Authentication(savedUser.getToken());
        }

        return null;
    }
}
