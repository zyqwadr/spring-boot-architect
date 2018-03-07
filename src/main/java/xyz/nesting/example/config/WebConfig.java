package xyz.nesting.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import xyz.nesting.example.interceptor.UrlInterceptor;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {	// 定义MVC配置
	@Override
	public void addInterceptors(InterceptorRegistry registry) {	// 进行拦截器的注册处理操作
		registry.addInterceptor(new UrlInterceptor()).addPathPatterns("/**") ;	// 匹配路径
		super.addInterceptors(registry);
	}
}
