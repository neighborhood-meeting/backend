package com.nexters.neighborhood.controller.article;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Dark on 2016. 8. 21..
 */
@Data
public class ArticleRequestParam {

    private Long articleId;

    private MultipartFile articleMainImage;
    @NotBlank
    private String title;
    @NotBlank
    private String contents;
    @NotBlank
    private String categoryType;
    @NotNull
    private Long writerId;
    @NotNull
    private Long regionId;
}