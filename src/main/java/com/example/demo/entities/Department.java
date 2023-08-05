package com.example.demo.entities;

import java.io.Serializable;

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
@Table(name = "DEPARTMENTS")
public class Department implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Basic
	@Column(name = "DEPARTMENT_ID")
	private Long departmentId;
	@Column(name = "DEPARTMENT_NAME")
	private String departmentName;
	@Column(name = " MANAGER_ID")
	private  Long managerId;
//	@ManyToOne()
//	@JoinColumn(name = "MANAGER_ID")
//	private Employee manager;
	//@Column(name = "")
	//private Long locationId;
	@ManyToOne()
	@JoinColumn(name = "LOCATION_ID")
	private Location location;

	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
//	public Employee getManager() {
//		return manager;
//	}
//	public void setManager(Employee manager) {
//		this.manager = manager;
//	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Department() {
		super();
	}
	public Long getManagerId() {
		return managerId;
	}
	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", managerId="
				+ managerId + ", location=" + location + "]";
	}

}
