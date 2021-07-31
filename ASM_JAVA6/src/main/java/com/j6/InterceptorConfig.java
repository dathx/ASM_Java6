package com.j6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.j6.interceptor.GlobalInterceptor;

// cau hinh chan url nao
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	@Autowired
	GlobalInterceptor globalInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(globalInterceptor)
		//chan tat ca
		.addPathPatterns("/**")
		//ngoai tru
		.excludePathPatterns("/rest/**","/admin/**","/images/**");
	}
}
