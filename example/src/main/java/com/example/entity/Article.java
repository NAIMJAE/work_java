package com.example.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ArticleNo;
    
    private String title;
    private String contents;
    private String writer;
    @CreationTimestamp
    private LocalDateTime rDate;

    public Article(String title, String contents, String writer) {
        this.title = checkText(title);
        this.contents = checkText(contents);
        this.writer = writer;
    }

    public void modifyArticle(String title, String contents) {
        this.title = checkText(title);
        this.contents = checkText(contents);
    }

    private String checkText(String text) {
        if (text.length() > 20) {
            throw new IllegalArgumentException("Text Length Exception");
        }else {
            return text;
        }
    }
}
