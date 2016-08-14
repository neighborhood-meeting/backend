package com.nexters.neighborhood.utility;

import org.springframework.security.authentication.encoding.BasePasswordEncoder;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

/**
 * Created by Dark on 2016. 8. 15..
 */
public class EncryptUtils {

    private static BasePasswordEncoder basePasswordEncoder = new Md5PasswordEncoder();

    private final static String SUFFIX_ENCRYPT_STRING = "neighborhood";

    public static String getEncoededPassword(String password) {
        return basePasswordEncoder.encodePassword(password + SUFFIX_ENCRYPT_STRING, null);
    }
}
