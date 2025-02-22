package com.SpringBootMapping.OneToOne.repository;

import com.SpringBootMapping.OneToOne.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
