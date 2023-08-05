package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Chart;
import com.example.demo.entities.Department;
import com.example.demo.entities.DepartmentEmployee;
import com.example.demo.entities.Employee;
import com.example.demo.repositories.DepartmentRepository;
import com.example.demo.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private DepartmentRepository departmentRepository;

	public void findCountEmployeesInDepartments() {
		List<Chart> chartList = new ArrayList<>();
		List<Employee> allEmployees = findAllEmployees();
		// allEmployees.stream().filter(e->Objects.nonNull(e.getDepartment())).collect(Collectors.toList());
		System.out.println(allEmployees.size());
		Map<String, Long> departmentCounts = allEmployees.stream()
				.collect(Collectors.groupingBy(x -> x.getDepartment().getDepartmentName(), Collectors.counting()));

		departmentCounts.forEach((department, count) -> {
			System.out.println(department + ": " + count);
			// chartList.add( new
			// Chart(departmentRepository.findById(department).get().getDepartmentName(),count));
		});
		// return chartList;
	}

	public List<Employee> findAllEmployees() {
		return employeeRepository.findAll();
	}

	public List<DepartmentEmployee> countEmployeeByDepartment() {
		List<DepartmentEmployee> departmentEmployees = new ArrayList<>();
		DepartmentEmployee d;
		try {

			String sql = "select count(*) counting,d.DEPARTMENT_NAME\r\n" + "from employees e,departments d\r\n"
					+ "where e.DEPARTMENT_ID=d.DEPARTMENT_ID\r\n" + "group by d.DEPARTMENT_NAME\r\n"
					+ "order by counting desc";
			Query query = entityManager.createNativeQuery(sql);

			List<Object[]> rows = query.getResultList();
			if (!rows.isEmpty()) {
				System.out.println("Have Date");
				for (Object[] row : rows) {
					d = new DepartmentEmployee(row[1].toString(), Long.valueOf(row[0].toString()));
					departmentEmployees.add(d);
				}
			}

		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		} finally {
		}
		return departmentEmployees;
	}
}
