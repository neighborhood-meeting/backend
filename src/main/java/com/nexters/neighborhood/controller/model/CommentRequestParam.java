package com.nexters.neighborhood.controller.model;

import lombok.Data;

/**
 * Created by Dark on 2016. 8. 23..
 */
@Data
public class CommentRequestParam {

    private String contents;

    private Long userId;

    private Long articleId;
}