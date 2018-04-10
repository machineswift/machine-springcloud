package com.machine.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.machine.dao.IDeptDao;
import com.machine.service.IDeptService;
import com.machine.vo.Dept;

/**
 * @Description: 部门
 *
 * @author machine
 * @date 2018年1月13日 下午11:53:11
 */
@Service(value = "deptService")
public class DeptServiceImpl implements IDeptService {

	@Resource(name = "deptDao")
	private IDeptDao deptDao;

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int doCreate(Dept dept) {
		return this.deptDao.doCreate(dept);
	}

	@Override
	@Transactional(readOnly = true)
	public Dept findById(long id) {
		return this.deptDao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Dept> findAll() {
		return this.deptDao.findAll();
	}

}
