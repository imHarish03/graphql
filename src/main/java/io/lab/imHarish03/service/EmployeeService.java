package io.lab.imHarish03.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.lab.imHarish03.entity.Department;
import io.lab.imHarish03.entity.Employee;
import io.lab.imHarish03.entity.EmployeeInput;
import io.lab.imHarish03.repository.DepartmentRepository;
import io.lab.imHarish03.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;
	private final DepartmentRepository departmentRepository;

	public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
		this.employeeRepository = employeeRepository;
		this.departmentRepository = departmentRepository;
	}

	public List<Employee> getAllEmployees(Pageable pageable) {
		return employeeRepository.findAll(pageable).getContent();
	}

	public Optional<Employee> getEmployeeById(Long id) {
		return employeeRepository.findById(id);
	}

	public Employee createEmployee(String name, String email, Long departmentId) {
		Department dept = departmentRepository.findById(departmentId)
				.orElseThrow(() -> new RuntimeException("Department not found"));

		Employee employee = new Employee(null, name, email, dept);
		return employeeRepository.save(employee);
	}

	public List<Employee> getEmployeesByDepartmentId(Long departmentId) {
		return employeeRepository.findByDepartmentId(departmentId);
	}

	public Employee updateEmployee(EmployeeInput input) {
		Optional<Employee> optional = employeeRepository.findById(input.getId());
		if (optional.isEmpty())
			return null;

		Employee employee = optional.get();

		if (input.getName() != null)
			employee.setName(input.getName());
		if (input.getEmail() != null)
			employee.setEmail(input.getEmail());
		if (input.getDepartmentId() != null) {
			Department department = departmentRepository.findById(input.getDepartmentId()).orElse(null);
			employee.setDepartment(department);
		}

		return employeeRepository.save(employee);
	}

}
