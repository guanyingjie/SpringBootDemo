package com.springboot.restful.SpringBootFilter.Config;

import com.springboot.restful.SpringBootFilter.MyFilter.myfilter;
import com.springboot.restful.SpringBootFilter.MyFilter.myfilter2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;

//注册自定义的过滤器
@Configuration
public class MyFilterConfig {
    @Autowired
    myfilter myfilter;
    @Autowired
    myfilter2 myfilter2;
    @Bean
    public FilterRegistrationBean<myfilter> setupFilter(){
        FilterRegistrationBean<myfilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setOrder(2);
        filterRegistrationBean.setFilter(myfilter);
        filterRegistrationBean.setUrlPatterns(new ArrayList<>(Arrays.asList("/api/*")));
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<myfilter2>setupFilter2(){
        FilterRegistrationBean<myfilter2> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.setFilter(myfilter2);
        filterRegistrationBean.setUrlPatterns(new ArrayList<>(Arrays.asList("/api/*")));
        return filterRegistrationBean;
    }
}
