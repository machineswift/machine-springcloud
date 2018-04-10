package com.machine.rest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.machine.service.IDeptService;
import com.machine.vo.Dept;

/**
 * @Description: 部门
 *
 * @author machine
 * @date 2018年1月14日 上午12:37:56
 */
@RestController
@RequestMapping("/springcloud/provider/dept")
public class DeptRest {

	@Resource(name = "deptService")
	private IDeptService deptService;

	/* Eureka的发现服务 */
	@Resource
	private DiscoveryClient client;

	/**
	 * @Description: Browser[http://localhost:8001/springcloud/provider/dept/discover]
	 *               (返回发现服务信息)
	 * @author machine
	 * @date 2018年1月14日 上午12:40:15
	 */
	@RequestMapping(value = "/discover", method = RequestMethod.GET)
	public Object discover() {
		return JSON.toJSON(this.client);
	}

	/**
	 * @Description: Browser[http://localhost:8001/springcloud/provider/dept/sessionId]
	 *
	 * @author machine
	 * @date 2018年1月14日 上午12:40:15
	 */
	@RequestMapping(value = "/sessionId", method = RequestMethod.GET)
	public Object sessionId(HttpServletRequest request) {
		return request.getSession().getId();
	}

	/**
	 * @Description: Browser[http://localhost:8001/springcloud/provider/dept/add]
	 *
	 * @author machine
	 * @date 2018年1月14日 上午12:40:15
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Object add(@RequestBody Dept dept) {
		return this.deptService.doCreate(dept);
	}

	/**
	 * @Description: Browser[http://localhost:8001/springcloud/provider/dept/get/4]
	 *
	 * @author machine
	 * @date 2018年1月14日 上午12:40:15
	 */
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Object get(@PathVariable("id") long id) {
		return this.deptService.findById(id);
	}

	/**
	 * @Description: Browser[http://localhost:8001/springcloud/provider/dept/list]
	 *
	 * @author machine
	 * @date 2018年1月14日 上午12:40:15
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Object list() {
		return this.deptService.findAll();
	}
}
