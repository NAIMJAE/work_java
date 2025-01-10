package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.dto.ArticleDTO;
import com.example.entity.Article;
import com.example.service.ArticleService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@RequiredArgsConstructor
@Controller
public class ArticleController {

    private final ArticleService articleService;
    
// 게시글 목록
    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("articleList", articleService.selectArticleList());

        return "/index";
    }

// 게시글 작성
    @GetMapping("/write")
    public String writePage() {
        return "/write";
    }

    @PostMapping("/write")
    public ResponseEntity<?> insertArticle(@RequestBody ArticleDTO articleDTO) {
        return articleService.insertArticle(articleDTO);
    }

// 게시글 보기
    @GetMapping("/view/{articleNo}")
    public String viewPage(@PathVariable("articleNo") Integer articleNo, Model model) {
        model.addAttribute("article", articleService.selectArticle(articleNo));

        return "/view";
    }

// 게시글 수정
    @GetMapping("/modify/{articleNo}")
    public String modifyPage(@PathVariable("articleNo") Integer articleNo, Model model) {
        model.addAttribute("article", articleService.selectArticle(articleNo));

        return "/modify";
    }

    @PutMapping("/modify")
    public ResponseEntity<?> modifyPage(@RequestBody ArticleDTO articleDTO) {
        return articleService.modifyArticle(articleDTO);
    }

// 게시글 삭제
    @DeleteMapping("/delete/{articleNo}")
    public ResponseEntity<?> deleteArticle(@PathVariable("articleNo") Integer articleNo) {
        return articleService.deleteArticle(articleNo);
    }
}
