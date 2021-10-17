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
@Table(name = "attendance")
public class AttendanceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer attendanceId;
	private Integer Empid;
	@Temporal(TemporalType.DATE)
	private Date attendanceDate;
	public Integer getAttendanceId() {
		return attendanceId;
	}
	public void setAttendanceId(Integer attendanceId) {
		this.attendanceId = attendanceId;
	}
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
		return "AttendanceBean [attendanceId=" + attendanceId + ", Empid=" + Empid + ", attendanceDate="
				+ attendanceDate + "]";
	}
}
