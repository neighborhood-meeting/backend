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
    @Query(value = "SELECT * FROM participation p WHERE p.article_id = ?1", nativeQuery = true)
    List<Participation> findByArticleId(Long articleId);

    @Query(value = "SELECT count(*) FROM participation p WHERE p.article_id = ?1", nativeQuery = true)
    Long findByArticleIdCount(Long id);

    @Query(value = "SELECT * FROM participation p WHERE p.article_id = :id order by participated_at desc limit 1", nativeQuery = true)
    Participation findByArticleIdOrderParticipatedAt(@Param("id") Long id);

    @Query(value = "SELECT * FROM participation p WHERE p.article_id = :articleId AND p.user_id = :userId", nativeQuery = true)
    Participation findByUserIdAndArticleId(@Param("userId") Long userId, @Param("articleId")Long articleId);
}
