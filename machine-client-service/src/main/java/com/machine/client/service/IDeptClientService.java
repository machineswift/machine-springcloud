package com.machine.client.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.common.config.FeignClientConfig;
import com.machine.client.service.fallback.IDeptClientServiceFallbackFactory;
import com.machine.vo.Dept;

/**
 * @Description: client service 接口
 *
 * @author machine
 * @date 2018年1月18日 下午2:38:28
 */
@FeignClient(value = "MACHINE-PROVIDER-DEPT", configuration = FeignClientConfig.class, fallbackFactory = IDeptClientServiceFallbackFactory.class)
public interface IDeptClientService {

	@RequestMapping(method = RequestMethod.POST, value = "/springcloud/provider/dept/add")
	Integer add(@RequestBody Dept dept);

	@RequestMapping(method = RequestMethod.GET, value = "/springcloud/provider/dept/get/{id}")
	Dept get(@PathVariable("id") long id);

	@RequestMapping(method = RequestMethod.GET, value = "/springcloud/provider/dept/list")
	List<Dept> list();
}
