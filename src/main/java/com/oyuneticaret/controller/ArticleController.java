package com.oyuneticaret.controller;

import com.oyuneticaret.dto.article.ArticleCreateDTO;
import com.oyuneticaret.dto.article.ArticleUpdateDTO;
import com.oyuneticaret.model.Article;
import com.oyuneticaret.model.CommunityGroup;
import com.oyuneticaret.model.User;
import com.oyuneticaret.service.ArticleService;
import com.oyuneticaret.service.CommunityGroupService;
import com.oyuneticaret.service.UserService;
import com.oyuneticaret.utils.ArticleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @Autowired
    UserService userService;

    @Autowired
    CommunityGroupService communityGroupService;

    ArticleUtil articleUtil = new ArticleUtil();

    @RequestMapping(value = "/save" , method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody ArticleCreateDTO articleCreateDTO){

        if(articleCreateDTO.getUserId() != null){
            throw new IllegalArgumentException("Kullanıcı girilmedi.");
        }
        if(articleCreateDTO.getCommunityGroupId() != null){
            throw new IllegalArgumentException("Topluluk grubu girilmedi.");
        }
        Article article = new Article();

        User user = userService.findUserById(articleCreateDTO.getUserId());
        article.setUser(user);

        CommunityGroup communityGroup = communityGroupService.findCommunityGroupById(articleCreateDTO.getCommunityGroupId());
        article.setCommunityGroup(communityGroup);

        article.setContent(articleCreateDTO.getContent());

        return ResponseEntity.ok(articleUtil.createArticleSuccessDTO(article,"Ekleme İşlemi Başarılı."));
    }

    @RequestMapping(value = "/list" , method = RequestMethod.GET)
    public ResponseEntity<?> findArticles(@RequestParam(required = false) Long userId,
                                          @RequestParam(required = false) Long communityGroupId,
                                          @RequestParam(required = false) String content){

        List<Article> articles = articleService.findArticles(userId,communityGroupId,content);
        return ResponseEntity.ok(articleUtil.createArticleFindSuccessDTO(articles));
    }

    @RequestMapping(value = "/id?{id}" , method = RequestMethod.GET)
    public ResponseEntity<?> findArticleById(@PathVariable(value = "id") Long id){
        Article article = articleService.findArticleById(id);

        if(article == null){
            throw new IllegalArgumentException("Makale/Yazı bulunamadı.");
        }

        return ResponseEntity.ok(articleUtil.createArticleSuccessDTO(article,"İşlem Başarılı."));
    }

    @RequestMapping(value = "/update" , method = RequestMethod.PUT)
    public ResponseEntity<?> updateArticle(@RequestBody ArticleUpdateDTO articleUpdateDTO){
        Article article = articleService.findArticleById(articleUpdateDTO.getId());

        if(article == null){
            throw new IllegalArgumentException("Makale/Yazı bulunamadı.");
        }
        User user = userService.findUserById(articleUpdateDTO.getUserId());
        if(user != null){
            article.setUser(user);
        }
        CommunityGroup communityGroup = communityGroupService.findCommunityGroupById(articleUpdateDTO.getCommunityGroupId());
        if(communityGroup != null){
            article.setCommunityGroup(communityGroup);
        }
        if(articleUpdateDTO.getContent() != null){
            article.setContent(articleUpdateDTO.getContent());
        }

        articleService.save(article);

        return ResponseEntity.ok(articleUtil.createArticleSuccessDTO(article,"Güncelleme İşlemi Başarılı."));
    }

    @RequestMapping(value = "/delete" , method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteArticle(@RequestParam Long id){
        Article article = articleService.findArticleById(id);

        if(article == null){
            throw new IllegalArgumentException("Makale/Yazı bulunamadı.");
        }

        articleService.delete(article);

        return ResponseEntity.ok(articleUtil.createArticleSuccessDTO(article,"Silme İşlemi Başarılı."));
    }

}
