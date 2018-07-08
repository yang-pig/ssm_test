
package com.ssmtest.service.impl;


import com.ssmtest.dao.ConfDao;

import com.ssmtest.entity.Conf;
import com.ssmtest.entity.ImageHolder;
import com.ssmtest.service.ConfService;
import com.ssmtest.util.ImageUtil;
import com.ssmtest.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfServiceImpl implements ConfService {
    @Autowired
    private ConfDao confDao;

    @Override
    public Conf getConfById(long id) {
        return confDao.getConfById(id);
    }

    @Override
    public int update(Conf conf, ImageHolder imageHolder) {
        if (imageHolder != null) {
            SetImg(conf,imageHolder);
        }
        return  confDao.update(conf);


    }

    private void SetImg(Conf conf, ImageHolder thumbnail) {
        //获取图片目录的相对值得路径
        String name = "conf";
        String dest = PathUtil.getImagePath(conf.getId(),name);
        String Img = ImageUtil.generateNormalImgs(thumbnail,dest);
        conf.setLogo(Img);

    }
}


