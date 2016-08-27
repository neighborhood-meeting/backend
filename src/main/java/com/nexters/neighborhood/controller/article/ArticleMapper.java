package com.nexters.neighborhood.controller.article;

import com.nexters.neighborhood.dto.ArticleDto;
import com.nexters.neighborhood.dto.CategoryDto;
import com.nexters.neighborhood.dto.ParticipationDto;
import com.nexters.neighborhood.dto.Writer;
import com.nexters.neighborhood.entity.Article;
import com.nexters.neighborhood.entity.Category;
import com.nexters.neighborhood.entity.Participation;
import com.nexters.neighborhood.entity.User;
import com.nexters.neighborhood.repository.CategoryRepository;
import com.nexters.neighborhood.repository.ParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Dark on 2016. 8. 27..
 */

@Service
public class ArticleMapper {

    @Autowired
    private ParticipationRepository participationRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public ArticleDto readArticleDto(Article article) {
        ArticleDto articleDto = new ArticleDto();

        setArticle(article, articleDto);
        setWriter(article, articleDto);
        setCategory(article.getCategoryId(), articleDto);
        setParticipation(article, articleDto);

        return articleDto;
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

    private void setParticipation(Article article, ArticleDto articleDto) {
        ParticipationDto participationDto = new ParticipationDto();
        participationDto.setParticipantCount(participationRepository.findByArticleIdCount(article.getId()));

        Participation participation = participationRepository.findByArticleIdOrderParticipatedAt(article.getId());

        if (isEmptyParticipationArticle(participation)) {
            participationDto.setRecentParticipatedUserName(null);
        } else {
            participationDto.setRecentParticipatedUserName(participation.getParticipatedUser().getName());
        }

        articleDto.setParticipationDto(participationDto);
    }

    private boolean isEmptyParticipationArticle(Participation participation) {
        return participation == null;
    }

    private void setCategory(Long categoryId, ArticleDto articleDto) {
        Category category = categoryRepository.findOne(categoryId);

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryId(category.getId());
        categoryDto.setType(category.getType());

        articleDto.setCategory(categoryDto);
    }

    private void setWriter(Article article, ArticleDto articleDto) {
        Writer writer = new Writer();

        User user = article.getUser();
        writer.setName(user.getName());
        writer.setProfileUrl(user.getProfileUrl());
        writer.setUserId(user.getId());

        articleDto.setWriter(writer);
    }
}
