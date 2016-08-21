package com.nexters.neighborhood.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by jinhaengji on 2016. 8. 13..
 */

@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdAt;

    private String contents;

    private Long userId;

    private Long articleId;

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }
}
