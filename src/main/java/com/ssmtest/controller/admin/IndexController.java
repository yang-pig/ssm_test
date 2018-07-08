package com.ssmtest.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Properties;


@Controller
@RequestMapping("/backend/index")
public class IndexController {
    @RequestMapping(value="/index")
    public String index(ModelMap map)  throws IOException {

        Properties props = System.getProperties();
        Runtime runtime = Runtime.getRuntime();
        long freeMemoery = runtime.freeMemory();
        long totalMemory = runtime.totalMemory();
        long usedMemory = totalMemory - freeMemoery;
        long maxMemory = runtime.maxMemory();
        long useableMemory = maxMemory - totalMemory + freeMemoery;
        map.put("props", props);
        map.put("freeMemoery", freeMemoery);
        map.put("totalMemory", totalMemory);
        map.put("usedMemory", usedMemory);
        map.put("maxMemory", maxMemory);
        map.put("useableMemory", useableMemory);

        return "Admin/Index/index";
    }



}