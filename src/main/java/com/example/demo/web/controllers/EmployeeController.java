package com.example.demo.web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.beans.DepartmentBean;
import com.example.demo.beans.EmployeeBean;
import com.example.demo.entities.ProjectEntity;
import com.example.demo.service.AttendanceService;

@Controller
public class EmployeeController {
	
	@Autowired
	private AttendanceService atd;
	
	@GetMapping("loadEmployeeRegisterPage.html")
	public ModelAndView loadEmployeeRegisterPageMethod() {
		System.out.println("in the register method");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("register.jsp");
		modelAndView.addObject("empBean",new EmployeeBean());
		return modelAndView;
	}
	
	@PostMapping("registerEmployee")
	public ModelAndView registerEmployee(@ModelAttribute("empBean") EmployeeBean employeeBean , BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		if(bindingResult.hasErrors()) {
			bindingResult.getAllErrors().forEach(ls -> System.out.println(ls));
			modelAndView.setViewName("register.jsp");
		}else {
			Integer id = atd.addEmployee(employeeBean);
			modelAndView.setViewName("register.jsp");
			modelAndView.addObject("msg", "Hello User, Employee has been successfully added with name " + employeeBean.getName() + "  " + id + "  .");
		}
		return modelAndView;
	}
	@PostMapping("getDepartmentList.html")
	public ModelAndView getDepartmentList(@ModelAttribute("empBean") EmployeeBean employeeBean) {
		ModelAndView modelAndView = new ModelAndView();
		List<DepartmentBean> ls =  retrieveDepartmentList(employeeBean.getAllocProject());
		System.out.println("ls " + ls.size());
		modelAndView.addObject("departmentList", ls);
		modelAndView.addObject("empBean" , employeeBean);
		modelAndView.setViewName("register.jsp");
		return modelAndView;
	}
	@ModelAttribute("GenderMap")
	public Map<String, String> createGenderMap(){
		Map<String, String> map = new HashMap<String,String>();
		map.put("Male" , "Male");
		map.put("Female" , "Female");
		return map;
	}
	@ModelAttribute("ProjectMap")
	public Map<Integer, String> createProjectMap(){
		Map<Integer, String> map = new HashMap<Integer , String>();
		List<ProjectEntity> projList = atd.getAllProjects();
		projList.forEach(proj -> map.put(proj.getProjectId(), proj.getProjectName()));
		return map;
	}
	
	public List<DepartmentBean> retrieveDepartmentList(Integer projectId){
		return atd.getDepartmentByProjectId(projectId);
	}
	
}





