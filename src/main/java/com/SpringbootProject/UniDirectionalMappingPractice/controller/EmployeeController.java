package com.SpringbootProject.UniDirectionalMappingPractice.controller;

import com.SpringbootProject.UniDirectionalMappingPractice.model.Employee;
import com.SpringbootProject.UniDirectionalMappingPractice.repository.EmployeeRepository;
import com.SpringbootProject.UniDirectionalMappingPractice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/org")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable long id){
        return employeeService.getEmployee(id);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/edit/{id}")
    public Employee editEmployee(@PathVariable long id, @RequestBody Employee employee){
        return employeeService.editEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable long id){
       employeeService.deleteEmployee(id);
        return id +": deleted Successfully";
    }

    @DeleteMapping("/deleteAll")
    public String deleteEmployee(){
        employeeService.deleteAllEmployee();
        return "All files are deleted Successfully";
    }



}
