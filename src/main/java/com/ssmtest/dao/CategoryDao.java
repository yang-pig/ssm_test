package com.ssmtest.dao;


import com.ssmtest.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao {
    List<Category> queryCategoryResult(Category category);

    int insert(Category category);

    int update(Category category);

    Category getCategoryById(long id);

    int del(long id);
}