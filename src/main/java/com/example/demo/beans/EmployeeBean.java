package com.example.demo.beans;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class EmployeeBean {

	private String Name;
	private Integer PerDay;
	private String PhoneNo;
	private String AdharCardNo;
	private String Email;
	private String Department;
	private String Gender;
	@DateTimeFormat(pattern = "dd-MMM-yyyy")
	private Date DOJ;
	private Integer AllocProject;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Integer getPerDay() {
		return PerDay;
	}
	public void setPerDay(Integer perDay) {
		PerDay = perDay;
	}
	public String getPhoneNo() {
		return PhoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		PhoneNo = phoneNo;
	}
	public String getAdharCardNo() {
		return AdharCardNo;
	}
	public void setAdharCardNo(String adharCardNo) {
		AdharCardNo = adharCardNo;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public Date getDOJ() {
		return DOJ;
	}
	public void setDOJ(Date dOJ) {
		DOJ = dOJ;
	}
	public Integer getAllocProject() {
		return AllocProject;
	}
	public void setAllocProject(Integer allocProject) {
		AllocProject = allocProject;
	}
	@Override
	public String toString() {
		return "employee [Name=" + Name + ", PerDay=" + PerDay + ", Department=" + Department + ", DOJ=" + DOJ
				+ ", AllocProject=" + AllocProject + "]";
	}
	
	
}
