package com.nexters.neighborhood.repository;

import com.nexters.neighborhood.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by jinhaengji on 2016. 8. 13..
 */
public interface ArticleRepository extends JpaRepository<Article, Long>{

    @Query(value = "SELECT * FROM article a WHERE a.region_id = :regionId order by created_at desc", nativeQuery = true)
    List<Article> findByRegionId(@Param("regionId") Long regionId);

    List<Article> findByRegionIdAndCategoryId(Long regionId, Long id);

    List<Article> findByUserId(Long userId);

    @Query(value = "SELECT * FROM article a WHERE a.title LIKE CONCAT('%',:title,'%')", nativeQuery = true)
    List<Article> findLikeTitle(@Param("title") String title);
}
