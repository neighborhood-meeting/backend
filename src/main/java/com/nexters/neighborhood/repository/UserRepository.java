package com.nexters.neighborhood.repository;

import com.nexters.neighborhood.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUserIdAndPassword(String id, String password);

//    @Query(value = "SELECT * FROM users u WHERE u.token = ?1", nativeQuery = true)
//    User findByToken(String token);
}
