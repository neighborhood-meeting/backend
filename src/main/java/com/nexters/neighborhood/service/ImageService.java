package com.nexters.neighborhood.service;

import com.nexters.neighborhood.utility.ServerUtils;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Dark on 2016. 8. 24..
 */
@Slf4j
@Service
public class ImageService {

    private static final String DEFAULT_IMAGES_ROOT_FILE_PATH = "/neighborhood/images";

    private static final String PROFILE_FILE_PATH = "/profile";
    private static final String ARTICLE_FILE_PATH = "/article";

    private static final String DEFAULT_IMAGE = "iu.jpg";

    public String uploadProfileImage(MultipartFile profileImage) {
        return upload(PROFILE_FILE_PATH, profileImage);
    }

    public String uploadArticleMainImage(MultipartFile profileImage) {
        return upload(ARTICLE_FILE_PATH, profileImage);
    }

    private String upload(String profileFilePath, MultipartFile profileImage) {
        DateTime nowTime = DateTime.now();

        String profilePreUrl = String.format(profileFilePath + "/%s", nowTime.toString("yyMMdd"));
        String profileSuffixUrl = UUID.randomUUID().toString().replaceAll("-", "");

        imageDirectoryRolling(profileFilePath);

        String imageFileDirectory = String.format("%s/%s", DEFAULT_IMAGES_ROOT_FILE_PATH, profilePreUrl);

        try {
            File file = new File(String.format("%s/%s", imageFileDirectory, profileSuffixUrl + ".jpg"));

            if (profileImage == null) {
                return "http://" + ServerUtils.getSERVER_IP() + "profile/" + DEFAULT_IMAGE;
            } else {
                profileImage.transferTo(file);
                return "http://" + ServerUtils.getSERVER_IP() + "" + profilePreUrl + "/" + profileSuffixUrl + ".jpg";
            }
        } catch (IOException e) {
            log.error("Profile Image Upload Fail! ", e);
            return null;
        }
    }

    private void imageDirectoryRolling(String profileFilePath) {
        DateTime nowTime = DateTime.now();

        File imageFileDirectory = new File(String.format("%s/%s", DEFAULT_IMAGES_ROOT_FILE_PATH, String.format(profileFilePath + "/%s", nowTime.toString("yyMMdd"))));

        if (!imageFileDirectory.exists()) {
            imageFileDirectory.mkdir();
        }
    }
}
