package com.nexters.neighborhood.controller.article;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * Created by Dark on 2016. 8. 21..
 */
@Data
public class ArticleRequestParam {

    private MultipartFile articleMainImage;
    private String title;
    private String contents;
    private Long categoryId;
    private Long writerId;
    private Long regionId;
}