package com.machine.vo;

import java.io.Serializable;

/**
 * @Description: 部门
 *
 * @author machine
 * @date 2018年1月13日 下午3:28:27
 */
@SuppressWarnings("serial")
public class Dept implements Serializable {
	private long id;
	private String code;
	private String name;
	private String location;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return new StringBuilder("{'id':").append(id).append(",'code':'").append(code).append("','name':'")
				.append(name).append("','location':'").append(location).append("'}").toString();
	}
}
