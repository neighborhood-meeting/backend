package com.nexters.neighborhood.repository;

import com.nexters.neighborhood.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jinhaengji on 2016. 8. 13..
 */
public interface ArticleRepository extends JpaRepository<Article, Long>{
}
