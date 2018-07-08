package com.ssmtest.dao;


import com.ssmtest.entity.Banner;

import org.springframework.stereotype.Repository;



@Repository
public interface BannerDao {


    Banner getBannerById(long id);

    int update(Banner banner);

}