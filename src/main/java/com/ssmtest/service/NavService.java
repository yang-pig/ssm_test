package com.ssmtest.service;


import com.ssmtest.entity.Nav;

import java.util.List;

public interface NavService {
    List<Nav> queryNavResult(Nav nav);
    int insert(Nav nav);

    Nav getNavById(long id);

    int update(Nav nav);

    int del(long id);
}