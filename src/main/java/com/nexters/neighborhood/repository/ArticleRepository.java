package com.nexters.neighborhood.repository;

import com.nexters.neighborhood.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by jinhaengji on 2016. 8. 13..
 */
public interface ArticleRepository extends JpaRepository<Article, Long>{

    List<Article> findByRegionId(Long regionId);

    List<Article> findByRegionIdAndCategoryId(Long regionId, Long id);
}
