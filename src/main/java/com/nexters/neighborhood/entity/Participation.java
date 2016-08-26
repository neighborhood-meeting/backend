package com.nexters.neighborhood.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Dark on 2016. 8. 23..
 */
@Data
@Entity
public class Participation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "userId")
    private User participatedUser;

    @ManyToOne(targetEntity = Article.class)
    @JoinColumn(name = "articleId")
    private Article participatedArticle;

    private Date participatedAt;

    @PostPersist
    void participatedAt() {
        participatedAt = new Date();
    }
}
