package com.machine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description: 应用启动类
 *
 * @author machine
 * @date 2017年12月27日 下午1:52:59
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableTransactionManagement
public class DeptStartSpringBootMain {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(DeptStartSpringBootMain.class, args);
	}
}