package com.ex.mvcprac3.controller;

import com.ex.mvcprac3.domain.ArticleDto;
import com.ex.mvcprac3.domain.ArticleRepository;
import com.ex.mvcprac3.domain.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller("/articles")
@Slf4j
public class ArticleController {
    private final ArticleRepository articleRepository;
    //생성자 di 주입
    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping(value = "/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/posts")
    public String createArticle(ArticleDto form) {
        log.info(form.toString());
        Article article = form.toEntity();
        articleRepository.save(article);
        return "";
    }
}
