package com.nexters.neighborhood.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nexters.neighborhood.exception.InvalidAccessException;
import com.nexters.neighborhood.exception.SignUpFailException;
import com.nexters.neighborhood.controller.model.Authentication;
import com.nexters.neighborhood.controller.model.UserEmailAndPassword;
import com.nexters.neighborhood.dto.UserDto;
import com.nexters.neighborhood.utility.EncryptUtils;
import com.nexters.neighborhood.entity.User;
import com.nexters.neighborhood.service.UserService;
import com.nexters.neighborhood.utility.ServerUtils;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

@Slf4j
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(method = RequestMethod.POST, value = "/signIn")
    @ResponseBody
    public ResponseEntity<UserDto> signIn(@RequestBody UserEmailAndPassword userEmailAndPassword) throws InvalidAccessException, JsonProcessingException {
        UserDto userDto = userService.signIn(userEmailAndPassword.getEmail(), EncryptUtils.getEncoededPassword(userEmailAndPassword.getPassword()));

        return ResponseEntity.ok(userDto);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signUp")
    @ResponseBody
    public ResponseEntity<String> signUp(@RequestBody User user) throws SignUpFailException {
        try {
            user.setPassword(EncryptUtils.getEncoededPassword(user.getPassword()));

            Authentication authentication = userService.save(user);

            return ResponseEntity.ok(successResponse(authentication));
        } catch (Exception ignored) {
            log.error("UserController SignUp Exception!", ignored);

            throw new SignUpFailException();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}.json")
    @ResponseBody
    public UserDto getUserInformation(@PathVariable Long id) {
        User user = userService.findById(id);

        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setBirthDate(user.getBirthDate());
        userDto.setName(user.getName());
        userDto.setProfileUrl(user.getProfileUrl());
        userDto.setSex(user.getSex());

        return userDto;
    }

    @RequestMapping(value = "/uploadProfile", method = RequestMethod.POST)
    @ResponseBody
    public String uploadProfileImage(@RequestParam(value = "profileImage", required = true) MultipartFile profileImage, @RequestParam(value = "fileName", required = true) byte[] fileName) {
//        String encodedFileName = new String(fileName, Charset.forName("UTF-8"));
//
//        DateTime nowTime = DateTime.now();
//
//        String destination = "http://" + ServerUtils.getSERVER_IP() + "/";

        File imageFileDir = new File("~/Document/neighborhood/images/profile/");
        if (!imageFileDir.exists()) {
            imageFileDir.mkdir();
        }

        try {
            profileImage.transferTo(new File(String.format("%s", imageFileDir)));
        } catch (IOException e) {
            log.error("Profile Image Upload Fail! ", e);
        }

        return "success";
    }

    private String successResponse(Authentication authentication) throws JsonProcessingException {
        return objectMapper.writeValueAsString(authentication);
    }
}
