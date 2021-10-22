package com.example.demo.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.DateTimeFormat;

public class EmployeeBean {
	private Integer empId;
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	@NotEmpty(message = "Please fill this field")
	private String Name;
	
	@NotNull(message = "Please fill this field")
	private Integer PerDay;
	
	@NotEmpty(message = "Please fill this field")
	private String PhoneNo;
	
	@NotEmpty(message = "Please fill this field")
	private String AdharCardNo;
	
	@NotEmpty(message = "Please fill this field")
	private String Email;
	
	@NotEmpty(message = "Please fill this field")
	private String Department;
	
	@NotEmpty(message = "Please fill this field")
	private String Gender;
	
	@NotNull(message = "Please fill this field")
	@DateTimeFormat(pattern = "dd-MMM-yyyy")
	private Date DOJ;
	
	@NotNull(message = "Please fill this field")
	private Integer AllocProject;
	
	private Integer status = 1;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
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
