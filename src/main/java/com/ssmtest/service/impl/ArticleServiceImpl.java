
package com.ssmtest.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssmtest.dao.ArticleDao;

import com.ssmtest.entity.Article;

import com.ssmtest.entity.ImageHolder;
import com.ssmtest.service.ArticleService;

import com.ssmtest.util.ImageUtil;
import com.ssmtest.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;


    @Override
    public PageInfo<Article> queryByPage(Article article, Integer pageNum, Integer pageSize) {




        PageHelper.startPage(pageNum,pageSize);
        //startPage后紧跟的这个查询就是分页查询
        List<Article> list = articleDao.queryArticleResult(null);
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<>(list);

        return pageInfo;
    }

    @Override
    public int insert(Article article, ImageHolder imageHolder) {
        if (imageHolder != null) {
            SetImg(article,imageHolder);
        }
        return articleDao.insert(article);
    }

    @Override
    public int update(Article article,ImageHolder imageHolder) {
        if (imageHolder != null) {
            SetImg(article,imageHolder);
        }
        return articleDao.update(article);
    }

    @Override
    public Article getArticleById(long id) {
        return articleDao.getArticleById(id);
    }

    @Override
    public int del(long id) {
        return articleDao.del(id);
    }

    @Override
    public int dels(String[] arr) {
        return articleDao.dels(arr);
    }

    private void SetImg(Article article, ImageHolder thumbnail) {
        //获取图片目录的相对值得路径
        String name = "article";
        String dest = PathUtil.getImagePath(article.getTid(),name);
        String Img = ImageUtil.generateNormalImgs(thumbnail,dest);
        article.setPic(Img);

    }

}