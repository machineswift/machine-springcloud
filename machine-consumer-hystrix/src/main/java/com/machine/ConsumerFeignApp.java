package com.machine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @Description: 应用启动类
 *
 * @author machine
 * @date 2017年12月27日 下午1:52:59
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com.machine.client.service"})
public class ConsumerFeignApp {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ConsumerFeignApp.class, args);
	}
}