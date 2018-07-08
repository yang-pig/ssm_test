package com.ssmtest.dao;


import com.ssmtest.entity.Nav;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NavDao {
    List<Nav> queryNavResult(Nav nav);

    int insert(Nav nav);

    Nav getNavById(long id);

    int update(Nav nav);

    int del(long id);

}