package com.shristi.constr;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
@Component
@PropertySource("classpath:application.properties")
public class Department {
	private String deptId;
	private String deptName;
	private String deptHead;
	
	
	public String getDeptId() {
		return deptId;
	}
	@Value("${department.deptId}")
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	@Value("${department.deptName}")
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptHead() {
		return deptHead;
	}
	@Value("${department.deptHead}")
	public void setDeptHead(String deptHead) {
		this.deptHead = deptHead;
	}
	
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", deptHead=" + deptHead + "]";
	}
}
