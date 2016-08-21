package com.nexters.neighborhood.service;

import com.nexters.neighborhood.controller.model.Authentication;
import com.nexters.neighborhood.dto.UserDto;
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

    private static final String SERVER_IP = "52.78.120.152";

    public Authentication save(User user) {
        String issuedToken = Authentication.issueToken();

        user.setToken(issuedToken);
        user.setProfileUrl(String.format("http://%s/%s", SERVER_IP, user.getProfileUrl()));

        userRepository.save(user);

        return getAuthentication(issuedToken);
    }

    public UserDto signIn(String id, String password) {
        User savedUser = userRepository.findByEmailAndPassword(id, password);

        if (isSignInSuccess(savedUser)) {
            UserDto userDto = new UserDto();

            userDto.setUserId(savedUser.getId());
            userDto.setEmail(savedUser.getEmail());
            userDto.setProfileUrl(savedUser.getProfileUrl());
            userDto.setName(savedUser.getName());
            userDto.setSex(savedUser.getSex());
            userDto.setBirthDate(savedUser.getBirthDate());
            userDto.setToken(savedUser.getToken());

            return userDto;
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

    public User findById(Long id) {
        return userRepository.findOne(id);
    }
}
