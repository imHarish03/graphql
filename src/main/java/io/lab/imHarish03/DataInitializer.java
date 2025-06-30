package io.lab.imHarish03;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.lab.imHarish03.entity.Department;
import io.lab.imHarish03.entity.Employee;
import io.lab.imHarish03.repository.DepartmentRepository;
import io.lab.imHarish03.repository.EmployeeRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public DataInitializer(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
    	
        if (departmentRepository.count() == 0 && employeeRepository.count() == 0) {
            // Create departments
            Department engineering = Department.builder().name("Engineering").build();
            Department hr = Department.builder().name("Human Resources").build();
            Department marketing = Department.builder().name("Marketing").build();
            Department finance = Department.builder().name("Finance").build();
            Department it = Department.builder().name("IT Support").build();

            departmentRepository.saveAll(List.of(engineering, hr, marketing, finance, it));

            // Create employees
            employeeRepository.save(new Employee(null, "Alice", "alice@example.com", engineering));
            employeeRepository.save(new Employee(null, "Bob", "bob@example.com", hr));
            employeeRepository.save(new Employee(null, "Charlie", "charlie@example.com", marketing));
            employeeRepository.save(new Employee(null, "David", "david@example.com", finance));
            employeeRepository.save(new Employee(null, "Eve", "eve@example.com", it));
            employeeRepository.save(new Employee(null, "Frank", "frank@example.com", engineering));
            employeeRepository.save(new Employee(null, "Grace", "grace@example.com", hr));
            employeeRepository.save(new Employee(null, "Heidi", "heidi@example.com", marketing));
            employeeRepository.save(new Employee(null, "Ivan", "ivan@example.com", finance));
            employeeRepository.save(new Employee(null, "Judy", "judy@example.com", it));

            System.out.println("✔️ Sample data loaded.");
        } else {
            System.out.println("ℹ️ Sample data already present. Skipping insert.");
        }
    }

}
