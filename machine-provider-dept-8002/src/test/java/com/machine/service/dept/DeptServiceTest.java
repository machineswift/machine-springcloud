package com.machine.service.dept;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.machine.DeptStartSpringBootMain;
import com.machine.service.IDeptService;
import com.machine.vo.Dept;

@SpringBootTest(classes = DeptStartSpringBootMain.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class DeptServiceTest {

	@Resource(name = "deptService")
	private IDeptService deptService;

	@Test
	public void testDoCreate() {
		Dept dept = new Dept();
		dept.setCode("DEPT"+System.currentTimeMillis());
		dept.setName("开发部"+System.currentTimeMillis());
		dept.setLocation("SPRINGCLOUD8001");
		System.out.println(this.deptService.doCreate(dept));
	}
	
	@Test
	public void testFindById() {
		System.out.println(this.deptService.findById(4L));
	}

	@Test
	public void testFindAll() {
		System.out.println(this.deptService.findAll());
	}
}
