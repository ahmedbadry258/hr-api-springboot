package com.example.demo.controllers;

import java.util.List;

import javax.persistence.OrderBy;
import javax.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Department;

import com.example.demo.repositories.DepartmentRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/departments")
public class DepartmentController {
	@Autowired
	private DepartmentRepository departmentRepository;

	
	@GetMapping
	public Page<Department> findAll(){
		Page<Department> findAll = departmentRepository.findAll(PageRequest.of(0, 5));
		return findAll;
	}

	@GetMapping("/{id}")
	public Department findDepartmentById(@PathVariable ("id") Long id){
		System.out.println(id);
		return departmentRepository.findById(id).get();
	}
	@PostMapping
	public Department saveDepartment(@RequestBody Department department){
		departmentRepository.save(department);
		return department;
	}
	@PutMapping("/{id}")
	public Department editDepartment(@PathVariable ("id") Long id,@RequestBody Department department){
		Department d=departmentRepository.findById(id).get();
		d.setDepartmentName(department.getDepartmentName());
		d.setLocation(department.getLocation());
		d.setManagerId(department.getManagerId());
		departmentRepository.save(d);
		return d;
	}
	@DeleteMapping("/{id}")
	public String deleteDepartment(@PathVariable ("id") Long id){
		departmentRepository.deleteById(id);
		return "Department has been deleted";
	}

}
