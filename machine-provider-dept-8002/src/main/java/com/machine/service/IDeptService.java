package com.machine.service;

import java.util.List;

import com.machine.vo.Dept;

/**
 * @Description: 部门
 *
 * @author machine
 * @date 2018年1月13日 下午11:46:31
 */
public interface IDeptService {

	public int doCreate(Dept dept);

	public Dept findById(long id);

	public List<Dept> findAll();

}
