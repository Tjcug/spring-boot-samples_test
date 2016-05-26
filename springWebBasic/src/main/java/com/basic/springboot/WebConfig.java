package com.basic.springboot;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.Filter;

/**
 * Created by dell-pc on 2016/4/19.
 */
@Configuration
@ServletComponentScan
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/js/**")
                .addResourceLocations("classpath:/static/js/");
    }

    // 用于处理编码问题
    @Bean
    public Filter characterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }

    /////////////////////////////////////////添加过滤器///////////////////////////////
//    /**
//     *  配置Web过滤器
//     * @return 返回过滤器注册的Bean
//     */
//    @Bean
//    public FilterRegistrationBean FirstFiler(){
//        FilterRegistrationBean registrationBean=new FilterRegistrationBean();
//        registrationBean.setFilter(new FirstFilter());
//        registrationBean.addUrlPatterns("/hello");
//        registrationBean.setInitParameters(new HashMap<String, String>());
//        registrationBean.setName("firstFiler");
//        registrationBean.setDispatcherTypes(DispatcherType.REQUEST);
//        return registrationBean;
//    }
//
//    /**
//     *  配置Web过滤器
//     * @return 返回过滤器注册的Bean
//     */
//    @Bean
//    public FilterRegistrationBean SecondFiler(){
//        FilterRegistrationBean registrationBean=new FilterRegistrationBean();
//        registrationBean.setFilter(new SecondFilter());
//        registrationBean.addUrlPatterns("/hello");
//        registrationBean.setInitParameters(new HashMap<String, String>());
//        registrationBean.setName("secondFiler");
//        registrationBean.setDispatcherTypes(DispatcherType.REQUEST);
//        return registrationBean;
//    }
//
//    /**
//     *  配置错误页面过滤器
//     * @return 返回过滤器注册的Bean
//     */
//    @Bean
//    public FilterRegistrationBean ErrorFiler(){
//        FilterRegistrationBean registrationBean=new FilterRegistrationBean();
//        registrationBean.setFilter(new ErrorFilter());
//        registrationBean.addUrlPatterns("/error");
//        registrationBean.setInitParameters(new HashMap<String, String>());
//        registrationBean.setName("errorFiler");
//        registrationBean.setDispatcherTypes(DispatcherType.ERROR);
//        return registrationBean;
//    }
    /////////////////////////////////////////添加过滤器///////////////////////////////
}
