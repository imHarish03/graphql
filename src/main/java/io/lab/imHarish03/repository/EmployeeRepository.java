package io.lab.imHarish03.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.lab.imHarish03.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByDepartmentId(Long departmentId);

}

