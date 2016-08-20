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
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> signIn(@RequestBody UserEmailAndPassword userEmailAndPassword) throws InvalidAccessException, JsonProcessingException {
        Authentication authentication = userService.signIn(userEmailAndPassword.getEmail(), EncryptUtils.getEncoededPassword(userEmailAndPassword.getPassword()));

        return ResponseEntity.ok(successResponse(authentication));
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

    private String successResponse(Authentication authentication) throws JsonProcessingException {
        return objectMapper.writeValueAsString(authentication);
    }
}
