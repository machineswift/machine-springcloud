package com.machine.config;

import java.nio.charset.Charset;
import java.util.Base64;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

/**
 * @Description: restConfig
 *
 * @author machine
 * @date 2018年1月14日 上午1:12:09
 */
@Configuration
public class RestConfig {
	
	@LoadBalanced
	@Bean(name="restTemplateBalanced")
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Primary
	@Bean(name="restTemplate")
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	/**
	 * @Description: consumer安全认证头信息配置
	 *
	 * @author machine
	 * @date 2018年1月15日 上午11:32:26
	 */
	@Bean(name = "httpHeaders")
	public HttpHeaders getHeaders() {
		String auth = "machine:machine";
		/* 进行加密处理 */
		byte[] encodeAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Basic " + new String(encodeAuth));
		return headers;
	}
}
