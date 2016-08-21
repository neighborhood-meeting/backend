package com.nexters.neighborhood.utility;

/**
 * Created by Dark on 2016. 8. 21..
 */
public class ServerUtils {

    private static final String SERVER_IP = "52.78.120.152";

    public static String makeImageUrl(String url) {
        return String.format("http://%s/%s", SERVER_IP, url);
    }
}
