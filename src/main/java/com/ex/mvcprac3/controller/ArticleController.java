package com.ex.mvcprac3.controller;

import com.ex.mvcprac3.domain.ArticleDto;
import com.ex.mvcprac3.domain.ArticleRepository;
import com.ex.mvcprac3.domain.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller("/articles")
@Slf4j
public class ArticleController {
    private final ArticleRepository articleRepository;
    //생성자 di 주입
    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    //get
    @GetMapping(value = "/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @GetMapping("/{id}") //id를 article로 받아 와서 해당하는 데이터 출력
    public String selectSingle(@PathVariable Long id, Model model) {
        Optional<Article> optArticle = articleRepository.findById(id);

        if (!optArticle.isEmpty()) {
            model.addAttribute("article", optArticle.get());
            return "show";
        } else {
            return "error";
        }
    }

    @GetMapping("/list")  // list일 때 list로
    public String list(Model model){ //리퐂토리
        List<Article> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);
        return "list";
    }

    @GetMapping("") // / 일때 list로
    public String index() {
       return "redirect:/articles/list";
        }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Optional<Article> optionalArticle =
                articleRepository.findById(id);

        if (!optionalArticle.isEmpty()) {
            model.addAttribute("article", optionalArticle.get());
            return "edit";
            } else {
            model.addAttribute("message", String.format("%d가 없습니다.", id));
            return "error";
        }
    }


    //post
    @PostMapping("/posts") //new에서 submit 눌렀을 때 요청과 내용을 받음
    public String createArticle(ArticleDto form) {
        log.info(form.toString());
        Article article = form.toEntity();
        articleRepository.save(article);
        return "";
    }

    @PostMapping("")
    public String add(ArticleDto articleDto) {
        log.info(articleDto.getTitle());
        Article savedArticle = articleRepository.save(articleDto.toEntity());
        log.info("generatedId:{}", savedArticle.getId());

        return "";
    }

    @PostMapping("/{id}/update") //수정한 게시글 저장
    public String update(@PathVariable Long id, ArticleDto articleDto, Model model) {
        log.info("title:{} content:{}", articleDto.getTitle(),articleDto.getContent());
        Article article = articleRepository.save(articleDto.toEntity());
        model.addAttribute("article", article);
        return String.format("redirect:/articles/%d", article.getId());
    }
}
