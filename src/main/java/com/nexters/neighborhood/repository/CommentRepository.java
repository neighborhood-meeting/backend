package com.nexters.neighborhood.repository;

import com.nexters.neighborhood.entity.Comment;
import com.sun.tools.javac.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jinhaengji on 2016. 8. 13..
 */
public interface CommentRepository extends JpaRepository<Comment,Long> {
}