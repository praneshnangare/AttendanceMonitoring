package com.example.demo.beans;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class AttendanceBean {
	private Integer empId;
	private String name;
	private String status;
	private Integer extraHours;
	private String remarks;
	@DateTimeFormat(pattern = "dd-MMM-yyyy")
	private Date attendanceDate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empid) {
		this.empId = empid;
	}
	public Date getAttendanceDate() {
		return attendanceDate;
	}
	public void setAttendanceDate(Date attendanceDate) {
		this.attendanceDate = attendanceDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getExtraHours() {
		return extraHours;
	}
	public void setExtraHours(Integer extraHours) {
		this.extraHours = extraHours;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "AttendanceBean [Name=" + name + ", attendanceDate=" + attendanceDate + "]";
	}
	
	
	
}
