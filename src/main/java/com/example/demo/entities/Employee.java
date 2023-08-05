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
@Table(name = "employees")
public class Employee implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Basic
	@Column(name = "EMPLOYEE_ID")
	private Long employeeId;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	@Column(name = "HIRE_DATE")
	private LocalDate hireDate;
//	@Column(name = "JOB_ID")
//	private String jopId;
	@Column(name = "SALARY")
	private String salary;
	@Column(name = "COMMISSION_PCT")
	private double commissionPct;
	@Column(name = "MANAGER_ID")
	private int managerId;
//	@Column(name = "DEPARTMENT_ID")
//	private Long departmentId;
	@ManyToOne()
	@JoinColumn(name = "DEPARTMENT_ID")
	private Department department;
	@ManyToOne()
	@JoinColumn(name = "JOB_ID")
	private Job job;
	
	public Employee() {
		super();
	}

	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public LocalDate getHireDate() {
		return hireDate;
	}
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
//	public String getJopId() {
//		return jopId;
//	}
//	public void setJopId(String jopId) {
//		this.jopId = jopId;
//	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public double getCommissionPct() {
		return commissionPct;
	}
	public void setCommissionPct(double commissionPct) {
		this.commissionPct = commissionPct;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
//	public Long getDepartmentId() {
//		return departmentId;
//	}
//	public void setDepartmentId(Long departmentId) {
//		this.departmentId = departmentId;
//	}
//	

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

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate + ", salary=" + salary
				+ ", commissionPct=" + commissionPct + ", managerId=" + managerId + ", department=" + department
				+ ", job=" + job + "]";
	}
	
	
	
	

}
