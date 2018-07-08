package com.ssmtest.controller.admin;

import com.ssmtest.entity.Nav;
import com.ssmtest.service.NavService;
import com.ssmtest.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/backend/nav")
public class NavController {

    @Autowired
    private NavService navService;

    @RequestMapping(value="/index")
    public String index(ModelMap map)  throws IOException {

        Nav nav = new Nav();

        nav.setTid(0);

        List<Nav> navFather  = navService.queryNavResult(nav);
        nav.setTid(1);
        List<Nav> navChild  = navService.queryNavResult(nav);

        map.put("navFather", navFather);
        map.put("navChild", navChild);


        return "Admin/Nav/index";
    }

    @RequestMapping(value="/add")
    public String add(ModelMap map)  throws IOException {


        Nav nav = new Nav();

        nav.setTid(0);

        List<Nav> navFather  = navService.queryNavResult(nav);

        map.put("navFather", navFather);


        return "Admin/Nav/add";
    }


    @RequestMapping(value="/addAjax",method = RequestMethod.POST)
    public String addAjax(Nav nav)  throws IOException {


        String time = String.valueOf(System.currentTimeMillis() / 1000);

        nav.setTime(time);

//        System.out.println("nav is:"+nav);

        int id =  navService.insert(nav);

        return "redirect:/backend/nav/index";



    }

    @RequestMapping(value="/edit",method = RequestMethod.GET)
    public String edit(HttpServletRequest request,ModelMap map)  throws IOException {

        Long id = HttpServletRequestUtil.getLong(request,"id");
        Nav navDetail =  navService.getNavById(id);

        Nav nav = new Nav();

        nav.setTid(0);

        List<Nav> navFather  = navService.queryNavResult(nav);

        map.put("navFather", navFather);

        map.put("nav",navDetail);


        return "Admin/Nav/edit";



    }

    @RequestMapping(value="/editAjax",method = RequestMethod.POST)
    public String editAjax(Nav nav)  throws IOException {




        String time = String.valueOf(System.currentTimeMillis() / 1000);

        nav.setTime(time);


//        System.out.println("nav is:"+nav.toString());


        int id =  navService.update(nav);

//        System.out.println(id);



        return "redirect:/backend/nav/index";



    }


    @RequestMapping(value="/del",method = RequestMethod.GET)
    public String del(HttpServletRequest request)  throws IOException {

        Long id = HttpServletRequestUtil.getLong(request,"id");


        int reId =  navService.del(id);


        return "redirect:/backend/nav/index";



    }

}