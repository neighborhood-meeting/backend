package com.nexters.neighborhood.repository;

import com.nexters.neighborhood.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by jinhaengji on 2016. 8. 13..
 */
public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findByArticleId(Long articleId);
}
