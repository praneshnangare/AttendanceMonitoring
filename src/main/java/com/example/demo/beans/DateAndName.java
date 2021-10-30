package com.example.demo.beans;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DateAndName {


	@DateTimeFormat(pattern = "dd-MMM-yyyy")
	private Date fromDate;
	@DateTimeFormat(pattern = "dd-MMM-yyyy")
	private Date toDate;
	

	private Integer empId;
	
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
}
