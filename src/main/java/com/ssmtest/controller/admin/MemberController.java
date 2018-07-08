package com.ssmtest.controller.admin;


import com.ssmtest.entity.Member;
import com.ssmtest.service.MemberService;
import com.ssmtest.util.HttpServletRequestUtil;
import com.ssmtest.util.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Controller
@RequestMapping("/backend/member")
public class MemberController {

    @Autowired
    private MemberService memberService;


    @RequestMapping(value="/index")
    public String index()  throws IOException {


        return "Admin/Member/index";
    }


    @RequestMapping(value="/editAjax",method = RequestMethod.POST)
    public String editAjax(HttpServletRequest request)  throws IOException {


        String pass1 = HttpServletRequestUtil.getString(request,"pass1");

        String pass2 = HttpServletRequestUtil.getString(request,"pass2");

        String kouling = HttpServletRequestUtil.getString(request,"kouling");

        if (pass2 == null || pass1 == null || !pass1.equals(pass2)) {

        }else  {

            Member member = new Member();

            member.setId(1);

            if (kouling != null) {
                member.setKouling(kouling);
            }
            pass2 = Tools.getMD5Str(pass2);

            member.setPassword(pass2);

            memberService.update(member);
        }




        return "redirect:/backend/member/index";

    }


}