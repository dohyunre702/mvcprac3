package com.ex.mvcprac3.controller;

import com.ex.mvcprac3.ArticleService;
import com.ex.mvcprac3.dto.ArticleDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleRestController {
    private final ArticleService articleService;

    public ArticleRestController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDto> getArticle(@PathVariable Long if) {
        ArticleDto articleDto = articleService.getArticleById(id);
        return ResponseEntity.ok().body(articleDto);
    }
}
