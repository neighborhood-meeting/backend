package com.nexters.neighborhood.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created by Dark on 2016. 8. 21..
 */
@Data
public class ArticleDto {
    private Long articleId;
    private String name;
    private String contents;
    private Long viewCount;
    private String articleMainImageUrl;
    private Integer commentCount;
    private Date createdAt;
    private Writer writer;
    @JsonProperty("category")
    private CategoryDto category;
    @JsonProperty("participation")
    private ParticipationDto participationDto;
}

