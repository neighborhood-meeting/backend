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

    @Query(value = "SELECT * FROM article a WHERE a.region_id = :regionId AND a.category_id = :categoryId order by created_at desc", nativeQuery = true)
    List<Article> findByRegionIdAndCategoryId(@Param("regionId") Long regionId,@Param("categoryId") Long categoryId);

    @Query(value = "SELECT * FROM article a WHERE a.user_id = :userId order by created_at desc", nativeQuery = true)
    List<Article> findByUserId(@Param("userId") Long userId);

    @Query(value = "SELECT * FROM article a WHERE a.title LIKE CONCAT('%',:title,'%') order by created_at desc", nativeQuery = true)
    List<Article> findLikeTitle(@Param("title") String title);
}
