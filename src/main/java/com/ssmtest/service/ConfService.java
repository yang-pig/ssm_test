package com.ssmtest.service;


import com.ssmtest.entity.Conf;
import com.ssmtest.entity.ImageHolder;


public interface ConfService {


    Conf getConfById(long id);

    int update(Conf conf, ImageHolder imageHolder);


}