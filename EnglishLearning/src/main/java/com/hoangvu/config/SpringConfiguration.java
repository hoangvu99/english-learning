package com.hoangvu.config;

import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.UrlTemplateResolver;

@Configuration
public class SpringConfiguration implements WebMvcConfigurer{
	
	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// thêm thư viện bootstrap
		registry.addResourceHandler("/resources/bootstrap/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/bootstrap/4.0.0/");
    registry.addResourceHandler("/resources/jquery/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/jquery/3.0.0/");
    registry.addResourceHandler("/resources/css/**").addResourceLocations("classpath:/static/css/");
	}
	
	@Bean
	public Random random() {
		return new Random();
	}
	
	
}
