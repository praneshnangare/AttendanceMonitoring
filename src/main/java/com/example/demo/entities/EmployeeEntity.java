package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "employee")

public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer EmpId;
	private String Name;
	private Integer PerDay;
	private String PhoneNo;
	private String AdharCardNo;
	private String Email;
	private String Department;
	private String Gender;
	@Temporal(TemporalType.DATE)
	private Date DOJ;
	private Integer AllocProject;
	
	
	public Integer getEmpId() {
		return EmpId;
	}
	public void setEmpId(Integer empId) {
		EmpId = empId;
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
