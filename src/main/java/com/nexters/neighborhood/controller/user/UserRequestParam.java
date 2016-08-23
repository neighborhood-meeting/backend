package com.nexters.neighborhood.controller.user;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * Created by Dark on 2016. 8. 23..
 */
@Data
public class UserRequestParam implements Serializable {

    private String email;

    private String name;

    private String password;

    private String sex;

    private String birthDate;

    private MultipartFile profileImage;
}
