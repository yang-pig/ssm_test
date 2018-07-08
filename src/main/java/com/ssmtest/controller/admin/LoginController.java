package com.ssmtest.controller.admin;


import com.ssmtest.entity.Member;
import com.ssmtest.service.MemberService;
import com.ssmtest.util.EmptyUtil;
import com.ssmtest.util.HttpServletRequestUtil;

import com.ssmtest.util.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Controller
@RequestMapping("/backend/login")
public class LoginController {


    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/index")
    public String index() throws IOException {

        return "Admin/Login/index";
    }


    @RequestMapping(value = "/checklogin")
    public String checkLogin(HttpServletRequest request) throws IOException {

        String username = HttpServletRequestUtil.getString(request, "username");

        String password = HttpServletRequestUtil.getString(request, "password");

        String kouling = HttpServletRequestUtil.getString(request, "kouling");

        password =  Tools.getMD5Str(password);

        Member member = new Member();

        member.setUsername(username);
        member.setKouling(kouling);
        member.setPassword(password);

        Member re = memberService.doLogin(member);


        if (EmptyUtil.isEmpty(re)) {
            return "redirect:/backend/login/index";
        }else  {

            request.getSession().setAttribute("username",username);
            request.getSession().setAttribute("'kouling'", Tools.getMD5Str(kouling));


            return "redirect:/backend/index/index";
        }

    }

    @RequestMapping(value = "/layout")
    public String layout(HttpServletRequest request) throws IOException {

        request.getSession().removeAttribute("username");
        request.getSession().removeAttribute("'kouling'");

        return "redirect:/backend/login/index";
    }


}