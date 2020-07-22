package com.springboot.restful.SpringBootInterceptor.Config;

import com.springboot.restful.SpringBootInterceptor.Interceptor.AdminInterceptor;
import com.springboot.restful.SpringBootInterceptor.Interceptor.LoginInterceptor;
import com.springboot.restful.SpringBootInterceptor.Interceptor.OldLoginInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor());
        registry.addInterceptor(new OldLoginInterceptor())
                .addPathPatterns("/admin/login");

        registry.addInterceptor(new AdminInterceptor())
                .addPathPatterns("/admin/*")
                .excludePathPatterns("/admin/oldLogin");
    }
}
