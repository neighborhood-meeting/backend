package com.nexters.neighborhood.controller.article;

import com.nexters.neighborhood.dto.ArticleDto;
import com.nexters.neighborhood.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by jinhaengji on 2016. 8. 13..
 */

@RestController
@RequestMapping("/api/v1")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /** regionId를 통한 Article 목록 가져오기 **/
    @RequestMapping(value = "/articles/regions/{regionId}", method = {RequestMethod.GET})
    @ResponseBody
    public List<ArticleDto> findArticlesByRegionId(@PathVariable Long regionId) {
        return articleService.findArticleDtoByRegionId(regionId);
    }

    /** userId를 통한 Article 목록 가져오기 **/
    @RequestMapping(value = "/articles/users/{userId}", method = {RequestMethod.GET})
    @ResponseBody
    public List<ArticleDto> findArticlesByUserId(@PathVariable Long userId) {
        return articleService.findByUserId(userId);
    }

    /** 글 생성 **/
    @RequestMapping(value = "/articles", method = {RequestMethod.POST})
    @ResponseBody
    public String postArticle(@ModelAttribute ArticleRequestParam article) {
        articleService.save(article);

        return article.toString();
    }

    /** 글 생성 **/
    @RequestMapping(value = "/articles/update", method = {RequestMethod.POST})
    @ResponseBody
    public String putArticle(@ModelAttribute ArticleRequestParam article) {
        articleService.update(article);

        return article.toString();
    }

    /** 왼쪽 메뉴 Category별 검색 **/
    @RequestMapping(value = "/articles/search", method = {RequestMethod.GET})
    @ResponseBody
    public List<ArticleDto> findByRegionIdAndCategoryType(@RequestParam Long regionId, @RequestParam String type) {
        return articleService.findByRegionIdAndCategoryType(regionId, type);
    }

    /** Title like 검색 **/
    @RequestMapping(value = "/articles/search/title/{title}", method = {RequestMethod.GET})
    @ResponseBody
    public List<ArticleDto> findLikeTitle(@PathVariable String title) {
        return articleService.findLikeTitle(title);
    }

    /** 글 참여하기 **/
    @RequestMapping(value = "/articles/participate", method = {RequestMethod.POST})
    @ResponseBody
    public String participate(@RequestBody ParticipateRequestParam participateRequestParam) {
//        if (articleService.isAlreadyParticipated(participateRequestParam)) {
//            return "delete participated user";
//        } else {
        articleService.participate(participateRequestParam);
//        }

        return "success";
    }
}