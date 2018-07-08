
package com.ssmtest.service.impl;

import com.ssmtest.dao.CategoryDao;
import com.ssmtest.entity.Category;
import com.ssmtest.entity.ImageHolder;
import com.ssmtest.service.CategoryService;
import com.ssmtest.util.ImageUtil;
import com.ssmtest.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;


    @Override
    public List<Category> queryCategoryResult(Category category) {
        return categoryDao.queryCategoryResult(category);
    }

    @Override
    public int insert(Category category, ImageHolder imageHolder) {

        System.out.println(imageHolder);

        if (imageHolder != null) {
            SetImg(category,imageHolder);
        }


//        System.out.println(category);




        return categoryDao.insert(category);
    }

    @Override
    public Category getCategoryById(long id) {
        return categoryDao.getCategoryById(id);
    }

    @Override
    public int update(Category category, ImageHolder imageHolder) {

        if (imageHolder != null) {
            SetImg(category,imageHolder);
        }


        return categoryDao.update(category);
    }


    @Override
    public int del(long id) {
        return  categoryDao.del(id);
    }

    private void SetImg(Category category, ImageHolder thumbnail) {
        //获取图片目录的相对值得路径
        String name = "category";
        String dest = PathUtil.getImagePath(category.getTid(),name);
        String Img = ImageUtil.generateNormalImgs(thumbnail,dest);
        category.setPic(Img);

    }
}