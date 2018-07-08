package com.ssmtest.controller.admin;

import com.ssmtest.entity.Category;
import com.ssmtest.entity.ImageHolder;
import com.ssmtest.service.CategoryService;
import com.ssmtest.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/backend/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value="/index")
    public String index(ModelMap map)  throws IOException {

        Category category = new Category();

        category.setTid(0);
        List<Category> categoryFather  = categoryService.queryCategoryResult(category);
        category.setTid(1);
        List<Category> categoryChild  = categoryService.queryCategoryResult(category);

        map.put("categoryFather", categoryFather);
        map.put("categoryChild", categoryChild);




        return "Admin/Category/index";
    }

    @RequestMapping(value="/add")
    public String add(ModelMap map)  throws IOException {



        Category category = new Category();

        category.setTid(0);

        List<Category> categoryFather  = categoryService.queryCategoryResult(category);

        map.put("categoryFather", categoryFather);


        return "Admin/Category/add";
    }

    @RequestMapping(value="/addAjax")
    public String addAjax(HttpServletRequest request)  throws IOException {


        String name = HttpServletRequestUtil.getString(request,"name");

        long tid = HttpServletRequestUtil.getLong(request,"tid");

        short type = HttpServletRequestUtil.getShort(request,"type");

        String keywords = HttpServletRequestUtil.getString(request,"keywords");

        String description = HttpServletRequestUtil.getString(request,"description");

        String textfield = HttpServletRequestUtil.getString(request,"textfield");

        String time = String.valueOf(System.currentTimeMillis() / 1000);

        Category category = new Category();

        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"

        ImageHolder imageHolder = null;
        if(textfield != null && multipartResolver.isMultipart(request))
        {

            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;

            CommonsMultipartFile img = (CommonsMultipartFile) multiRequest.getFile("pic");


            imageHolder = new ImageHolder(img.getOriginalFilename(),img.getInputStream());



        }

        category.setTid(tid);
        category.setName(name);
        category.setDescription(description);
        category.setKeywords(keywords);
        category.setTime(time);
        category.setType(type);

//        System.out.println(category);



        categoryService.insert(category,imageHolder);


        return "redirect:/backend/category/index";
    }

    @RequestMapping(value="/edit",method = RequestMethod.GET)
    public String edit(HttpServletRequest request,ModelMap map)  throws IOException {

        Long id = HttpServletRequestUtil.getLong(request,"id");
        Category categoryDetail =  categoryService.getCategoryById(id);

        Category category = new Category();

        category.setTid(0);

        List<Category> categoryFather  = categoryService.queryCategoryResult(category);

        map.put("categoryFather", categoryFather);

        map.put("category",categoryDetail);

//        System.out.println("navDetail"+navDetail.toString());
//
//        System.out.println(id);

        return "Admin/Category/edit";



    }

    @RequestMapping(value="/editAjax",method = RequestMethod.POST)
    public String editAjax(HttpServletRequest request)  throws IOException {



        long id = HttpServletRequestUtil.getLong(request,"id");
        String name = HttpServletRequestUtil.getString(request,"name");

        long tid = HttpServletRequestUtil.getLong(request,"tid");

        short type = HttpServletRequestUtil.getShort(request,"type");

        String keywords = HttpServletRequestUtil.getString(request,"keywords");

        String description = HttpServletRequestUtil.getString(request,"description");

        String textfield = HttpServletRequestUtil.getString(request,"textfield");

        Category category = new Category();

        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());


        ImageHolder imageHolder = null;
        if(textfield != null && multipartResolver.isMultipart(request))
        {

            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;

            CommonsMultipartFile img = (CommonsMultipartFile) multiRequest.getFile("pic");

            imageHolder = new ImageHolder(img.getOriginalFilename(),img.getInputStream());
        }
        category.setId(id);
        category.setTid(tid);
        category.setName(name);
        category.setDescription(description);
        category.setKeywords(keywords);
        category.setType(type);





        categoryService.update(category,imageHolder);



        return "redirect:/backend/category/index";



    }

    @RequestMapping(value="/del",method = RequestMethod.GET)
    public String del(HttpServletRequest request)  throws IOException {

        Long id = HttpServletRequestUtil.getLong(request,"id");


        int Id =  categoryService.del(id);


        return "redirect:/backend/category/index";



    }

}