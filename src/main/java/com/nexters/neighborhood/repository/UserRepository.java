package com.nexters.neighborhood.repository;

import com.nexters.neighborhood.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByIdAndPassword(String id, String password);
}
