package com.machine.dao;

import java.util.List;

import com.machine.vo.Dept;

/**
 * @Description: 部门
 *
 * @author machine
 * @date 2018年1月13日 下午11:00:48
 */
public interface IDeptDao {

	final static String NAME_SPACE = "com.machine.dao.IDeptDao.";

	public int doCreate(Dept dept);

	public Dept findById(long id);

	public List<Dept> findAll();
}
