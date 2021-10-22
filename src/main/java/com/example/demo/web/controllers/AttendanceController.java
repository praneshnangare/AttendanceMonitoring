package com.example.demo.web.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.beans.AttendanceBean;
import com.example.demo.beans.AttendanceFormBean;
import com.example.demo.beans.EmployeeBean;
import com.example.demo.entities.ProjectEntity;
import com.example.demo.service.AttendanceService;

@Controller
public class AttendanceController {

	@Autowired
	private AttendanceService atd;

	@GetMapping("markattendance")
	public ModelAndView markAttendance() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("attendanceMarking");
		AttendanceFormBean attendanceFormBean = new AttendanceFormBean();
		attendanceFormBean.setAttendanceList(getAttendanceBeanList());
		modelAndView.addObject("attendanceForm", attendanceFormBean);
		return modelAndView;
	}
	@PostMapping("saveAttendanceRecords")
	public ModelAndView submitAttendance(@ModelAttribute("attendanceForm") AttendanceFormBean attendanceFormBean) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("success");
		attendanceFormBean.getAttendanceList().forEach(l -> System.out.println("extra  "+ l.getExtraHours() + "   " + l.getRemarks()));
		atd.saveAttendanceRecord(attendanceFormBean.getAttendanceList());
		return modelAndView;
		
	}
	
	//@ModelAttribute("attendanceList")
	public List<AttendanceBean> getAttendanceBeanList(){
		List<EmployeeBean> ls = atd.getAllActiveEmployeeList();
		System.out.println(ls.size());
		List<AttendanceBean> attendanceLs = new ArrayList<AttendanceBean>();
		for (EmployeeBean employeeBean : ls) {
			AttendanceBean attendanceBean = new AttendanceBean();
			attendanceBean.setEmpId(employeeBean.getEmpId());
			attendanceLs.add(attendanceBean);
		}
		return attendanceLs;
	}
	
	@ModelAttribute("employeeMap")
	public Map<Integer, EmployeeBean> createEmployeeMap(){
		List<EmployeeBean> ls = atd.getAllActiveEmployeeList();
		Map<Integer, EmployeeBean> map = new HashMap<Integer , EmployeeBean>(); 
		for (EmployeeBean employeeBean : ls) {
			map.put(employeeBean.getEmpId(), employeeBean);
		}
		return map;
	}
	
	@ModelAttribute("ProjectMap")
	public Map<Integer, String> createProjectMap(){
		Map<Integer, String> map = new HashMap<Integer , String>();
		List<ProjectEntity> projList = atd.getAllProjects();
		projList.forEach(proj -> map.put(proj.getProjectId(), proj.getProjectName()));
		return map;
	}
	
}
