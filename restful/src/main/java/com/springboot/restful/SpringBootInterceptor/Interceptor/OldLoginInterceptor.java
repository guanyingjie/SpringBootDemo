package com.springboot.restful.SpringBootInterceptor.Interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OldLoginInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(OldLoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("begin preHandle");
        long startTime = System.currentTimeMillis();
        logger.info("url:"+request.getRequestURI());
        System.out.println("url:"+request.getRequestURI());
        System.out.println("startTime:"+startTime);

        request.setAttribute("startTime",startTime);
        logger.info("sorry the api is delete please redirect to /admin/login");
        response.sendRedirect(request.getContextPath()+"/admin/login");

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("begin postHandle");
        System.out.println("url:"+request.getRequestURI());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("begin afterCompletion");
        Long startTime = (Long)request.getAttribute("startTime");
        Long endTime = System.currentTimeMillis();
        System.out.println("url:"+request.getRequestURI());
        System.out.println("total time:"+(endTime-startTime));

    }
}
