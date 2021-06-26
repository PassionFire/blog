package com.ujiuye.utils;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author: zwp
 * @version: 1.0
 * @create 2021-06-21 17:14
 */
public class AuthHandleInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断是否为登录操作，是，则放行
        if (request.getRequestURL().toString().contains("login")){
            return true;
        }
        //判断是否登录过
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if (user != null){
            return true;
        }
        //未登录则跳至登录页面
        request.getRequestDispatcher("/login.html").forward(request,response);
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle1....");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("afterHandle1....");
    }

}
