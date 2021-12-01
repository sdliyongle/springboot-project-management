package com.example.springbootprojectmanagement.config;

import com.example.springbootprojectmanagement.interceptor.ResourceInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author ZengQi
 * @description: TODO
 * @date 2021/11/26 0026 10:36
 */
@Configuration
public class ResourceConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ResourceInterceptor()).excludePathPatterns("/public/**");
    }

    @Override
    //需要告知系统，这是要被当成静态文件的！
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //第一个方法设置访问路径前缀，第二个方法设置资源路径
        registry.addResourceHandler("/public/**")
                .addResourceLocations("classpath:/public/");
    }
}
