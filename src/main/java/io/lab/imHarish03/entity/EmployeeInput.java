package io.lab.imHarish03.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class EmployeeInput extends Employee {
	private Long departmentId;

}
