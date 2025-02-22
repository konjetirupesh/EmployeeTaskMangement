package com.SpringBootMapping.OneToOne.service;

import com.SpringBootMapping.OneToOne.model.Task;
import com.SpringBootMapping.OneToOne.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    //create employees
    public Task createTask(Task task){
        return  taskRepository.save(task);
    }

    //get all employees
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    //get employee by id
    public Optional<Task> getTaskById(long id){
        return taskRepository.findById(id);
    }
}
