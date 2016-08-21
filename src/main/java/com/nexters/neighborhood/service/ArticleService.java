package com.nexters.neighborhood.service;

import com.google.common.collect.Lists;
import com.nexters.neighborhood.controller.model.ArticleRequestParam;
import com.nexters.neighborhood.dto.ArticleDto;
import com.nexters.neighborhood.dto.Writer;
import com.nexters.neighborhood.entity.Article;
import com.nexters.neighborhood.entity.User;
import com.nexters.neighborhood.repository.ArticleRepository;
import com.nexters.neighborhood.repository.UserRepository;
import com.nexters.neighborhood.utility.ServerUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by Dark on 2016. 8. 21..
 */
@Slf4j
@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserRepository userRepository;

    public List<ArticleDto> findArticleDtoByRegionId(Long regionId) {
        List<Article> articles = articleRepository.findByRegionId(regionId);

        List<ArticleDto> articleDtos = Lists.newArrayList();

        for (Article article : articles) {
            ArticleDto articleDto = new ArticleDto();

            articleDto.setName(article.getName());
            articleDto.setArticleId(article.getId());
            articleDto.setArticleMainImage(article.getArticleMainImage());
            articleDto.setCommentCount(article.getComments().size());
            articleDto.setContent(article.getContents());
            articleDto.setCreatedAt(article.getCreatedAt());
            articleDto.setViewCount(article.getViewCount());

            Writer writer = new Writer();

            User user = article.getUser();
            writer.setName(user.getName());
            writer.setProfileUrl(user.getProfileUrl());
            writer.setUserId(user.getId());

            articleDto.setWriter(writer);

            articleDtos.add(articleDto);
        }

        return articleDtos;
    }

    public void save(ArticleRequestParam articleRequestParam) {
        Article article = new Article();

        article.setName(articleRequestParam.getName());
        article.setCreatedAt(articleRequestParam.getCreatedAt());
        article.setArticleMainImage(ServerUtils.makeImageUrl(articleRequestParam.getArticleMainImage()));
        article.setCategoryId(articleRequestParam.getCategoryId());
        article.setContents(articleRequestParam.getContents());
        article.setRegionId(articleRequestParam.getRegionId());
        article.setUser(userRepository.findOne(articleRequestParam.getWriterId()));
        article.setViewCount(0L);

        articleRepository.saveAndFlush(article);
    }
}
