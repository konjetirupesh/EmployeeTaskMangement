package com.SpringbootProject.UniDirectionalMappingPractice.controller;

import com.SpringbootProject.UniDirectionalMappingPractice.model.Employee;
import com.SpringbootProject.UniDirectionalMappingPractice.model.Task;
import com.SpringbootProject.UniDirectionalMappingPractice.service.EmployeeService;
import com.SpringbootProject.UniDirectionalMappingPractice.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private EmployeeService employeeService;

    // Get all tasks
    @GetMapping
    public List<Task> getAll() {
        return taskService.getAllTasks();
    }

    // Get task by ID
    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable long id) {
        return taskService.getTaskById(id);
    }


    @PostMapping("/add/{employeeId}")
    public Task addTask(@PathVariable long employeeId, @RequestBody Task task) {
        Employee employee = employeeService.getEmployee(employeeId).orElse(null);
        if (employee != null) {
            task.setEmployee(employee);  // Associate task with the employee
            Task savedTask = taskService.createTask(task); // Save the task

            // Optionally, add the task to the employee's task list (if required)
            employee.getTask().add(savedTask);  // Add saved task to the employee's task list
            employeeService.createEmployee(employee);  // Save the updated employee

            return savedTask;  // Return the saved task
        }
        return null;  // Return null or appropriate response if the employee does not exist
    }


    // Edit a task
    @PutMapping("/edit/{id}")
    public Task editTask(@PathVariable long id, @RequestBody Task task) {
        return taskService.editTask(id, task);
    }

    // Delete all tasks
    @DeleteMapping("/deleteAll")
    public String deleteAllTasks() {
        taskService.deleteAllTasks();
        return "All tasks deleted";
    }

    // Delete a task by ID
    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable long id) {
        taskService.deleteTaskById(id);
        return "Task with ID " + id + " was deleted";
    }
}
