package com.nexters.neighborhood.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nexters.neighborhood.controller.exception.InvalidAccessException;
import com.nexters.neighborhood.controller.exception.SignUpFailException;
import com.nexters.neighborhood.controller.model.Authentication;
import com.nexters.neighborhood.controller.model.IdAndPassword;
import com.nexters.neighborhood.utility.EncryptUtils;
import com.nexters.neighborhood.entity.User;
import com.nexters.neighborhood.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(method = RequestMethod.POST, value = "/signIn")
    @ResponseBody
    public ResponseEntity<String> signIn(@RequestBody IdAndPassword idAndPassword) throws InvalidAccessException, JsonProcessingException {
        Authentication authentication = userService.signIn(idAndPassword.getId(), EncryptUtils.getEncoededPassword(idAndPassword.getPassword()));

        return ResponseEntity.status(HttpStatus.OK).body(successResponse(authentication));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signUp")
    @ResponseBody
    public ResponseEntity<String> signUp(@RequestBody User user) throws SignUpFailException {
        try {
            user.setPassword(EncryptUtils.getEncoededPassword(user.getPassword()));

            Authentication authentication = userService.save(user);

            return ResponseEntity.status(HttpStatus.OK).body(successResponse(authentication));
        } catch (Exception ignored) {
            log.error("UserController SignUp Exception!", ignored);

            throw new SignUpFailException();
        }
    }

    private String successResponse(Authentication authentication) throws JsonProcessingException {
        return objectMapper.writeValueAsString(authentication);
    }
}
