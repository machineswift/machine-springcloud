package com.machine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Description: 应用启动类
 *
 * @author machine
 * @date 2017年12月27日 下午1:52:59
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashbordApp {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(HystrixDashbordApp.class, args);
	}
}

/**
 * URL:http://localhost:9001/hystrix
 * 
 * ADD:http://machine:machine@localhost:8004/hystrix.stream
 * ADD:http://localhost:9101/turbine.stream?cluster=default
 */
