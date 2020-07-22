package com.springboot.restful.SpringBootFilter.MyFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class myfilter2 implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(myfilter2.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("初始化过滤器2");

    }

    @Override
    public void destroy() {
        logger.info("销毁过滤器2");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("过滤器2开始过滤请求");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requesturl = request.getRequestURI();
        System.out.println("请求的url为："+requesturl);
        long startTime = System.currentTimeMillis();
        filterChain.doFilter(servletRequest,servletResponse);
        long endTime = System.currentTimeMillis();
        System.out.println("2过滤结束，话费时间为："+(endTime-startTime));

    }
}
