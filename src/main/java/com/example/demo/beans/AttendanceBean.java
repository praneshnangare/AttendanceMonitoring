package com.example.demo.beans;

import java.util.Date;

public class AttendanceBean {
	
	private Integer Empid;
	private Date attendanceDate;
	
	public Integer getEmpid() {
		return Empid;
	}
	public void setEmpid(Integer empid) {
		Empid = empid;
	}
	public Date getAttendanceDate() {
		return attendanceDate;
	}
	public void setAttendanceDate(Date attendanceDate) {
		this.attendanceDate = attendanceDate;
	}
	@Override
	public String toString() {
		return "AttendanceBean [Empid=" + Empid + ", attendanceDate=" + attendanceDate + "]";
	}
	
	
	
}
