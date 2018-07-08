package com.ssmtest.controller.admin;



import com.ssmtest.entity.Banner;

import com.ssmtest.entity.ImageHolder;

import com.ssmtest.service.BannerService;

import com.ssmtest.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Controller
@RequestMapping("/backend/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;


    @RequestMapping(value="/index")
    public String index(ModelMap map)  throws IOException {

        Banner banner = bannerService.getBannerById(1);
//        System.out.println(banner);
        map.put("banner",banner);

        return "Admin/Banner/index";
    }



    @RequestMapping(value="/editAjax")
    public String editAjax(HttpServletRequest request)  throws IOException {

        long id = HttpServletRequestUtil.getLong(request,"id");
        String atitle = HttpServletRequestUtil.getString(request,"atitle");
        String alink = HttpServletRequestUtil.getString(request,"alink");
        String textfield = HttpServletRequestUtil.getString(request,"textfield");

        String btitle = HttpServletRequestUtil.getString(request,"btitle");
        String blink = HttpServletRequestUtil.getString(request,"blink");
        String textfieldb = HttpServletRequestUtil.getString(request,"textfieldb");

        String ctitle = HttpServletRequestUtil.getString(request,"ctitle");
        String clink = HttpServletRequestUtil.getString(request,"clink");
        String textfieldc = HttpServletRequestUtil.getString(request,"textfieldc");



        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"

        ImageHolder imageHolder = null;
        if(textfield != null && multipartResolver.isMultipart(request))
        {


            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;


            CommonsMultipartFile img = (CommonsMultipartFile) multiRequest.getFile("apic");


            imageHolder = new ImageHolder(img.getOriginalFilename(),img.getInputStream());


        }
        ImageHolder imageHolderb = null;
        if(textfieldb != null && multipartResolver.isMultipart(request))
        {


            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;


            CommonsMultipartFile img = (CommonsMultipartFile) multiRequest.getFile("bpic");


            imageHolderb = new ImageHolder(img.getOriginalFilename(),img.getInputStream());


        }
        ImageHolder imageHolderc = null;
        if(textfieldc != null && multipartResolver.isMultipart(request))
        {


            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;


            CommonsMultipartFile img = (CommonsMultipartFile) multiRequest.getFile("cpic");


            imageHolderc = new ImageHolder(img.getOriginalFilename(),img.getInputStream());


        }

        Banner banner = new Banner();

        banner.setId(id);
        banner.setAlink(alink);
        banner.setAtitle(atitle);

        banner.setBlink(blink);
        banner.setBtitle(btitle);

        banner.setClink(clink);
        banner.setCtitle(ctitle);



        bannerService.update(banner,imageHolder,imageHolderb,imageHolderc);

        return "redirect:/backend/banner/index";
    }

}