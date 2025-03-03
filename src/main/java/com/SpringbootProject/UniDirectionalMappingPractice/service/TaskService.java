package com.SpringbootProject.UniDirectionalMappingPractice.service;


import com.SpringbootProject.UniDirectionalMappingPractice.model.Task;
import com.SpringbootProject.UniDirectionalMappingPractice.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    // Get all tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Get a task by ID
    public Optional<Task> getTaskById(long id) {
        return taskRepository.findById(id);
    }

    // Create a new task
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // Edit an existing task
    public Task editTask(long id, Task task) {
        Task existingTask = taskRepository.findById(id).orElse(null);
        if (existingTask != null) {
            existingTask.setTaskname(task.getTaskname());
            existingTask.setPriority(task.getPriority());
            return taskRepository.save(existingTask);
        }
        return null;
    }

    // Delete a task by ID
    public boolean deleteTaskById(long id) {
        taskRepository.deleteById(id);
        return true;
    }

    // Delete all tasks
    public boolean deleteAllTasks() {
        taskRepository.deleteAll();
        return true;
    }
}
