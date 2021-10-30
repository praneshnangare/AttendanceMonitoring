package com.example.demo.DAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.beans.AttendanceBean;
import com.example.demo.beans.DepartmentBean;
import com.example.demo.beans.EmployeeBean;
import com.example.demo.entities.AttendanceEntity;
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
	private EmployeeBean convertBeanToEntity(EmployeeEntity employeeEntity) {
		EmployeeBean employeeBean = new EmployeeBean();
		BeanUtils.copyProperties(employeeEntity, employeeBean);
		return employeeBean;
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


	public List<EmployeeBean> getAllActiveEmployeeList() {
		// TODO Auto-generated method stub
		List<EmployeeEntity> ls =  employeeDAO.findByStatus(1);
		List<EmployeeBean> beanls = new ArrayList<EmployeeBean>();
		for (EmployeeEntity employeeEntity : ls) {
			EmployeeBean employeeBean = convertBeanToEntity(employeeEntity);
			beanls.add(employeeBean);
		}
		return beanls;
	}
	
//	public Map<Integer, String> getAllActiveEmployeeMap(){
//		Map<Integer, String> map = new HashMap<Integer , String>();
//		List<EmployeeBean> ls =  getAllActiveEmployeeList();
//		for (EmployeeBean employeeBean : ls) {
//			map.put(employeeBean.getEmpId(), employeeBean.getName());
//		}
//		return map;
//	}


	public void saveAttendanceRecord(List<AttendanceBean> ls) {
		// TODO Auto-generated method stub
		List<AttendanceEntity> entityls= convertBeanLsToEntityLs(ls);
		attendanceDAO.saveAll(entityls);
	}


	private List<AttendanceEntity> convertBeanLsToEntityLs(List<AttendanceBean> ls) {
		// TODO Auto-generated method stub
		List<AttendanceEntity> entities = new ArrayList<AttendanceEntity>();
		for (AttendanceBean attendanceBean : ls) {
			AttendanceEntity entity = new AttendanceEntity();
			BeanUtils.copyProperties(attendanceBean, entity);
			System.out.println("id- > "+ entity.getEmpId().toString() + " " + entity.getAttendanceDate().toString());
			entity.setAttendanceId(entity.getEmpId().toString() +"_"+ new SimpleDateFormat("ddMMMyyyy").format(entity.getAttendanceDate()).toString());
			entities.add(entity);
		}
		return entities;
	}
	
}
