package com.SpringbootProject.UniDirectionalMappingPractice.repository;

import com.SpringbootProject.UniDirectionalMappingPractice.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
