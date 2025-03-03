package com.SpringbootProject.UniDirectionalMappingPractice.repository;

import com.SpringbootProject.UniDirectionalMappingPractice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
