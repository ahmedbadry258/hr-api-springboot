package com.example.demo.entities;

public class Chart {

	private String departmentName;
	private Long numberOfEmployees;
	public Chart(String departmentName, Long numberOfEmployees) {
		super();
		this.departmentName = departmentName;
		this.numberOfEmployees = numberOfEmployees;
	}
	public Chart() {
		super();
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Long getNumberOfEmployees() {
		return numberOfEmployees;
	}
	public void setNumberOfEmployees(Long numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}
	
	
	
}
