package com.nexters.neighborhood.controller;

import com.nexters.neighborhood.dto.CommentDto;
import com.nexters.neighborhood.service.CommentService;
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
    private CommentService commentService;

    /** 댓글 조회 **/
    @RequestMapping(value = "/comments", method = {RequestMethod.GET})
    @ResponseBody
    public List<CommentDto> comments(@RequestParam Long articleId) {
        return commentService.findByArticleId(articleId);
    }
}
