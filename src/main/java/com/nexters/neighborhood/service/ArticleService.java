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
            setParticipationDto(article, articleDto);

            articleDtos.add(articleDto);
        }

        return articleDtos;
    }

    public void participate(ParticipateRequestParam participateRequestParam) {
        // 이미 가입한 사람이면 제거 시작
        Participation participation1 = participationRepository.findByUserIdAndArticleId(participateRequestParam.getUserId(), participateRequestParam.getArticleId());

        if (participation1 != null) {
            participationRepository.delete(participation1);
            return;
        }

        // 이미 가입한 사람이면 제거 끝

        User user = userRepository.findOne(participateRequestParam.getUserId());
        Article article = articleRepository.findOne(participateRequestParam.getArticleId());

        Participation participation = new Participation();

        participation.setParticipatedArticle(article);
        participation.setParticipatedUser(user);

        participationRepository.save(participation);
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
        ParticipationDto participationDto = new ParticipationDto();
        participationDto.setParticipantCount(participationRepository.findByArticleIdCount(article.getId()));

        Participation participation = participationRepository.findByArticleIdOrderParticipatedAt(article.getId());

        if (participation == null) {
            participationDto.setRecentParticipatedUserName(null);
        } else {
            participationDto.setRecentParticipatedUserName(participation.getParticipatedUser().getName());
        }

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
        List<Participation> participations = participationRepository.findByArticleId(article.getId());

        if (participations == null || participations.isEmpty()) {
            ParticipationDto participationDto = new ParticipationDto();
            participationDto.setRecentParticipatedUserName(null);
            participationDto.setParticipantCount(0L);

            articleDto.setParticipationDto(participationDto);
            return;
        }

        ParticipationDto participationDto = new ParticipationDto();
        participationDto.setRecentParticipatedUserName(participationRepository.findByArticleIdOrderParticipatedAt(article.getId()).getParticipatedUser().getName());
        participationDto.setParticipantCount(participationRepository.findByArticleIdCount(article.getId()));

        articleDto.setParticipationDto(participationDto);
    }

    public void update(ArticleRequestParam article) {
        Article savedArticle = articleRepository.findOne(article.getArticleId());

        savedArticle.setContents(article.getContents());
        savedArticle.setTitle(article.getTitle());
        savedArticle.setArticleMainImageUrl(imageService.uploadArticleMainImage(article.getArticleMainImage()));
        savedArticle.setCategoryId(categoryRepository.findByType(article.getCategoryType()).getId());
        savedArticle.setContents(article.getContents());

        articleRepository.save(savedArticle);
    }

    public ArticleDto getArticleDto(Participation participation) {
        ArticleDto articleDto = new ArticleDto();

        Article participatedArticle = participation.getParticipatedArticle();

        ParticipationDto participationDto = new ParticipationDto();
        participationDto.setParticipantCount(participationRepository.findByArticleIdCount(participation.getParticipatedArticle().getId()));
        participationDto.setRecentParticipatedUserName(participation.getParticipatedUser().getName());

        articleDto.setArticleId(participatedArticle.getId());
        articleDto.setParticipationDto(participationDto);
        articleDto.setViewCount(participatedArticle.getViewCount());
        articleDto.setContents(participatedArticle.getContents());
        articleDto.setCommentCount(participatedArticle.getComments().size());
        articleDto.setArticleMainImageUrl(participatedArticle.getArticleMainImageUrl());

        Category category = categoryRepository.findOne(participatedArticle.getCategoryId());

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryId(category.getId());
        categoryDto.setType(category.getType());

        articleDto.setCategory(categoryDto);
        articleDto.setCreatedAt(participatedArticle.getCreatedAt());
        articleDto.setTitle(participatedArticle.getTitle());

        Writer writer = new Writer();
        writer.setUserId(participation.getParticipatedUser().getId());
        writer.setProfileUrl(participation.getParticipatedUser().getProfileUrl());
        writer.setName(participation.getParticipatedUser().getName());
        articleDto.setWriter(writer);

        return articleDto;
    }
}
