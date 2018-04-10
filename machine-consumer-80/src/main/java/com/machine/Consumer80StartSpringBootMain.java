package com.machine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.common.config.LoadBalanceConfig;

/**
 * @Description: 应用启动类
 *
 * @author machine
 * @date 2017年12月27日 下午1:52:59
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "ribbonClient", configuration = LoadBalanceConfig.class)
public class Consumer80StartSpringBootMain {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Consumer80StartSpringBootMain.class, args);
	}
}