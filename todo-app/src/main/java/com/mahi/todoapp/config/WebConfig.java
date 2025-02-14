package com.mahi.todoapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	private final MyCustomInterceptor myCustomInterceptor;

	public WebConfig(MyCustomInterceptor myCustomInterceptor) {
		this.myCustomInterceptor = myCustomInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(myCustomInterceptor).addPathPatterns("/**"); // Intercept all requests
//		registry.addInterceptor(myCustomInterceptor).addPathPatterns("/delete*"); // Intercept all delete requests
	}

//	@Override
//	public void configureViewResolvers(ViewResolverRegistry registry) {
//		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//		viewResolver.setPrefix("/WEB-INF/jsp/");
//		viewResolver.setSuffix(".jsp");
//		registry.viewResolver(viewResolver);
//	}
}
