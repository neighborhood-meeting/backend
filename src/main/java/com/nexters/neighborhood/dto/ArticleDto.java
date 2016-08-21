package com.nexters.neighborhood.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created by Dark on 2016. 8. 21..
 */
@Data
public class ArticleDto {
    private Long articleId;
    private String name;
    private String content;
    private Long viewCount;
    private String articleMainImage;
    private Integer commentCount;
    private Date createdAt;
    private Writer writer;
}

