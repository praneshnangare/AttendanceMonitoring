package com.example.demo.beans;

public class DepartmentBean {
	private Integer deptId;
	private String deptName;
	private Integer projectId;
	public Integer getProjectId() {
		return projectId;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "DepartmentBean [DeptName=" + deptName + "]";
	}
	
	
}
