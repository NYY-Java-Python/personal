package com.lingku.common.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.lingku.common.passport.PassportSSOInterceptor;

/**
 * @author NYY
 * @2019年5月28日
 * @description 配置拦截器
 */

@SuppressWarnings("deprecation")
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		// 拦截所有请求,通过判断 是否有注解@LoginRequired注解决定是否需要登录
		registry.addInterceptor(authenticationInterceptor()).addPathPatterns("/**");

	}

	@Bean
	public PassportSSOInterceptor authenticationInterceptor() {
	//返回自己的拦截,开始校验
		return new PassportSSOInterceptor();
	}
}
