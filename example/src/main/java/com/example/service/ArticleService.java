package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dto.ArticleDTO;
import com.example.entity.Article;
import com.example.repository.ArticleRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    
    // INSERT Article
    public ResponseEntity<?> insertArticle(ArticleDTO articleDTO) {
        try {
            Article article = new Article(articleDTO.getTitle(), articleDTO.getContents(), articleDTO.getContents());

            Article saveArticle = articleRepository.save(article);
    
            if (saveArticle.getArticleNo() != null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT_FOUND");
            }else {
                return ResponseEntity.ok().body("ok");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    // SELECT Article List
    public List<Article> selectArticleList() {
        return articleRepository.findAll();
    }

    // SELECT Article
    public Article selectArticle(Integer articleNo) {
        return articleRepository.findById(articleNo).get();
    }

    // MODIFY Article
    public ResponseEntity<?> modifyArticle(ArticleDTO articleDTO) {
        Optional<Article> article = articleRepository.findById(articleDTO.getArticleNo());
        
        if (!article.isEmpty()) {
            try {
                article.get().modifyArticle(articleDTO.getTitle(), articleDTO.getContents());
                articleRepository.save(article.get());

                return ResponseEntity.ok().body("ok");
            } catch (Exception e) {
                log.error(e.getMessage());
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            }
            
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT_FOUND");
        }
    }

    // DELETE Article
    public ResponseEntity<?> deleteArticle(Integer articleNo) {
        articleRepository.deleteById(articleNo);

        return ResponseEntity.ok().body("ok");
    }
}