package com.ex.mvcprac3.domain;

import com.ex.mvcprac3.domain.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ArticleRepository extends JpaRepository<Article, Long> {
}
