package com.oyuneticaret.dto.article;

import java.io.Serializable;
import java.util.List;

public class ArticleFindSuccessDTO implements Serializable {

    private List<ArticleDTO> articles;
    private String message;

    public List<ArticleDTO> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleDTO> articles) {
        this.articles = articles;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
