
package com.ssmtest.service.impl;

import com.ssmtest.dao.BannerDao;

import com.ssmtest.entity.Banner;
import com.ssmtest.entity.ImageHolder;

import com.ssmtest.service.BannerService;

import com.ssmtest.util.ImageUtil;
import com.ssmtest.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDao bannerDao;


    @Override
    public Banner getBannerById(long id) {
        return bannerDao.getBannerById(id);
    }

    @Override
    public int update(Banner banner, ImageHolder imageHoldera, ImageHolder imageHolderb, ImageHolder imageHolderc) {

        if (imageHoldera != null) {
            SetImg(banner,imageHoldera,"a");
        }
        if (imageHolderb != null) {
            SetImg(banner,imageHolderb,"b");
        }
        if (imageHolderc != null) {
            SetImg(banner,imageHolderc,"c");
        }

        return bannerDao.update(banner);
    }


    private void SetImg(Banner banner, ImageHolder thumbnail,String type) {
        //获取图片目录的相对值得路径
        String name = "banner";
        String dest = PathUtil.getImagePath(banner.getId(),name);
        String Img = ImageUtil.generateNormalImgs(thumbnail,dest);
        if (type.equals("a")) banner.setApic(Img);
        if (type.equals("b")) banner.setBpic(Img);
        if (type.equals("c")) banner.setCpic(Img);
    }
}