package com.nexters.neighborhood.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by jinhaengji on 2016. 8. 6..
 */
@Entity
public class Sample {

    @Id
    private String userId;

    private String name;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
