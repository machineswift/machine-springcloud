package com.machine.client.service.fallback;

import java.util.List;

import org.springframework.stereotype.Component;

import com.machine.client.service.IDeptClientService;
import com.machine.vo.Dept;

import feign.hystrix.FallbackFactory;

/**
 * @Description: 消费端hystris
 *
 * @author machine
 * @date 2018年1月18日 下午8:50:07
 */
@Component
public class IDeptClientServiceFallbackFactory implements FallbackFactory<IDeptClientService> {

	@Override
	public IDeptClientService create(Throwable arg0) {
		return new IDeptClientService() {

			@Override
			public Integer add(Dept dept) {
				return null;
			}

			@Override
			public Dept get(long id) {
				Dept dept = new Dept();
				dept.setId(888888L);
				dept.setName("【Error】machine-Consumer-hystrix");
				dept.setLocation("Dept-Consumer");
				return dept;
			}

			@Override
			public List<Dept> list() {
				return null;
			}
		};
	}

}
