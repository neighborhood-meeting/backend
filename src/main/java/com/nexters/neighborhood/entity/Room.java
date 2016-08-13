package com.nexters.neighborhood.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by jinhaengji on 2016. 8. 13..
 */

@Data
@Entity
public class Room {

    @Id
    private Long id;
    private String name;
    private String ownerId;
    private String description;
    private Long articleId;
    private String notice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }
}
