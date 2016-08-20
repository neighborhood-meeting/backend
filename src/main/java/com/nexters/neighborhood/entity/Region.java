package com.nexters.neighborhood.entity;

import com.google.common.collect.Lists;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by jinhaengji on 2016. 8. 13..
 */

@Data
@Entity(name = "regions")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String notice;

    @OneToMany(targetEntity = Article.class, mappedBy = "regionId")
    private List<Article> articles = Lists.newArrayList();

    @ManyToMany(mappedBy="regions")
    private List<User> users = Lists.newArrayList();

    public void addUser(User user) {
        users.add(user);
    }
}
