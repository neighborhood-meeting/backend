package com.nexters.neighborhood.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jinhaengji on 2016. 8. 13..
 */
@Data
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String categoryId;

    private String userId;

    private Long viewCount;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date creationDate;

    private String contents;

    private Long regionId;

    private String imageUrl;

    @OneToMany(targetEntity = Comment.class, mappedBy = "articleId")
    private List<Comment> comments = new ArrayList<>();

    @PrePersist
    void createdAt() {
        this.creationDate = new Date();
    }
}
