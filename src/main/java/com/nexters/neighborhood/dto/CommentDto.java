package com.nexters.neighborhood.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Dark on 2016. 8. 20..
 */
@Data
public class CommentDto {

    private Long commentId;

    private Date createdAt;

    private String contents;

    private Writer writer;

    private Long articleId;
}
