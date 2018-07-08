package com.ssmtest.controller.admin;



import com.ssmtest.entity.Conf;
import com.ssmtest.entity.ImageHolder;
import com.ssmtest.service.ConfService;
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
@RequestMapping("/backend/conf")
public class ConfController {


    @Autowired
    private ConfService confService;

    @RequestMapping(value = "/index")
    public String index(ModelMap map) throws IOException {


        Conf conf = confService.getConfById(1);

        map.put("conf",conf);

        return "Admin/Conf/index";
    }



    @RequestMapping(value = "/doEdit")
    public String doEdit(HttpServletRequest request) throws IOException {

        long id = HttpServletRequestUtil.getLong(request,"id");
        String domain = HttpServletRequestUtil.getString(request,"domain");
        String author = HttpServletRequestUtil.getString(request,"author");
        String qq = HttpServletRequestUtil.getString(request,"qq");
        String record = HttpServletRequestUtil.getString(request,"record");
        String textfield = HttpServletRequestUtil.getString(request,"textfield");
        String title = HttpServletRequestUtil.getString(request,"title");
        String keywords = HttpServletRequestUtil.getString(request,"keywords");
        String description = HttpServletRequestUtil.getString(request,"description");



        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());


        ImageHolder imageHolder = null;
        if(textfield != null && multipartResolver.isMultipart(request))
        {

            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;

            CommonsMultipartFile img = (CommonsMultipartFile) multiRequest.getFile("logo");

            imageHolder = new ImageHolder(img.getOriginalFilename(),img.getInputStream());


        }

        Conf conf = new Conf();
        conf.setId(id);
        conf.setKeywords(keywords);
        conf.setAuthor(author);
        conf.setDescription(description);
        conf.setKeywords(keywords);
        conf.setDomain(domain);
        conf.setQq(qq);
        conf.setTitle(title);
        conf.setRecord(record);


        confService.update(conf,imageHolder);



        return "redirect:/backend/conf/index";
    }






}