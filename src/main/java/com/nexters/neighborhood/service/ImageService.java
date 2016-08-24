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

    private static final String DEFAULT_IMAGES_FILE_PATH = "/root/neighborhood/images";

    public String uploadProfileImage(MultipartFile profileImage) {
        DateTime nowTime = DateTime.now();

        String profilePreUrl = String.format("/profile/%s", nowTime.toString("yyMMdd"));
        String profileSuffixUrl = UUID.randomUUID().toString().replaceAll("-", "");

        profileDirectoryRolling();

        String imageFileDirectory = String.format("%s/%s", DEFAULT_IMAGES_FILE_PATH, profilePreUrl);

        try {
            File file = new File(String.format("%s/%s", imageFileDirectory, profileSuffixUrl + ".jpg"));

            if (!file.canExecute()) {
                log.error("실행 불가능 파일!!!");
            }
            if (!file.canRead()) {
                log.error("읽기 불가능!!");
            }
            if (!file.canWrite()) {
                log.error("쓰기 불가능!!");
            }
            profileImage.transferTo(file);
        } catch (IOException e) {
            log.error("Profile Image Upload Fail! ", e);
            return null;
        }

        return "http://" + ServerUtils.getSERVER_IP() + "" + profilePreUrl + "/" + profileSuffixUrl + ".jpg";
    }

    public String uploadArticleMainImage(MultipartFile profileImage) {
        DateTime nowTime = DateTime.now();

        String profilePreUrl = String.format("/article/%s", nowTime.toString("yyMMdd"));
        String profileSuffixUrl = UUID.randomUUID().toString().replaceAll("-", "");

        profileDirectoryRolling();

        String imageFileDirectory = String.format("%s/%s", DEFAULT_IMAGES_FILE_PATH, profilePreUrl);

        try {
            File file = new File(String.format("%s/%s", imageFileDirectory, profileSuffixUrl + ".jpg"));
            if (!file.canExecute()) {
                log.error("실행 불가능 파일!!!");
            }
            if (!file.canRead()) {
                log.error("읽기 불가능!!");
            }
            if (!file.canWrite()) {
                log.error("쓰기 불가능!!");
            }
            profileImage.transferTo(file);
        } catch (IOException e) {
            log.error("Profile Image Upload Fail! ", e);
            return null;
        }

        return "http://" + ServerUtils.getSERVER_IP() + "" + profilePreUrl + "/" + profileSuffixUrl + ".jpg";
    }

    private void profileDirectoryRolling() {
        DateTime nowTime = DateTime.now();

        File imageFileDirectory = new File(String.format("%s/%s", DEFAULT_IMAGES_FILE_PATH, String.format("/profile/%s", nowTime.toString("yyMMdd"))));

        if (!imageFileDirectory.exists()) {
            imageFileDirectory.mkdir();
        }
    }
}