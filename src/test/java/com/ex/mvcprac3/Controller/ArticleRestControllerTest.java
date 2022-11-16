package com.ex.mvcprac3.Controller;

import com.ex.mvcprac3.ArticleService;
import com.ex.mvcprac3.controller.ArticleRestController;
import com.ex.mvcprac3.dto.ArticleDto;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;

@WebMvcTest(ArticleRestController.class)
public class ArticleRestControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    ArticleService articleService;

    @WebMvcTest
    @DisplayName("해당 id 글이 잘 조회되는지")
    void findSingle() throws Exception {
        Long id = 1l;
        given(articleService.getArticleById(id))
                .willReturn(new ArticleDto(1l, "첫번째 글","내용입니다."));

        mockMvc.perform(get("/api/v1/articles/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.title").exists())
                .andExpect(jsonPath("$.content").exists())
                .andDo(print());

        verify(articleService).getArticleById(id);
    }
}
