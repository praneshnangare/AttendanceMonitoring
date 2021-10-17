package com.example.demo.beans;

public class ProjectBean {
	private String projectName;

	@Override
	public String toString() {
		return "ProjectBean [projectName=" + projectName + "]";
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
}
