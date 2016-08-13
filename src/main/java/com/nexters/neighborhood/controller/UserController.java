package com.nexters.neighborhood.controller;

import com.nexters.neighborhood.entity.User;
import com.nexters.neighborhood.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    @ResponseBody
    public Authentication login(@RequestBody User user) {
        return userService.login(user);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signUp")
    @ResponseBody
    public Authentication signUp(@RequestBody User user) {
        Authentication authentication = userService.save(user);

        return authentication;
    }
}
