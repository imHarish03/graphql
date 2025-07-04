package io.lab.imHarish03.controller;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import io.lab.imHarish03.entity.Employee;
import io.lab.imHarish03.entity.EmployeeInput;
import io.lab.imHarish03.service.EmployeeService;

@Controller
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@QueryMapping
	public List<Employee> allEmployees(@Argument int page, @Argument int size) {
		Pageable pageable = PageRequest.of(page, size);
		return employeeService.getAllEmployees(pageable);
	}

	@QueryMapping
	public Employee employeeById(@Argument Long id) {
		return employeeService.getEmployeeById(id).orElse(null);
	}

	@MutationMapping
	public Employee createEmployee(@Argument String name, @Argument String email, @Argument Long departmentId) {
		return employeeService.createEmployee(name, email, departmentId);
	}

	@QueryMapping
	public List<Employee> employeesByDepartmentId(@Argument Long departmentId) {
		return employeeService.getEmployeesByDepartmentId(departmentId);
	}


	@MutationMapping
	public Employee updateEmployee(@Argument("input") EmployeeInput input) {
		return employeeService.updateEmployee(input);
	}

}
