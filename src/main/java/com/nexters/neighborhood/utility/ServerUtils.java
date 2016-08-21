package com.nexters.neighborhood.utility;

/**
 * Created by Dark on 2016. 8. 21..
 */
public class ServerUtils {

    private static final String SERVER_IP = "52.78.120.152";

    public static String makeProfileImageUrl(String url) {
        return String.format("http://%s/profile/%s", SERVER_IP, url);
    }

    public static String makeArticleMainImageUrl(String url) {
        return String.format("http://%s/article/%s", SERVER_IP, url);
    }
}
