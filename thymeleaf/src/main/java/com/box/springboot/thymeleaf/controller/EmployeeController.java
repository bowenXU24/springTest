package com.box.springboot.thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.box.springboot.thymeleaf.entity.Employee;
import com.box.springboot.thymeleaf.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService){
		this.employeeService = employeeService;
	}
	
	@GetMapping("/list")
	public String getEmployeeList(Model theModel){

		List<Employee> employeelist = employeeService.findAll();

		//add to MVC model
		//thymleaf will access "employees" attribute name
		theModel.addAttribute("employees", employeelist);
		
		//name of template
		//refer to src/main/resources/templates/list-employees.html
		return "employees/list-employees";
		
		
	}
	@GetMapping("/showFormForAdd")
	public String showAdd(Model theModel) {
		
		//create model attribute to bind data
		Employee theEmployee = new Employee();

		theModel.addAttribute("employee", theEmployee);

		return "employees/employee-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {
		
		//get employee form the service
		Employee theEmployee = employeeService.findById(theId);

		//set employee as model attribute 
		// to prepopulate the form
		theModel.addAttribute("employee", theEmployee);

		//save to form
		return "employees/employee-form";

	}

	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){

		//save employee
		employeeService.save(theEmployee);

		//use a redirect to prevent duplicate submission

		return "redirect:/employees/list";
		
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {
		
		employeeService.deleteById(theId);

		return "redirect:/employees/list";
	}

}
