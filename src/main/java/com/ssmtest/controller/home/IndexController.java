package com.ssmtest.controller.home;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;


@Controller(value = "/home/index")
@RequestMapping("/index")
public class IndexController {
    @RequestMapping(value="/index")
    public String index()  throws IOException {

        return "Home/Index/index";
    }



}