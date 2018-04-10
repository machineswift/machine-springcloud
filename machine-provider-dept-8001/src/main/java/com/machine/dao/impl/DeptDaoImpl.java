package com.machine.dao.impl;

import java.util.List;
import com.machine.vo.Dept;
import com.machine.dao.IDeptDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

/**
 * @Description: 部门
 *
 * @author machine
 * @date 2018年1月13日 下午11:41:06
 */
@Repository(value = "deptDao")
public class DeptDaoImpl implements IDeptDao {

	private final SqlSession sqlSession;

	public DeptDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int doCreate(Dept dept) {
		return this.sqlSession.insert(NAME_SPACE + "doCreate", dept);
	}

	@Override
	public Dept findById(long id) {
		return this.sqlSession.selectOne(NAME_SPACE + "findById", id);
	}

	@Override
	public List<Dept> findAll() {
		return this.sqlSession.selectList(NAME_SPACE + "findAll");
	}

}
