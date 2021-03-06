package com.nexters.neighborhood.entity;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String token;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String sex;

    private String birthDate;

    private String profileUrl;

    @Column
    @ManyToMany
    @JoinTable(name = "USER_REGION",
        joinColumns = @JoinColumn(name = "USER_ID"),
        inverseJoinColumns = @JoinColumn(name = "REGION_ID"))
    private List<Region> regions = Lists.newArrayList();

    @OneToMany(targetEntity = Comment.class, mappedBy = "userId")
    private List<Comment> comments = Lists.newArrayList();

    public void addRegion(Region region) {
        regions.add(region);
    }
}