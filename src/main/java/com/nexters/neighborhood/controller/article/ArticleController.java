package com.nexters.neighborhood.controller.article;

import com.nexters.neighborhood.dto.ArticleDto;
import com.nexters.neighborhood.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/articles", method = {RequestMethod.GET})
    @ResponseBody
    public List<ArticleDto> findArticlesByRegionId(@RequestParam Long regionId) {
        return articleService.findArticleDtoByRegionId(regionId);
    }

    /** 글 생성 **/
    @RequestMapping(value = "/articles", method = {RequestMethod.POST})
    @ResponseBody
    public String articles(@ModelAttribute ArticleRequestParam article) {
        articleService.save(article);

        return article.toString();
    }

    @RequestMapping(value = "/articles/search", method = {RequestMethod.GET})
    @ResponseBody
    public List<ArticleDto> findByRegionIdAndCategoryType(@RequestParam Long regionId, @RequestParam String type) {
        return articleService.findByRegionIdAndCategoryType(regionId, type);
    }

    @RequestMapping(value = "/articles/participate", method = {RequestMethod.POST})
    @ResponseBody
    public String participate(@RequestBody ParticipateRequestParam participateRequestParam) {
        articleService.participate(participateRequestParam);

        return "success";
    }
}