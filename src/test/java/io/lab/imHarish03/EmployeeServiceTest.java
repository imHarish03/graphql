package io.lab.imHarish03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import io.lab.imHarish03.entity.Department;
import io.lab.imHarish03.entity.Employee;
import io.lab.imHarish03.repository.DepartmentRepository;
import io.lab.imHarish03.repository.EmployeeRepository;
import io.lab.imHarish03.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

	@Mock
	private EmployeeRepository employeeRepository;

	@Mock
	private DepartmentRepository departmentRepository;

	@InjectMocks
	private EmployeeService employeeService;

	@Test
	void createEmployeeTest() {
		// Arrange
		Long deptId = 1L;
		String name = "Alice";
		String email = "alice@example.com";

		Department department = new Department();
		department.setId(deptId);
		department.setName("IT");

		Employee savedEmployee = new Employee(100L, name, email, department);

		when(departmentRepository.findById(deptId)).thenReturn(Optional.of(department));
		when(employeeRepository.save(any(Employee.class))).thenReturn(savedEmployee);

		// Act
		Employee result = employeeService.createEmployee(name, email, deptId);

		// Assert
		assertNotNull(result);
		assertEquals("Alice", result.getName());
		assertEquals("alice@example.com", result.getEmail());
		assertEquals("IT", result.getDepartment().getName());

		verify(departmentRepository).findById(deptId);
		verify(employeeRepository).save(any(Employee.class));
	}

}
