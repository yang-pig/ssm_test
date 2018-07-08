package com.ssmtest.handler;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor  {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
// 获取请求的url
        String url = httpServletRequest.getRequestURI();


//        System.out.println("url:"+url);

        if ((url.indexOf("login")) >= 0) {
            // 登陆接口，放行

            return true;
        } else {
            HttpSession session = httpServletRequest.getSession();
            String username = (String) session.getAttribute("username");
            if (username != null) {
                return true;
            }else {
                // 不符合条件的跳转到登录界面
                String ContextPath = httpServletRequest.getContextPath();
                httpServletResponse.sendRedirect(ContextPath+"/backend/login/index");
                return false;
            }
        }


    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
