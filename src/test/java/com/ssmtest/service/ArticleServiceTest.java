package com.ssmtest.service;

import com.github.pagehelper.PageInfo;
import com.ssmtest.BaseTest;
import com.ssmtest.entity.Article;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArticleServiceTest extends BaseTest{
    @Autowired
    private ArticleService articleService;
    @Ignore
    @Test
    public void queryByPageTest(){
        PageInfo<Article> page =  articleService.queryByPage(null, 1, 1);
        System.out.println(page);
    }


}
