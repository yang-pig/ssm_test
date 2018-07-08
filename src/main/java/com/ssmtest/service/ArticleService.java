package com.ssmtest.service;


import com.github.pagehelper.PageInfo;
import com.ssmtest.entity.Article;
import com.ssmtest.entity.ImageHolder;



public interface ArticleService {
    PageInfo<Article> queryByPage(Article article, Integer pageNo, Integer pageSize);



    int insert(Article article, ImageHolder imageHolder);

    int update(Article article,ImageHolder imageHolder);

    Article getArticleById(long id);


    int del(long id);

    int dels(String[] arr);
}