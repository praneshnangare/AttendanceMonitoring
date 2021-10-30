package com.example.demo.web.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.DAO.EmployeeDAOWrapper;
import com.example.demo.DAO.ReportDAOWrapper;
import com.example.demo.beans.AttendanceFormBean;
import com.example.demo.beans.DateAndName;
import com.example.demo.beans.EmployeeBean;
import com.example.demo.entities.ProjectEntity;
import com.example.demo.service.AttendanceService;
import com.example.demo.service.ReportService;

@Controller
@SessionAttributes({"empMap" , "employeeMap" , "ProjectMap"})
public class ReportController {

	@Autowired
	private ReportService reportService;

	@Autowired
	private AttendanceService atd;

	@GetMapping("/reportPage")
	public ModelAndView reportAndView() {
		ModelAndView modelAndView = new ModelAndView();
		
//		modelAndView.addObject("empmap", map);
		modelAndView.addObject("dateAndName", new DateAndName());
		modelAndView.setViewName("reportsPage");
		return modelAndView;
	}

	@GetMapping("/getAttendanceDetails")
	public ModelAndView resultAndView(@ModelAttribute("dateAndName") DateAndName dateAndName) {
		ModelAndView modelAndView = new ModelAndView();
		AttendanceFormBean attendanceFormBean = reportService.getAttendanceDetails(dateAndName.getEmpId(),
				dateAndName.getFromDate(), dateAndName.getToDate());
		modelAndView.addObject("attendanceForm", attendanceFormBean);
		modelAndView.setViewName("reportsPage");
		return modelAndView;
	}
	
	@ModelAttribute("empMap")
	public Map<Integer, String> getEmpMap(){
		Map<Integer, String> map = reportService.getAllActiveEmployeeMap();
		System.out.println("employee map in the report controller");
		return map;
	}
	
	@ModelAttribute("employeeMap")
	public Map<Integer, EmployeeBean> createEmployeeMap(){
		System.out.println("employee bean map in the report controller");
		List<EmployeeBean> ls = atd.getAllActiveEmployeeList();
		Map<Integer, EmployeeBean> map = new HashMap<Integer , EmployeeBean>(); 
		for (EmployeeBean employeeBean : ls) {
			map.put(employeeBean.getEmpId(), employeeBean);
		}
		return map;
	}
	
	@ModelAttribute("ProjectMap")
	public Map<Integer, String> createProjectMap(){
		System.out.println("Project map in the report controller");
		Map<Integer, String> map = new HashMap<Integer , String>();
		List<ProjectEntity> projList = atd.getAllProjects();
		projList.forEach(proj -> map.put(proj.getProjectId(), proj.getProjectName()));
		return map;
	}
	
}
