package org.bkn.system.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.bkn.web.interceptor.SessionInterceptor;

/**
 * MVC 路由控制方式,存放入子类应用上下文中
* @author 李志伟
* @date 2017年3月10日 下午6:08:37
 */
@Configuration  
@EnableWebMvc  
@ComponentScan(basePackages = {"com"}, excludeFilters={@ComponentScan.Filter(type=FilterType.ANNOTATION, value=org.springframework.stereotype.Service.class)})  
public class DispatcherServletConfig extends WebMvcConfigurerAdapter {
    
    @SuppressWarnings("rawtypes")
    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        RequestMappingHandlerAdapter requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(new org.springframework.http.converter.ByteArrayHttpMessageConverter());
        messageConverters.add(new com.bkn.browser.utils.UTF8StringHttpMessageConverter());
        messageConverters.add(new org.springframework.http.converter.FormHttpMessageConverter());
        messageConverters.add(new org.springframework.http.converter.xml.SourceHttpMessageConverter());
        messageConverters.add(new org.springframework.http.converter.json.MappingJackson2HttpMessageConverter());
        requestMappingHandlerAdapter.setMessageConverters(messageConverters);
        return requestMappingHandlerAdapter;
    }
    
    @Bean  
    public CommonsMultipartResolver multipartResolver() {  
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();  
        multipartResolver.setDefaultEncoding("utf-8");  
        multipartResolver.setMaxUploadSize(2048 * 1024);  
        multipartResolver.setMaxInMemorySize(2048);  
        return multipartResolver;  
    }  
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static-resource/**").addResourceLocations("/static-resource/");
        super.addResourceHandlers(registry);
    }
    
    @Bean
    public ViewResolver viewResolver() {
        UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(sessionInterceptor()).addPathPatterns("/**");
    }
    
    @Bean
    public HandlerInterceptor sessionInterceptor(){
        return new SessionInterceptor();
    }
    
}
