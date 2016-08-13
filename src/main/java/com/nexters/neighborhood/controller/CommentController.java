package com.nexters.neighborhood.controller;



import com.nexters.neighborhood.entity.Comment;
import com.nexters.neighborhood.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by jinhaengji on 2016. 8. 13..
 */

@RestController
@RequestMapping("/api")
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;

    /** 댓글 조회 **/
    @RequestMapping(value = "/comments/{id}", method = {RequestMethod.GET})
    @ResponseBody
    public Comment comments(@PathVariable Long id) {
        return commentRepository.findOne(id);
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
