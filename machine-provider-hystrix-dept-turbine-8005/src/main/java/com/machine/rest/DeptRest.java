package com.machine.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

	/**
	 * @Description: Browser[http://localhost:8005/springcloud/provider/dept/get/4]
	 *
	 * @author machine
	 * @date 2018年1月14日 上午12:40:15
	 */
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	@HystrixCommand()
	public Object get(@PathVariable("id") long id) {
		Dept dept = new Dept();
		dept.setId(id);
		dept.setCode("DEPT" + System.currentTimeMillis());
		dept.setName("开发部" + System.currentTimeMillis());
		dept.setLocation("SPRINGCLOUD8001");
		return dept;
	}
}
