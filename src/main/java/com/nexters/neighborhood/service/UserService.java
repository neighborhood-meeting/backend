package com.nexters.neighborhood.service;

import com.nexters.neighborhood.dto.Authentication;
import com.nexters.neighborhood.controller.user.UserRequestParam;
import com.nexters.neighborhood.dto.UserDto;
import com.nexters.neighborhood.exception.InvalidAccessException;
import com.nexters.neighborhood.entity.User;
import com.nexters.neighborhood.repository.UserRepository;
import com.nexters.neighborhood.utility.ServerUtils;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Dark on 2016. 8. 13..
 */
@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private static final String DEFAULT_IMAGES_FILE_PATH = "/Users/Dark/Documents/neighborhood/images";

    public Authentication save(UserRequestParam userRequestParam) {
        String issuedToken = Authentication.issueToken();

        User user = new User();

        user.setToken(issuedToken);
        user.setProfileUrl(uploadImage(userRequestParam.getProfileImage()));
        user.setName(userRequestParam.getName());
        user.setEmail(userRequestParam.getEmail());
        user.setBirthDate(userRequestParam.getBirthDate());
        user.setSex(userRequestParam.getSex());
        user.setPassword(userRequestParam.getPassword());

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

    private String uploadImage(MultipartFile profileImage) {
        DateTime nowTime = DateTime.now();

        String profilePreUrl = String.format("/profile/%s", nowTime.toString("yyMMdd"));
        String profileSuffixUrl = UUID.randomUUID().toString().replaceAll("-", "");

        profileDirectoryRolling();

        String imageFileDirectory = String.format("%s/%s", DEFAULT_IMAGES_FILE_PATH, profilePreUrl);

        try {
            profileImage.transferTo(new File(String.format("%s/%s", imageFileDirectory, profileSuffixUrl + ".jpg")));
        } catch (IOException e) {
            log.error("Profile Image Upload Fail! ", e);
            return null;
        }

        return "http://" + ServerUtils.getSERVER_IP() + "" + profilePreUrl + "/" + profileSuffixUrl + ".jpg";
    }

    private void profileDirectoryRolling() {
        DateTime nowTime = DateTime.now();

        File imageFileDirectory = new File(String.format("%s/%s", DEFAULT_IMAGES_FILE_PATH, String.format("/profile/%s", nowTime.toString("yyMMdd"))));

        if (!imageFileDirectory.exists()) {
            imageFileDirectory.mkdir();
        }
    }
}
