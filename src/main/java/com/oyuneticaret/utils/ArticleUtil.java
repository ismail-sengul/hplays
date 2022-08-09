package com.oyuneticaret.utils;

import com.oyuneticaret.dto.article.ArticleDTO;
import com.oyuneticaret.dto.article.ArticleFindSuccessDTO;
import com.oyuneticaret.dto.article.ArticleSuccessDTO;
import com.oyuneticaret.model.Article;

import java.util.ArrayList;
import java.util.List;

public class ArticleUtil {

    CommunityGroupUtil communityGroupUtil = new CommunityGroupUtil();

    UserUtil userUtil = new UserUtil();

    public ArticleSuccessDTO createArticleSuccessDTO(Article article, String message){

        ArticleSuccessDTO articleSuccessDTO = new ArticleSuccessDTO();

        articleSuccessDTO.setCommunityGroup(communityGroupUtil.convertCommunityGroupDTO(article.getCommunityGroup()));
        articleSuccessDTO.setContent(article.getContent());
        articleSuccessDTO.setId(article.getId());
        articleSuccessDTO.setUser(userUtil.convertUserDTO(article.getUser()));
        articleSuccessDTO.setMessage(message);

        return articleSuccessDTO;
    }

    public ArticleFindSuccessDTO createArticleFindSuccessDTO(List<Article> articles){

        ArticleFindSuccessDTO articleFindSuccessDTO = new ArticleFindSuccessDTO();
        List<ArticleDTO> articleDTOS = new ArrayList<>();
        for (Article article : articles){
            ArticleDTO articleDTO = new ArticleDTO();

            articleDTO.setId(article.getId());
            articleDTO.setCommunityGroup(communityGroupUtil.convertCommunityGroupDTO(article.getCommunityGroup()));
            articleDTO.setContent(article.getContent());
            articleDTO.setUser(userUtil.convertUserDTO(article.getUser()));

            articleDTOS.add(articleDTO);
        }
        articleFindSuccessDTO.setArticles(articleDTOS);
        articleFindSuccessDTO.setMessage("Listeleme İşlemi Başarılı.");

        return articleFindSuccessDTO;
    }
}
