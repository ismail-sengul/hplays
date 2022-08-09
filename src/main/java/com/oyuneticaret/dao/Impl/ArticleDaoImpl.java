package com.oyuneticaret.dao.Impl;

import com.oyuneticaret.dao.ArticleDao;
import com.oyuneticaret.model.Article;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleDaoImpl implements ArticleDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(Article article) {
        getCurrentSession().save(article);
    }

    @Override
    public List<Article> findArticles(Long userId, Long communityGroupId, String content) {
        StringBuilder query = new StringBuilder("SELECT * FROM ARTICLE AS A WHERE 1=1");

        if(userId != null){
            query.append(" AND A.USER_ID = "+userId);
        }if(communityGroupId != null){
            query.append(" AND A.COMMUNITY_GROUP_ID = "+communityGroupId);
        }if(content != null){
            query.append(" AND A.CONTENT LIKE %"+content+"%");
        }

        return getCurrentSession().createNativeQuery(query.toString()).addEntity(Article.class).getResultList();
    }

    @Override
    public Article findArticleById(Long id) {
        return getCurrentSession().get(Article.class, id);
    }

    @Override
    public void delete(Article article) {
        getCurrentSession().delete(article);
    }
}
