package com.nexters.neighborhood.dto;

import lombok.Data;

/**
 * Created by Dark on 2016. 8. 20..
 */
@Data
public class UserDto {

    private Long userId;

    private String email;

    private String name;

    private String sex;

    private String birthDate;

    private String profileUrl;

    private String token;
}
