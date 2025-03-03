package com.SpringbootProject.UniDirectionalMappingPractice.service;

import com.SpringbootProject.UniDirectionalMappingPractice.model.Employee;
import com.SpringbootProject.UniDirectionalMappingPractice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    //get all employees
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    //get employee by id
    public Optional<Employee> getEmployee(long id){
        return employeeRepository.findById(id);
    }

    //create employee
    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    //edit employee
    public Employee editEmployee(long id, Employee employee){
        Employee isEmployee = employeeRepository.findById(id).orElse(null);
            isEmployee.setName(employee.getName());
            isEmployee.setEmail(employee.getEmail());
            isEmployee.setPassword(employee.getPassword());
            return employeeRepository.save(isEmployee);
    }

    //delete employee
    public boolean deleteEmployee(long id){
        employeeRepository.deleteById(id);
        return true;
    }

    //delete all employees
    public boolean deleteAllEmployee(){
        employeeRepository.deleteAll();
        return true;
    }

}
