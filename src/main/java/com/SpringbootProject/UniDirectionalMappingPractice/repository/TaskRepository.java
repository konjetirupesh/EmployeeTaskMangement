package com.SpringbootProject.UniDirectionalMappingPractice.repository;
import com.SpringbootProject.UniDirectionalMappingPractice.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
