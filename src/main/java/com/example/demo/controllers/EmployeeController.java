package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Chart;
import com.example.demo.entities.Country;
import com.example.demo.entities.DepartmentEmployee;
import com.example.demo.entities.Employee;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.services.EmployeeService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("employees")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}
	@GetMapping("/list")
	public Page<Employee> findAll(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int items){
		Page<Employee> findAll = employeeRepository.findAll(PageRequest.of(page, items));
		return findAll;
	}
	@GetMapping("{id}")
	public Employee findById(@PathVariable ("id") Long employeeId ) throws ResourceNotFoundException{
		return employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("No Employee Found With id"+employeeId));
	}
	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee) throws ResourceNotFoundException{
		System.out.println(employee.toString());
		Optional<Employee> findById = employeeRepository.findById(employee.getEmployeeId());
		if(findById.isPresent()) {
			throw new ResourceNotFoundException("Employee id is Found kindly change Employee id");
		}else {
			return employeeRepository.save(employee);
		}

	}
	@PutMapping("/edit")
	public Employee editEmployee(@RequestBody Employee employeeUpdate) throws Exception{
		
		 Employee oldEmployee=employeeRepository.findById(employeeUpdate.getEmployeeId()).orElseThrow(()-> new Exception("No Employee Found With id"+employeeUpdate.getEmployeeId()));
		 BeanUtils.copyProperties( employeeUpdate,oldEmployee, employeeUpdate.getEmployeeId().toString());
		 
		 return employeeRepository.save(oldEmployee);
	}
	@PutMapping("/chart")
	public void findCountEmployeesInDepartments(){
	 employeeService.findCountEmployeesInDepartments();
	}
	@GetMapping("/countEmployeeByDepartment")
	public List<DepartmentEmployee> countEmployeeByDepartment(){
		List<DepartmentEmployee> countEmployeeByDepartmentList = employeeService.countEmployeeByDepartment();
		return countEmployeeByDepartmentList;
	}
}
