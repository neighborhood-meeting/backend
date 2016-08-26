package com.nexters.neighborhood.service;

import com.google.common.collect.Lists;
import com.nexters.neighborhood.controller.comment.CommentRequestParam;
import com.nexters.neighborhood.dto.CommentDto;
import com.nexters.neighborhood.dto.Writer;
import com.nexters.neighborhood.entity.Comment;
import com.nexters.neighborhood.entity.User;
import com.nexters.neighborhood.repository.CommentRepository;
import com.nexters.neighborhood.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dark on 2016. 8. 21..
 */
@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    public List<CommentDto> findByArticleId(Long articleId) {
        List<Comment> comments = commentRepository.findByArticleId(articleId);

        List<CommentDto> commentDtos = Lists.newArrayList();

        for (Comment comment : comments) {
            CommentDto commentDto = new CommentDto();

            commentDto.setCommentId(comment.getId());
            commentDto.setContents(comment.getContents());
            commentDto.setCreatedAt(comment.getCreatedAt());
            commentDto.setArticleId(comment.getArticleId());

            User user = userRepository.findOne(comment.getUserId());

            Writer writer = new Writer();
            writer.setUserId(user.getId());
            writer.setProfileUrl(user.getProfileUrl());
            writer.setName(user.getName());

            commentDto.setWriter(writer);

            commentDtos.add(commentDto);
        }

        return commentDtos;
    }

    public void save(CommentRequestParam commentRequestParam) {
        Comment comment = new Comment();

        comment.setArticleId(commentRequestParam.getArticleId());
        comment.setContents(commentRequestParam.getContents());
        comment.setUserId(commentRequestParam.getUserId());

        commentRepository.save(comment);
    }

    public void update(CommentRequestParam commentRequestParam) {
        Comment comment = commentRepository.findOne(commentRequestParam.getCommentId());

        comment.setUserId(commentRequestParam.getUserId());
        comment.setArticleId(commentRequestParam.getArticleId());
        comment.setContents(commentRequestParam.getContents());

        commentRepository.saveAndFlush(comment);
    }
}