package com.ex.mvcprac3.repository;

import com.ex.mvcprac3.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ArticleRepository extends JpaRepository<Article, Long> {
}
