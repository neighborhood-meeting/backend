package com.nexters.neighborhood.service;

import com.google.common.collect.Lists;
import com.nexters.neighborhood.controller.article.ArticleMapper;
import com.nexters.neighborhood.controller.article.ArticleRequestParam;
import com.nexters.neighborhood.controller.article.ParticipateRequestParam;
import com.nexters.neighborhood.dto.ArticleDto;
import com.nexters.neighborhood.entity.Article;
import com.nexters.neighborhood.entity.Category;
import com.nexters.neighborhood.entity.Participation;
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

    @Autowired
    private ArticleMapper articleMapper;

    public List<ArticleDto> findArticlesByRegionId(Long regionId) {
        List<Article> articles = articleRepository.findByRegionId(regionId);

        List<ArticleDto> articleDtoList = Lists.newArrayList();

        for (Article article : articles) {
            ArticleDto articleDto = articleMapper.readArticleDto(article);

            articleDtoList.add(articleDto);
        }

        return articleDtoList;
    }

    public List<ArticleDto> findArticlesByRegionIdAndCategoryType(Long regionId, String type) {
        Category category = categoryRepository.findByType(type);
        List<Article> articles = articleRepository.findByRegionIdAndCategoryId(regionId, category.getId());

        List<ArticleDto> articleDtoList = Lists.newArrayList();

        for (Article article : articles) {
            articleDtoList.add(articleMapper.readArticleDto(article));
        }

        return articleDtoList;
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

    public void participate(ParticipateRequestParam participateRequestParam) {
        Participation participation1 = participationRepository.findByUserIdAndArticleId(participateRequestParam.getUserId(), participateRequestParam.getArticleId());

        // 이미 참여한 사람이면 다시 요청이 왔을 시, 참여 취소
        if (isAlreadyParticipated(participation1)) {
            participationRepository.delete(participation1);

            return;
        }

        Participation participation = new Participation();

        participation.setParticipatedArticle(articleRepository.findOne(participateRequestParam.getArticleId()));
        participation.setParticipatedUser(userRepository.findOne(participateRequestParam.getUserId()));

        participationRepository.save(participation);
    }

    private boolean isAlreadyParticipated(Participation participation1) {
        return participation1 != null;
    }

    public List<ArticleDto> findByUserId(Long userId) {
        List<Article> articles = articleRepository.findByUserId(userId);

        List<ArticleDto> articleDtoList = Lists.newArrayList();

        for (Article article : articles) {
            ArticleDto articleDto = articleMapper.readArticleDto(article);

            articleDtoList.add(articleDto);
        }

        return articleDtoList;
    }

    public List<ArticleDto> findLikeTitle(String title) {
        List<Article> articles = articleRepository.findLikeTitle(title);

        List<ArticleDto> articleDtoList = Lists.newArrayList();

        for (Article article : articles) {
            ArticleDto articleDto = articleMapper.readArticleDto(article);

            articleDtoList.add(articleDto);
        }

        return articleDtoList;
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
        Article article = participation.getParticipatedArticle();

        return articleMapper.readArticleDto(article);
    }
}
