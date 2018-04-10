package com.machine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @Description: 应用启动类
 *
 * @author machine
 * @date 2017年12月27日 下午1:52:59
 */
@SpringBootApplication
@EnableHystrixDashboard
@EnableTurbine
public class HystrixTurbineApp {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(HystrixTurbineApp.class, args);
	}
}

/**
 * URL:http://localhost:9101/turbine.stream?cluster=default
 * 
 * http://localhost:8101/springcloud/provider/company/get/machine
 * http://localhost:8102/springcloud/provider/company/get/machine
 * http://localhost:8005/springcloud/provider/dept/get/4
 */
