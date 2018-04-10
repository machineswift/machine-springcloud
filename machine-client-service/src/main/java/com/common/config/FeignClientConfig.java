package com.common.config;

import org.springframework.context.annotation.Bean;

import feign.Logger;
import feign.Logger.Level;
import feign.auth.BasicAuthRequestInterceptor;

/**
 * @Description: feignClientConfig
 *
 * @author machine
 * @date 2018年1月18日 下午2:24:24
 */
public class FeignClientConfig {
	
	/**
	 * @Description: 日志级别
	 *
	 * @author machine
	 * @date 2018年1月18日 下午4:54:44
	*/
	@Bean
	public Logger.Level getFeignLoggerLevel(){
		return Level.FULL;
	}

	/**
	 * @Description: 安全认证
	 *
	 * @author machine
	 * @date 2018年1月18日 下午4:54:49
	*/
	@Bean(name = "basicAuthRequestInterceptor")
	public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor() {
		return new BasicAuthRequestInterceptor("machine", "machine");
	}
}
