package com.nexters.neighborhood.controller.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nexters.neighborhood.exception.InvalidAccessException;
import com.nexters.neighborhood.exception.SignUpFailException;
import com.nexters.neighborhood.dto.Authentication;
import com.nexters.neighborhood.dto.UserEmailAndPassword;
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
    public ResponseEntity<UserDto> signIn(@RequestBody UserEmailAndPassword userEmailAndPassword) throws InvalidAccessException, JsonProcessingException {
        UserDto userDto = userService.signIn(userEmailAndPassword.getEmail(), EncryptUtils.getEncoededPassword(userEmailAndPassword.getPassword()));

        return ResponseEntity.ok(userDto);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signUp")
    @ResponseBody
    public ResponseEntity<String> signUp(@ModelAttribute UserRequestParam userRequestParam) throws SignUpFailException {
        try {
            userRequestParam.setPassword(EncryptUtils.getEncoededPassword(userRequestParam.getPassword()));

            Authentication authentication = userService.save(userRequestParam);

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