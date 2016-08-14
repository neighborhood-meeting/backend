package com.nexters.neighborhood.repository;

import com.nexters.neighborhood.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, String> {
    User findByIdAndPassword(String id, String password);

    /** Native Query Sample **/
    @Query(value = "SELECT * FROM users u WHERE u.id = ?1 AND u.password = ?2", nativeQuery = true)
    User findTest(String id, String password);
}
