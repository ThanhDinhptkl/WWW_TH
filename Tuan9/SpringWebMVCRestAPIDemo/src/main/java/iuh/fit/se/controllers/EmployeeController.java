package iuh.fit.se.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import iuh.fit.se.entities.Employee;
import iuh.fit.se.services.EmployeeService;
import iuh.fit.se.utils.ApiResponse;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping
	public ModelAndView getList(ModelAndView model) {
		ApiResponse response = employeeService.findAll();
		
		List<Employee> employees = null;
		
		if (response != null && response.getErrors() == null) {
			employees = (List<Employee>) response.getData();
		}
		System.out.println(employees);
		model.setViewName("employee-list");
		model.addObject("employees", employees);
		return model;
	}

	@GetMapping("/showForm")
	public ModelAndView showForm(ModelAndView model) {
		Employee employee = new Employee();
		model.setViewName("employee-form");
		model.addObject("employee", employee);
		return model;
	}

	@PostMapping("/save")
	public ModelAndView save(@ModelAttribute Employee employee) {
		
		ApiResponse response;
		if (employee.getId() == 0) {
			response = employeeService.save(employee);
		}
		else {
			response = employeeService.update(employee.getId(), employee);
		}
		
		if (response != null && response.getErrors() != null) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("employee-form");
			mv.addObject("errors", response.getErrors());
			return mv;
		}
		else {
			return new ModelAndView("redirect:/employees");
		}
		
	}
	
	@GetMapping("/update")
	public ModelAndView update(@RequestParam("employeeId") int id, ModelAndView model) {
		
		ApiResponse response = employeeService.findById(id);
		Employee employee = new Employee();
		
		if (response != null && response.getErrors() == null) {
			employee = (Employee) response.getData();
		}
		else {
			model.addObject("error", "Can not find Employee with id: " + id);
		}
		
		model.addObject("employee", employee);
		model.setViewName("employee-form");
		
		return model;
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int id) {
		employeeService.delete(id);
		return "redirect:/employees";
	}
	
	@GetMapping("/search")
	public ModelAndView search(@RequestParam String keyword, ModelAndView model) {
		ApiResponse response = employeeService.search(keyword);
		
		List<Employee> employees = null;
		
		if (response != null && response.getErrors() == null) {
			employees = (List<Employee>) response.getData();
		}
		
		model.setViewName("employee-list");
		model.addObject("employees", employees);
	 
	    return model;    
	}
}
