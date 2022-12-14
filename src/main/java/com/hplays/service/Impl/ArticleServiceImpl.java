package com.hplays.service.Impl;

import com.hplays.dao.ArticleDao;
import com.hplays.model.Article;
import com.hplays.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDao articleDao;

    @Override
    public void save(Article article) {
        articleDao.save(article);
    }

    @Override
    public List<Article> findArticles(Long userId, Long communityGroupId, String content) {
        return articleDao.findArticles(userId,communityGroupId,content);
    }

    @Override
    public Article findArticleById(Long id) {
        return articleDao.findArticleById(id);
    }

    @Override
    public void delete(Article article) {
        articleDao.delete(article);
    }
}
