package com.example.demo.DAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.beans.AttendanceBean;
import com.example.demo.beans.EmployeeBean;
import com.example.demo.entities.AttendanceEntity;

@Repository
public class ReportDAOWrapper {

	@Autowired
	private AttendanceDAO attendanceDAO;
 
	public List<AttendanceBean> getAttendanceDetails(Integer empId, Date fromDate , Date toDate) {
		// TODO Auto-generated method stub
		List<AttendanceEntity> ls;
		if(empId!= -1) {
			ls = attendanceDAO.findByEmpIdAndAttendanceDateBetween(empId, fromDate , toDate);
		}
		else {
			ls = attendanceDAO.findByAttendanceDateBetween(fromDate , toDate);
		}
		
		List<AttendanceBean> ls1= convertEntityLsToBeanLs(ls);
		return ls1;
	}

	public List<AttendanceBean> getAttendanceByEmpId(Integer empId) {
		// TODO Auto-generated method stub
		List<AttendanceEntity> ls = attendanceDAO.findByEmpId(empId);
		System.out.println("by empId->   "+ ls.size());
		List<AttendanceBean> ls1= convertEntityLsToBeanLs(ls);
		return ls1;
	}
	
	private List<AttendanceBean> convertEntityLsToBeanLs(List<AttendanceEntity> entityLs){
		List<AttendanceBean> beanLs = new ArrayList<AttendanceBean>();
		
		for (AttendanceEntity attendanceEntity : entityLs) {
			AttendanceBean attendanceBean = new AttendanceBean();
			BeanUtils.copyProperties(attendanceEntity, attendanceBean);
			beanLs.add(attendanceBean);
			}
		return beanLs;
	}
	
}








