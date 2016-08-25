package com.nexters.neighborhood.service;

import com.google.common.collect.Lists;
import com.nexters.neighborhood.controller.article.ArticleRequestParam;
import com.nexters.neighborhood.controller.article.ParticipateRequestParam;
import com.nexters.neighborhood.dto.ArticleDto;
import com.nexters.neighborhood.dto.CategoryDto;
import com.nexters.neighborhood.dto.ParticipationDto;
import com.nexters.neighborhood.dto.Writer;
import com.nexters.neighborhood.entity.Article;
import com.nexters.neighborhood.entity.Category;
import com.nexters.neighborhood.entity.Participation;
import com.nexters.neighborhood.entity.User;
import com.nexters.neighborhood.repository.ArticleRepository;
import com.nexters.neighborhood.repository.CategoryRepository;
import com.nexters.neighborhood.repository.ParticipationRepository;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ParticipationRepository participationRepository;

    @Autowired
    private ImageService imageService;

    public List<ArticleDto> findArticleDtoByRegionId(Long regionId) {
        List<Article> articles = articleRepository.findByRegionId(regionId);

        List<ArticleDto> articleDtos = Lists.newArrayList();

        for (Article article : articles) {
            ArticleDto articleDto = new ArticleDto();

            setArticle(article, articleDto);
            setWriter(article, articleDto);
            setCategory(article.getCategoryId(), articleDto);
            setParticipation(article, articleDto);

            articleDtos.add(articleDto);
        }

        return articleDtos;
    }

    public void save(ArticleRequestParam articleRequestParam) {
        Article article = new Article();

        article.setTitle(articleRequestParam.getTitle());
        article.setArticleMainImageUrl(imageService.uploadArticleMainImage(articleRequestParam.getArticleMainImage()));
        Category category = categoryRepository.findByType(articleRequestParam.getCategoryType());
        log.error("category!!!:" + category);
        article.setCategoryId(category.getId());
        article.setContents(articleRequestParam.getContents());
        article.setRegionId(articleRequestParam.getRegionId());
        article.setUser(userRepository.findOne(articleRequestParam.getWriterId()));
        article.setViewCount(0L);

        articleRepository.saveAndFlush(article);
    }

    public List<ArticleDto> findByRegionIdAndCategoryType(Long regionId, String type) {
        Category category = categoryRepository.findByType(type);
        List<Article> articles = articleRepository.findByRegionIdAndCategoryId(regionId, category.getId());

        List<ArticleDto> articleDtos = Lists.newArrayList();

        for (Article article : articles) {
            ArticleDto articleDto = new ArticleDto();

            setArticle(article, articleDto);
            setWriter(article, articleDto);
            setCategory(article.getCategoryId(), articleDto);

            articleDtos.add(articleDto);
        }

        return articleDtos;
    }

    public void participate(ParticipateRequestParam participateRequestParam) {
        User user = userRepository.findOne(participateRequestParam.getUserId());
        Article article = articleRepository.findOne(participateRequestParam.getArticleId());

        Participation savedParticipation = article.getParticipation();

        if (savedParticipation == null) {
            Participation participation = new Participation();
            participation.addParticipantCount();
            participation.setRecentParticipatedUser(user);

            article.setParticipation(participation);

            participationRepository.save(participation);

            articleRepository.save(article);

            return;
        }

        savedParticipation.addParticipantCount();
        savedParticipation.setRecentParticipatedUser(user);

        articleRepository.save(article);
    }

    public List<ArticleDto> findByUserId(Long userId) {
        List<Article> articles = articleRepository.findByUserId(userId);

        List<ArticleDto> articleDtos = mappingArticleDto(articles);

        return articleDtos;
    }

    public List<ArticleDto> findLikeTitle(String title) {
        List<Article> articles = articleRepository.findLikeTitle(title);

        return mappingArticleDto(articles);
    }


    private void setParticipation(Article article, ArticleDto articleDto) {
        Participation participation = article.getParticipation();

        if (participation == null) {
            ParticipationDto participationDto = new ParticipationDto();
            participationDto.setParticipantCount(0L);
            participationDto.setRecentParticipatedUserName(null);
            articleDto.setParticipationDto(participationDto);
            return;
        }

        ParticipationDto participationDto = new ParticipationDto();
        participationDto.setParticipantCount(participation.getParticipantCount());
        participationDto.setRecentParticipatedUserName(participation.getRecentParticipatedUser().getName());
        articleDto.setParticipationDto(participationDto);
    }

    private void setCategory(Long categoryId, ArticleDto articleDto) {
        Category category = categoryRepository.findOne(categoryId);

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryId(category.getId());
        categoryDto.setType(category.getType());

        articleDto.setCategory(categoryDto);
    }

    private void setArticle(Article article, ArticleDto articleDto) {
        articleDto.setTitle(article.getTitle());
        articleDto.setArticleId(article.getId());
        articleDto.setArticleMainImageUrl(article.getArticleMainImageUrl());
        articleDto.setCommentCount(article.getComments().size());
        articleDto.setContents(article.getContents());
        articleDto.setCreatedAt(article.getCreatedAt());
        articleDto.setViewCount(article.getViewCount());
    }

    private void setWriter(Article article, ArticleDto articleDto) {
        Writer writer = new Writer();

        User user = article.getUser();
        writer.setName(user.getName());
        writer.setProfileUrl(user.getProfileUrl());
        writer.setUserId(user.getId());

        articleDto.setWriter(writer);
    }


    private List<ArticleDto> mappingArticleDto(List<Article> articles) {
        List<ArticleDto> articleDtos = Lists.newArrayList();

        for (Article article : articles) {
            ArticleDto articleDto = new ArticleDto();

            setParticipationDto(article, articleDto);

            articleDto.setTitle(article.getTitle());
            setCategoryDto(article, articleDto);
            setWriter(article, articleDto);

            articleDto.setCreatedAt(article.getCreatedAt());
            articleDto.setArticleId(article.getId());
            articleDto.setArticleMainImageUrl(article.getArticleMainImageUrl());
            articleDto.setCommentCount(article.getComments().size());
            articleDto.setContents(article.getContents());
            articleDto.setViewCount(article.getViewCount());

            articleDtos.add(articleDto);
        }
        return articleDtos;
    }

    private void setCategoryDto(Article article, ArticleDto articleDto) {
        Category category = categoryRepository.findOne(article.getCategoryId());
        CategoryDto category1 = new CategoryDto();
        category1.setCategoryId(category.getId());
        category1.setType(category.getType());
        articleDto.setCategory(category1);
    }

    private void setParticipationDto(Article article, ArticleDto articleDto) {
        Participation participation = article.getParticipation();

        if (participation == null) {
            ParticipationDto participationDto = new ParticipationDto();
            participationDto.setRecentParticipatedUserName(null);
            participationDto.setParticipantCount(0L);

            articleDto.setParticipationDto(participationDto);
            return;
        }

        ParticipationDto participationDto = new ParticipationDto();
        participationDto.setRecentParticipatedUserName(participation.getRecentParticipatedUser().getName());
        participationDto.setParticipantCount(participation.getParticipantCount());

        articleDto.setParticipationDto(participationDto);
    }
}
