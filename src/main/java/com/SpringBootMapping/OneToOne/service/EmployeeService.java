package com.SpringBootMapping.OneToOne.service;

import com.SpringBootMapping.OneToOne.model.Employee;
import com.SpringBootMapping.OneToOne.model.Task;
import com.SpringBootMapping.OneToOne.repository.EmployeeRepository;
import com.SpringBootMapping.OneToOne.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TaskRepository taskRepository;

    // Create employee with task
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    //get all employees
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    //get employee by id
    public Optional<Employee> getEmployeeById(long id){
        return employeeRepository.findById(id);
    }
}
