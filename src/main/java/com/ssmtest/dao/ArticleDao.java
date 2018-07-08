package com.ssmtest.dao;


import com.ssmtest.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDao {

    List<Article> queryArticleResult(Article article);

    List<Article> getAll();

    Article getArticleById(long id);

    int insert(Article article);

    int update(Article article);

    int del(long id);

    int dels(String[] arr);
}