package com.machine.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.machine.client.service.IDeptClientService;
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

	@Resource
	private IDeptClientService deptClientService;

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
		return this.deptClientService.add(dept);
	}

	/**
	 * @Description: Browser[http://localhost/springcloud/consumer/dept/get/4]
	 *
	 * @author machine
	 * @date 2018年1月14日 上午12:40:15
	 */
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Object get(@PathVariable long id) {
		return this.deptClientService.get(id);
	}

	/**
	 * @Description: Browser[http://localhost/springcloud/consumer/dept/list]
	 *
	 * @author machine
	 * @date 2018年1月14日 上午12:40:15
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Object list() {
		return this.deptClientService.list();
	}
}
