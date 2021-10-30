package com.example.demo.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.EmployeeDAOWrapper;
import com.example.demo.DAO.ReportDAOWrapper;
import com.example.demo.beans.AttendanceBean;
import com.example.demo.beans.AttendanceFormBean;
import com.example.demo.beans.EmployeeBean;

@Service
public class ReportService {

	@Autowired
	private ReportDAOWrapper reportDAOWrapper;
	@Autowired
	private EmployeeDAOWrapper employeeDAOWrapper;
	
	public AttendanceFormBean getAttendanceDetails(Integer empId , Date fromDate, Date toDate) {
		AttendanceFormBean attendanceFormBean = new AttendanceFormBean();
		List<AttendanceBean> ls = reportDAOWrapper.getAttendanceDetails(empId , fromDate , toDate);
		attendanceFormBean.setAttendanceList(ls);
		return attendanceFormBean;
	}
	
//	public AttendanceFormBean getAttendanceDetails(Integer empId , ) {
//		AttendanceFormBean attendanceFormBean = new AttendanceFormBean();
//		List<AttendanceBean> ls = reportDAOWrapper.getAttendanceByEmpId(empId);
//		attendanceFormBean.setAttendanceList(ls);
//		return attendanceFormBean;
//	}
//	
//	public AttendanceFormBean getAttendanceByDateAndEmpId(Date date , Integer empId) {
//		AttendanceFormBean attendanceFormBean = new AttendanceFormBean();
//		List<AttendanceBean> ls = reportDAOWrapper.getAttendaceByDateAndEmpId(date , empId);
//		attendanceFormBean.setAttendanceList(ls);
//		return attendanceFormBean;
//		
//	}
	
	public Map<Integer, String> getAllActiveEmployeeMap(){
		Map<Integer, String> map = new HashMap<Integer , String>();
		List<EmployeeBean> ls =  employeeDAOWrapper.getAllActiveEmployeeList();
		for (EmployeeBean employeeBean : ls) {
			map.put(employeeBean.getEmpId(), employeeBean.getName());
		}
		return map;
	}
	
	
}















