package com.nexters.neighborhood.controller;

import com.nexters.neighborhood.entity.Article;
import com.nexters.neighborhood.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jinhaengji on 2016. 8. 13..
 */

@RestController
@RequestMapping("/api")
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    /** 모든 방 조회 **/
    @RequestMapping(value = "/articles", method = {RequestMethod.GET})
    @ResponseBody
    public List<Article> Articles() {
        return articleRepository.findAll();
    }

    /** 글 생성 **/
    @RequestMapping(value = "/articles", method = {RequestMethod.POST})
    @ResponseBody
    public String articles(@RequestBody Article article) {
        articleRepository.save(article);

        return article.toString();
    }

    /** 해당하는 방 정보 조회 **/
    @RequestMapping(value = "/articles/{id}", method = {RequestMethod.GET})
    @ResponseBody
    public Article articles(@PathVariable Long id) {
        return articleRepository.findOne(id);
    }

    /** 해당하는 방 삭제 **/
    @RequestMapping(value = "/articles/{id}", method = {RequestMethod.DELETE})
    @ResponseBody
    public String articleDelete(@PathVariable Long id) {
        Article article = articleRepository.findOne(id);
        articleRepository.delete(article);

        return "success!";
    }

    /** 해당 방 수정 **/
    @RequestMapping(value = "/articles/{id}", method = {RequestMethod.PUT})
    @ResponseBody
    public String articleModify(@PathVariable Long id, @RequestBody Article article) {
        Article savedarticle = articleRepository.findOne(id);

        if(article.getName()!=null) {
            article.setName(article.getName());
        }
        if(article.getCategoryId()!=null) {
            article.setCategoryId(article.getCategoryId());
        }
        if(article.getWriterId()!=null) {
            article.setWriterId(article.getWriterId());
        }
        if(article.getCreationDate()!=null) {
            article.setCreationDate(article.getCreationDate());
        }
        if(article.getCommentId()!=null) {
            article.setCommentId(article.getCommentId());
        }
        if(article.getViewCount()!=null) {
            article.setViewCount(article.getViewCount());
        }
        if(article.getContents()!=null) {
            article.setContents(article.getContents());
        }

        articleRepository.save(savedarticle);

        return savedarticle.toString();
    }
}
