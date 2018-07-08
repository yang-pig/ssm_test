package com.ssmtest.controller.admin;


import com.github.pagehelper.PageInfo;
import com.ssmtest.entity.Article;
import com.ssmtest.entity.Category;
import com.ssmtest.entity.ImageHolder;
import com.ssmtest.service.ArticleService;
import com.ssmtest.service.CategoryService;
import com.ssmtest.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/backend/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CategoryService categoryService;


    @RequestMapping(value="/index")
    public String index(@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn, ModelMap map)  throws IOException {



        PageInfo pageInfo = articleService.queryByPage(null,pn,10);


        map.put("pageInfo",pageInfo);

        return "Admin/Article/index";
    }

    @RequestMapping(value="/add")
    public String add(ModelMap map)  throws IOException {



        Category category = new Category();
        short type = 1;
        category.setType(type);
        List<Category> categoryList  = categoryService.queryCategoryResult(category);


        map.put("categoryList", categoryList);

        return "Admin/Article/add";
    }

    @RequestMapping(value="/addAjax")
    public String addAjax(HttpServletRequest request)  throws IOException {


        String title = HttpServletRequestUtil.getString(request,"title");
        long tid = HttpServletRequestUtil.getLong(request,"tid");
        String author = HttpServletRequestUtil.getString(request,"author");
        String source = HttpServletRequestUtil.getString(request,"source");
        short status = HttpServletRequestUtil.getShort(request,"open");


        if (status <= 0) {
            status = 0;
        }

//        System.out.println("status:"+status);




        short commend = HttpServletRequestUtil.getShort(request,"commend");
        short choice = HttpServletRequestUtil.getShort(request,"choice");
        String keywords = HttpServletRequestUtil.getString(request,"keywords");
        String description = HttpServletRequestUtil.getString(request,"description");
        String content = HttpServletRequestUtil.getString(request,"content");

        String textfield = HttpServletRequestUtil.getString(request,"textfield");
        String time = String.valueOf(System.currentTimeMillis() / 1000);

        Article article = new Article();

        article.setTid(tid);
        article.setTitle(title);
        article.setAuthor(author);
        article.setSource(source);

        article.setStatus(status);




        if (choice != -1) {
            article.setChoice(choice);
        }
        article.setCommend(commend);
        article.setContent(content);
        article.setKeywords(keywords);
        article.setTime(time);
        article.setDescription(description);

//        System.out.println(article.toString());


        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"

        ImageHolder imageHolder = null;
        if(textfield != null && multipartResolver.isMultipart(request))
        {


            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;


            CommonsMultipartFile img = (CommonsMultipartFile) multiRequest.getFile("pic");


            imageHolder = new ImageHolder(img.getOriginalFilename(),img.getInputStream());


        }

        articleService.insert(article,imageHolder);

        return "redirect:/backend/article/index";
    }


    @RequestMapping(value="/edit",method = RequestMethod.GET)
    public String edit(HttpServletRequest request,ModelMap map)  throws IOException {

        Long id = HttpServletRequestUtil.getLong(request,"id");


        Article article = articleService.getArticleById(id);

        Category category = new Category();
        short type = 1;
        category.setType(type);
        List<Category> categoryList  = categoryService.queryCategoryResult(category);


        map.put("categoryList", categoryList);

        String keyworld = article.getKeywords();

//        System.out.println("keyworlds"+keyworld);

        String kw[] = null;
        if (keyworld != null && !keyworld.isEmpty()) {
            kw = keyworld.split(",");
        }
        map.put("keywords",kw);
        map.put("article",article);

        return "Admin/Article/edit";



    }


    @RequestMapping(value="/editAjax")
    public String editAjax(HttpServletRequest request)  throws IOException {

        long id = HttpServletRequestUtil.getLong(request,"id");
        String title = HttpServletRequestUtil.getString(request,"title");
        long tid = HttpServletRequestUtil.getLong(request,"tid");
        String author = HttpServletRequestUtil.getString(request,"author");
        String source = HttpServletRequestUtil.getString(request,"source");
        short status = HttpServletRequestUtil.getShort(request,"open");


        if (status <= 0) {
            status = 0;
        }



        short commend = HttpServletRequestUtil.getShort(request,"commend");
        short choice = HttpServletRequestUtil.getShort(request,"choice");
        String keywords = HttpServletRequestUtil.getString(request,"keywords");
        String description = HttpServletRequestUtil.getString(request,"description");
        String content = HttpServletRequestUtil.getString(request,"content");

        String textfield = HttpServletRequestUtil.getString(request,"textfield");
        String time = String.valueOf(System.currentTimeMillis() / 1000);

        Article article = new Article();

        article.setId(id);
        article.setTid(tid);
        article.setTitle(title);
        article.setAuthor(author);
        article.setSource(source);

        article.setStatus(status);




        if (choice != -1) {
            article.setChoice(choice);
        }
        article.setCommend(commend);
        article.setContent(content);
        article.setKeywords(keywords);
        article.setTime(time);
        article.setDescription(description);

//        System.out.println(article.toString());


        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"

        ImageHolder imageHolder = null;
        if(textfield != null && multipartResolver.isMultipart(request))
        {


            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;


            CommonsMultipartFile img = (CommonsMultipartFile) multiRequest.getFile("pic");


            imageHolder = new ImageHolder(img.getOriginalFilename(),img.getInputStream());


        }

        articleService.update(article,imageHolder);

        return "redirect:/backend/article/index";
    }


    @RequestMapping(value="/del",method = RequestMethod.GET)
    public String del(HttpServletRequest request)  throws IOException {

        Long id = HttpServletRequestUtil.getLong(request,"id");


        int reId =  articleService.del(id);


        return "redirect:/backend/article/index";



    }


    @RequestMapping(value="/dels",method = RequestMethod.POST)
    public String dels(HttpServletRequest request)  throws IOException {

        String values[] = request.getParameterValues("deletes");



        articleService.dels(values);



        return "redirect:/backend/article/index";



    }




}