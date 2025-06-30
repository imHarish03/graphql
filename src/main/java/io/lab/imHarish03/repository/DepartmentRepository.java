package io.lab.imHarish03.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.lab.imHarish03.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
