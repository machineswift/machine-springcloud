package com.machine.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.machine.vo.Company;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @Description: 公司
 *
 * @author machine
 * @date 2018年1月18日 下午10:00:40
 */
@RestController
@RequestMapping("/springcloud/provider/company")
public class CompanyRest {

	/**
	 * @Description: Browser[http://localhost:8101/springcloud/provider/company/get/machine]
	 *               必须要加上@HystrixCommand才可以监控
	 * @author machine
	 * @date 2018年1月14日 上午12:40:15
	 */
	@RequestMapping(value = "/get/{title}", method = RequestMethod.GET)
	@HystrixCommand
	public Object get(@PathVariable("title") String title) {
		Company company = new Company();
		company.setTitle(title);
		company.setNote("www.machine.com");
		return company;
	}

}
