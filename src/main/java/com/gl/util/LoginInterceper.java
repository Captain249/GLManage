package com.gl.util;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceper implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getContextPath();
        String requestUrl = request.getRequestURI();
        if(requestUrl.indexOf("toLogin")>0||requestUrl.indexOf("loginCheck")>0){
            return true;
        }else{
            if(request.getSession().getAttribute("user")!=null){
                return true;
            }
        }
        //response.sendRedirect(path+"/user/toLogin");
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
