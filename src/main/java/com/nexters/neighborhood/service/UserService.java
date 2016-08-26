package com.nexters.neighborhood.service;

import com.nexters.neighborhood.dto.Authentication;
import com.nexters.neighborhood.controller.user.UserRequestParam;
import com.nexters.neighborhood.dto.UserDto;
import com.nexters.neighborhood.exception.DuplicatedUserEmailException;
import com.nexters.neighborhood.exception.InvalidAccessException;
import com.nexters.neighborhood.entity.User;
import com.nexters.neighborhood.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Dark on 2016. 8. 13..
 */
@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ImageService imageService;

    public Authentication signUp(UserRequestParam userRequestParam) throws DuplicatedUserEmailException{
        String issuedToken = Authentication.issueToken();

        User user = new User();

        user.setToken(issuedToken);
        user.setProfileUrl(imageService.uploadProfileImage(userRequestParam.getProfileImage()));
        user.setName(userRequestParam.getName());
        user.setEmail(userRequestParam.getEmail());
        user.setBirthDate(userRequestParam.getBirthDate());
        user.setSex(userRequestParam.getSex());
        user.setPassword(userRequestParam.getPassword());

        try {
            userRepository.save(user);
        } catch (Exception e) {
            throw new DuplicatedUserEmailException();
        }

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

    public User findById(Long id) {
        return userRepository.findOne(id);
    }

    private boolean isSignInSuccess(User savedUser) {
        return savedUser != null;
    }

    private Authentication getAuthentication(String token) {
        Authentication authentication = new Authentication();
        authentication.setToken(token);
        return authentication;
    }
}
