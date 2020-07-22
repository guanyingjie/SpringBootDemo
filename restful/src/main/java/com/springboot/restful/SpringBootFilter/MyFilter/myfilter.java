package com.springboot.restful.SpringBootFilter.MyFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.logging.LogRecord;

@Component
public class myfilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(myfilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("初始化过滤器",filterConfig.getFilterName());

    }

    @Override
    public void destroy() {
        logger.info("销毁过滤器");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("过滤器开始过滤请求");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String url = request.getRequestURI();
        System.out.println("请求的接口为:"+url);
        long startTime = System.currentTimeMillis();
        //通过doFilter功能实现过滤
        filterChain.doFilter(servletRequest,servletResponse);
        long endTime = System.currentTimeMillis();
        System.out.println("过滤结束，花费时间为："+(endTime-startTime));
    }
}
