package com.ssmtest.service;


import com.ssmtest.entity.Banner;
import com.ssmtest.entity.ImageHolder;


public interface BannerService {


    Banner getBannerById(long id);


    int update(Banner banner, ImageHolder imageHoldera,ImageHolder imageHolderb,ImageHolder imageHolderc);

}