package com.kuanghui.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyIntercepter implements HandlerInterceptor {

    //return true；执行下一个拦截器，放行
    //在过滤器中，放行为：chain.doFilter(request,response);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        //判断什么时候放行
        //1.登录页面方向
        if(request.getRequestURI().contains("Login")){
            return true;
        }
        //2.session中存在数据也放行
        if(session.getAttribute("username")!=null){
            return true;
        }
        //不放行执行什么操作
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }

    //可以用来当作日志，只有通过preHandle才会执行postHandle和afterCompletion
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("================>处理后");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("================>清理");
    }
}
