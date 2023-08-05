package com.example.demo.entities;

public class DepartmentEmployee {

	private String departmentName;
	private Long noOfEmployee;
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Long getNoOfEmployee() {
		return noOfEmployee;
	}
	public void setNoOfEmployee(Long noOfEmployee) {
		this.noOfEmployee = noOfEmployee;
	}
	public DepartmentEmployee(String departmentName, Long noOfEmployee) {
	
		this.departmentName = departmentName;
		this.noOfEmployee = noOfEmployee;
	}
	public DepartmentEmployee() {
	
	}
	
	
}
