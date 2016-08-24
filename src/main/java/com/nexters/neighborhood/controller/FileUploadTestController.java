package com.nexters.neighborhood.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Dark on 2016. 8. 22..
 */
@Controller
public class FileUploadTestController {

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/signUpTest")
    public String signUpTest() {
        return "upload";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/writeArticleTest")
    public String writeArticleTest() {
        return "article";
    }
}
