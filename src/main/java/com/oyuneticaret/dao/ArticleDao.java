package com.oyuneticaret.dao;

import com.oyuneticaret.model.Article;

import java.util.List;

public interface ArticleDao {

    void save(Article article);
    List<Article> findArticles(Long userId, Long communityGroupId, String content);
    Article findArticleById(Long id);
    void delete(Article article);
}
