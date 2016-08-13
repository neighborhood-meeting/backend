package com.nexters.neighborhood.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.encoding.BasePasswordEncoder;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(nullable = false)
    private String token;

    @Column(nullable = false, unique = true)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String sex;

    @Column
    private String birthDate;

    @Column
    private String regionId;

    @Column
    private String roomId;

    @Transient
    private BasePasswordEncoder basePasswordEncoder = new Md5PasswordEncoder();

    public void setPassword(String password) {
        this.password = basePasswordEncoder.encodePassword(password, null);
    }
}
