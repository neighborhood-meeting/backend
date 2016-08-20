package com.nexters.neighborhood.controller;

import com.google.common.collect.Lists;
import com.nexters.neighborhood.dto.CommentDto;
import com.nexters.neighborhood.entity.Comment;
import com.nexters.neighborhood.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by jinhaengji on 2016. 8. 13..
 */

@RestController
@RequestMapping("/api/v1")
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;

    /** 댓글 조회 **/
    @RequestMapping(value = "/comments", method = {RequestMethod.GET})
    @ResponseBody
    public List<CommentDto> comments(@RequestParam Long articleId) {
        List<Comment> comments = commentRepository.findByArticleId(articleId);

        List<CommentDto> commentDtos = Lists.newArrayList();

        return commentDtos;
    }

    /** 댓글 작성 **/
    @RequestMapping(value = "/comments", method = {RequestMethod.POST})
    @ResponseBody
    public String comments(@RequestBody Comment comment) {
        commentRepository.save(comment);

        return comment.toString();
    }

    /**  **/
}
