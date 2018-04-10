package com.machine.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.machine.vo.Dept;

/**
 * @Description: 部门
 *
 * @author machine
 * @date 2018年1月14日 上午1:14:52
 */
@RestController
@RequestMapping("/springcloud/consumer/dept/")
public class ConsumerDeptController {

	private static final String DEPT_DISCOVER_URL = "http://MACHINE-PROVIDER-DEPT/springcloud/provider/dept/discover";
	private static final String DEPT_ADD_URL = "http://MACHINE-PROVIDER-DEPT/springcloud/provider/dept/add";
	private static final String DEPT_GET_URL = "http://MACHINE-PROVIDER-DEPT/springcloud/provider/dept/get/4";
	private static final String DEPT_LIST_URL = "http://MACHINE-PROVIDER-DEPT/springcloud/provider/dept/list";

	@LoadBalanced
	@Resource(name = "restTemplateBalanced")
	private RestTemplate restTemplateBalanced;

	@Resource(name = "httpHeaders")
	private HttpHeaders httpHeaders;

	@Resource
	private LoadBalancerClient loadBalancerClient;

	/**
	 * @Description: Browser[http://localhost/springcloud/consumer/dept/discover]
	 *
	 * @author machine
	 * @date 2018年1月14日 上午12:40:15
	 */
	@RequestMapping(value = "/discover", method = RequestMethod.GET)
	public Object discover() {
		return this.restTemplateBalanced
				.exchange(DEPT_DISCOVER_URL, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), Object.class).getBody();
	}

	/**
	 * @Description: Browser[http://localhost/springcloud/consumer/dept/info]
	 *
	 * @author machine
	 * @date 2018年1月14日 上午12:40:15
	 */
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public Object info() {
		ServiceInstance serviceInstance = this.loadBalancerClient.choose("MACHINE-PROVIDER-DEPT");
		return new StringBuilder("【*** ServiceInstance ***】host = ").append(serviceInstance.getHost())
				.append("【*** ServiceInstance ***】port = ").append(serviceInstance.getPort())
				.append("【*** ServiceInstance ***】serviceId = ").append(serviceInstance.getServiceId()).toString();
	}

	/**
	 * @Description: Browser[http://localhost/springcloud/consumer/dept/add]
	 *
	 * @author machine
	 * @date 2018年1月14日 上午12:40:15
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Object add() {
		Dept dept = new Dept();
		dept.setCode("DEPT" + System.currentTimeMillis());
		dept.setName("开发部" + System.currentTimeMillis());
		dept.setLocation("SPRINGCLOUD8001");
		return this.restTemplateBalanced
				.exchange(DEPT_ADD_URL, HttpMethod.POST, new HttpEntity<Object>(dept, this.httpHeaders), Object.class)
				.getBody();
	}

	/**
	 * @Description: Browser[http://localhost/springcloud/consumer/dept/get]
	 *
	 * @author machine
	 * @date 2018年1月14日 上午12:40:15
	 */
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public Object get() {
		return this.restTemplateBalanced
				.exchange(DEPT_GET_URL, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), Dept.class).getBody();
	}

	/**
	 * @Description: Browser[http://localhost/springcloud/consumer/dept/list]
	 *
	 * @author machine
	 * @date 2018年1月14日 上午12:40:15
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Object list() {

		return this.restTemplateBalanced
				.exchange(DEPT_LIST_URL, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), List.class).getBody();
	}
}
