package com.machine.rest;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.machine.service.IDeptService;
import com.machine.vo.Dept;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

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

	/**
	 * @Description: hystrix
	 *
	 * @author machine
	 * @date 2018年1月14日 上午12:40:15
	 */
	public Object getFallback(@PathVariable("id") long id) {
		Dept dept = new Dept();
		dept.setId(999999L);
		dept.setName("【Error】machine-provider-hystrix");
		dept.setLocation("Dept-Provider");
		return dept;
	}

	/**
	 * @Description: Browser[http://localhost:8001/springcloud/provider/dept/get/4]
	 *
	 * @author machine
	 * @date 2018年1月14日 上午12:40:15
	 */
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod="getFallback")
	public Object get(@PathVariable("id") long id) {
		Dept dept = this.deptService.findById(id);
		if(dept == null) {
			throw new RuntimeException("部门信息不存在!");
		}
		return dept;
	}
}
