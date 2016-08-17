package com.nexters.neighborhood.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Dark on 2016. 8. 15..
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserIdAndPassword {
    private String userId;
    private String password;
}
