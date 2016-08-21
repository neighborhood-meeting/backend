package com.nexters.neighborhood.controller.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by Dark on 2016. 8. 21..
 */
@Data
public class ArticleRequestParam {

    private String name;
    private Long categoryId;
    private Long writerId;
    private Date createdAt;
    private String contents;
    private Long regionId;
    private String articleMainImage;
    private Long roomId;
}
