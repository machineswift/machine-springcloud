package com.common.config;

import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.IRule;

/**
 * @Description: ribbon负载均衡策略
 *
 * @author machine
 * @date 2017年01月17日 下午1:52:59
 */
public class LoadBalanceConfig {

	/**
	 * @Description: 负载均衡策略
	 *
	 * @author machine
	 * @date 2018年1月17日 下午10:41:54
	 */
	@Bean
	public IRule ribbonRule() {
		/* 随机访问策略 */
		//return new com.netflix.loadbalancer.RandomRule();
		/* 根据相应时间分配一个weight,相应时间越长,weight越小,被选中的可能性越低 */
		return new com.netflix.loadbalancer.WeightedResponseTimeRule();
	}
}
