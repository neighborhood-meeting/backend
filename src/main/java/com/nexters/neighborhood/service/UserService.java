package com.nexters.neighborhood.service;

import com.nexters.neighborhood.controller.model.Authentication;
import com.nexters.neighborhood.controller.model.UserRequestParam;
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
        String defaultProfileFilePath = "/Users/Dark/Documents/neighborhood/images";

        File imageFileDir = new File(String.format("%s/%s", defaultProfileFilePath, profilePreUrl));

        if (!imageFileDir.exists()) {
            imageFileDir.mkdir();
        }

        String profileSuffixUrl = UUID.randomUUID().toString().replaceAll("-", "");
        String nginxProfileSuffixUrl = "/" + profileSuffixUrl + ".jpg";
        String imageFileSuffix = String.format("%s/%s", imageFileDir, nginxProfileSuffixUrl);

        try {
            profileImage.transferTo(new File(imageFileSuffix));
        } catch (IOException e) {
            log.error("Profile Image Upload Fail! ", e);
            return null;
        }

        return "http://" + ServerUtils.getSERVER_IP() + "" + profilePreUrl + "/" + profileSuffixUrl + ".jpg";
    }
}
