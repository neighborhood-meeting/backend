package com.nexters.neighborhood.repository;

import com.nexters.neighborhood.entity.Article;
import com.nexters.neighborhood.entity.Participation;
import com.nexters.neighborhood.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Dark on 2016. 8. 24..
 */
public interface ParticipationRepository extends JpaRepository<Participation,Long> {
//    List<Participation> findByArticleId(Long id);

//    @Query(value = "SELECT count(*) FROM participation p WHERE p.article_id = ?1", nativeQuery = true)
//    Long findByArticleIdCount(Long id);

//    @Query(value = "SELECT * FROM participation p WHERE p.articleId = :id LIMIT 1", nativeQuery = true)
//    User findByArticleIdOrderParticipatedAt(@Param("id") Long id);
//    List<Participation> findByUserId(Long userId);
}
