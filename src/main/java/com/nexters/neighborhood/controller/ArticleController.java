package com.nexters.neighborhood.controller;

import com.google.common.collect.Lists;
import com.nexters.neighborhood.controller.model.ArticleRequestParam;
import com.nexters.neighborhood.dto.ArticleDto;
import com.nexters.neighborhood.entity.Article;
import com.nexters.neighborhood.service.ArticleService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by jinhaengji on 2016. 8. 13..
 */

@RestController
@RequestMapping("/api/v1")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/articles", method = {RequestMethod.GET})
    @ResponseBody
    public List<ArticleDto> findArticlesByRegionId(@RequestParam Long regionId) {
        return articleService.findArticleDtoByRegionId(regionId);
    }

    /** 글 생성 **/
    @RequestMapping(value = "/articles", method = {RequestMethod.POST})
    @ResponseBody
    public String articles(@RequestBody ArticleRequestParam article) {
        articleService.save(article);

        return article.toString();
    }

    @RequestMapping(value = "/articles/search", method = {RequestMethod.GET})
    @ResponseBody
    public List<ArticleDto> findByRegionIdAndCategoryType(@RequestParam Long regionId, @RequestParam String type) {
        return articleService.findByRegionIdAndCategoryType(regionId, type);
    }

//    /** 모든 방 조회 **/
//    @RequestMapping(value = "/articles", method = {RequestMethod.GET})
//    @ResponseBody
//    public List<Article> Articles() {
//        return articleRepository.findAll();
//    }
//

//
//    /** 해당하는 방 정보 조회 **/
//    @RequestMapping(value = "/articles/{id}", method = {RequestMethod.GET})
//    @ResponseBody
//    public Article articles(@PathVariable Long id) {
//        return articleRepository.findOne(id);
//    }
//
//    /** 해당하는 방 삭제 **/
//    @RequestMapping(value = "/articles/{id}", method = {RequestMethod.DELETE})
//    @ResponseBody
//    public String articleDelete(@PathVariable Long id) {
//        Article article = articleRepository.findOne(id);
//        articleRepository.delete(article);
//
//        return "success!";
//    }
}

