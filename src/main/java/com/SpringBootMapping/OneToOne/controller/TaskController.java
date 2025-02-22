package com.SpringBootMapping.OneToOne.controller;

import com.SpringBootMapping.OneToOne.model.Task;
import com.SpringBootMapping.OneToOne.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Add Employee
    @PostMapping(consumes = "application/json")
    public Task addTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }


    // Get All Employees
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // Get Employee by ID
    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable int id) {
        return taskService.getTaskById(id);
    }
}
