package com.example.demo.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.beans.DepartmentBean;
import com.example.demo.beans.EmployeeBean;
import com.example.demo.entities.DepartmentEntity;
import com.example.demo.entities.EmployeeEntity;
import com.example.demo.entities.ProjectEntity;

@Repository
public class EmployeeDAOWrapper {
	@Autowired
	private EmployeeDAO employeeDAO;
	@Autowired
	private AttendanceDAO attendanceDAO;
	@Autowired
	private ProjectDAO projectDAO;
	@Autowired
	private DepartmentDAO departmentDAO;
	
	public Integer addEmployee(EmployeeBean employeeBean) {
		EmployeeEntity employeeEntity = convertBeanToEntity(employeeBean);
		EmployeeEntity  employeeEntity1 = new EmployeeEntity();
		if(employeeEntity != null) {
			employeeEntity1 = employeeDAO.save(employeeEntity);
			
		}
		return employeeEntity1.getEmpId();
	}
	
	
	private EmployeeEntity convertBeanToEntity(EmployeeBean employeeBean) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employeeBean, employeeEntity);
		return employeeEntity;
	}
	private DepartmentBean convertEntityToBean(DepartmentEntity departmentEntity){
		DepartmentBean departmentBean = new DepartmentBean();
		BeanUtils.copyProperties(departmentEntity, departmentBean);
		return departmentBean;
	}


	public List<ProjectEntity> getAllProjects() {
		// TODO Auto-generated method stub
		return projectDAO.findAll();
	}


	public List<DepartmentBean> getDepartmentByProjectId(Integer projectId) {
		// TODO Auto-generated method stub
		List<DepartmentEntity> dls = departmentDAO.findByProjectId(projectId);
		List<DepartmentBean> ls = new ArrayList<DepartmentBean>();
		for (DepartmentEntity departmentEntity : dls) {
			DepartmentBean departmentBean = convertEntityToBean(departmentEntity);
			ls.add(departmentBean);
		}
		return ls;
		
	}
	
}
