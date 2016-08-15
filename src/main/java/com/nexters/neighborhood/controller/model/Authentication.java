package com.nexters.neighborhood.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

/**
 * Created by Dark on 2016. 8. 13..
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Authentication {
    private String token;

    public static String issueToken() {
        return String.valueOf(UUID.randomUUID());
    }
}