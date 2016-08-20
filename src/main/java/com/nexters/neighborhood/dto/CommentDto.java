package com.nexters.neighborhood.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Dark on 2016. 8. 20..
 */
@Data
public class CommentDto {

    private Long id;

    private Date creationDate;

    private String contents;

    private String writer;

    private Long articleId;
}
