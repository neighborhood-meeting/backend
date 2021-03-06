package com.nexters.neighborhood.entity;

import com.google.common.collect.Lists;
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

    private String title;

    private Long categoryId;

    private Long viewCount;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(columnDefinition = "TEXT")
    private String contents;

    private Long regionId;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "userId")
    private User user;

    private String articleMainImageUrl;

    @OneToMany(targetEntity = Comment.class, mappedBy = "articleId")
    private List<Comment> comments = new ArrayList<>();

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }
}
