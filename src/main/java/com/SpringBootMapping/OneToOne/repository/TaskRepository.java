package com.SpringBootMapping.OneToOne.repository;

import com.SpringBootMapping.OneToOne.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
