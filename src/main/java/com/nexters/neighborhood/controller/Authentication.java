package com.nexters.neighborhood.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

/**
 * Created by Dark on 2016. 8. 13..
 */

@Data
@AllArgsConstructor
public class Authentication {
    private String token;

    public static String issueToken() {
        return String.valueOf(UUID.randomUUID());
    }
}
