package com.ys.inventory.common.configurer.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Web配置
 * @author wyh
 * @version 2017/12/25.
 */
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    private final Logger logger = LoggerFactory.getLogger(WebMvcConfigurer.class);

    /**
     * 支持跨域
     * @param registry 注册跨域url mapping
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("*");
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(0, new ByteArrayHttpMessageConverter());
    }

}
