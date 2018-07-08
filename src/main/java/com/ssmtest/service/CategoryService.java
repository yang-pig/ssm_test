package com.ssmtest.service;


import com.ssmtest.entity.Category;
import com.ssmtest.entity.ImageHolder;

import java.util.List;

public interface CategoryService {
    List<Category> queryCategoryResult(Category category);
    int insert(Category category, ImageHolder imageHolder);

    Category getCategoryById(long id);

    int update(Category category, ImageHolder imageHolder);

    int del(long id);
}