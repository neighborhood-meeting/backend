package com.nexters.neighborhood.repository;

import com.nexters.neighborhood.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jinhaengji on 2016. 8. 13..
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByType(String type);
}
