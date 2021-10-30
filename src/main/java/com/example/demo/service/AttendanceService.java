package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.EmployeeDAOWrapper;
import com.example.demo.beans.AttendanceBean;
import com.example.demo.beans.DepartmentBean;
import com.example.demo.beans.EmployeeBean;
import com.example.demo.entities.ProjectEntity;

@Service
public class AttendanceService {

	@Autowired
	private EmployeeDAOWrapper employeeDAOWrapper;
	
	public Integer addEmployee(EmployeeBean employeeBean) {
		
		Integer id = employeeDAOWrapper.addEmployee(employeeBean);
		return id;
	}

	public List<ProjectEntity> getAllProjects() {
		// TODO Auto-generated method stub
		return employeeDAOWrapper.getAllProjects();
	}

	public List<DepartmentBean> getDepartmentByProjectId(Integer projectId) {
		// TODO Auto-generated method stub
		return employeeDAOWrapper.getDepartmentByProjectId(projectId);
	}

	public List<EmployeeBean> getAllActiveEmployeeList() {
		// TODO Auto-generated method stub
		return employeeDAOWrapper.getAllActiveEmployeeList();
	}

	public void saveAttendanceRecord(List<AttendanceBean> attendanceBean) {
		// TODO Auto-generated method stub
		employeeDAOWrapper.saveAttendanceRecord(attendanceBean);
	}
	public Map<Integer, String> getAllActiveEmployeeMap(){
		Map<Integer, String> map = new HashMap<Integer , String>();
		List<EmployeeBean> ls =  employeeDAOWrapper.getAllActiveEmployeeList();
		for (EmployeeBean employeeBean : ls) {
			map.put(employeeBean.getEmpId(), employeeBean.getName());
		}
		return map;
	}
}
