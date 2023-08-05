package com.example.demo.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "JOB_HISTORY")
public class JobHistory implements Serializable{
	
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Basic
	@Column(name = "EMPLOYEE_ID")
	private Long employeeId;
	//@Id
	//@ManyToOne()
	//@JoinColumn(name = "EMPLOYEE_ID")
	//private Employee employee;
	
	@Column(name = "START_DATE")
	private LocalDate startDate;
	@Column(name = "END_DATE")
	private LocalDate endDate;
//	@Column(name = "JOB_ID")
//	private String jobId;
//	@Column(name = "DEPARTMENT_ID")
//	private Long departmentId;
	@ManyToOne()
	@JoinColumn(name = "DEPARTMENT_ID")
	private Department department ;

	@ManyToOne()
	@JoinColumn(name = "JOB_ID")
	private Job job;
	
	public JobHistory() {
		super();
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
//	public String getJobId() {
//		return jobId;
//	}
//	public void setJobId(String jobId) {
//		this.jobId = jobId;
//	}
//	public Long getDepartmentId() {
//		return departmentId;
//	}
//	public void setDepartmentId(Long departmentId) {
//		this.departmentId = departmentId;
//	}
//	public Employee getEmployee() {
//		return employee;
//	}
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}

	 
}
