package com.SpringbootProject.UniDirectionalMappingPractice.controller;

import com.SpringbootProject.UniDirectionalMappingPractice.model.Department;
import com.SpringbootProject.UniDirectionalMappingPractice.model.Employee;
import com.SpringbootProject.UniDirectionalMappingPractice.service.DepartmentService;
import com.SpringbootProject.UniDirectionalMappingPractice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    // Get all departments
    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    // Get department by ID
    @GetMapping("/{id}")
    public Optional<Department> getDepartmentById(@PathVariable long id) {
        return departmentService.getDepartmentById(id);
    }

    @PostMapping("/create/{employeeId}")
    public Department createDepartmentWithEmployee(@PathVariable long employeeId, @RequestBody Department department) {
        // Retrieve the employee by ID
        Employee employee = employeeService.getEmployee(employeeId).orElse(null);

        if (employee != null) {
            // If you are using List<Employee>, add the employee to the list of employees in the department
            if (department.getEmployee() == null) {
                department.setEmployee(new ArrayList<>());
            }
            department.getEmployee().add(employee); // Add employee to the list

            // Save the department (this will also update the employee's department)
            Department savedDepartment = departmentService.createDepartment(department);

            // Optionally, update the employee's department if needed
            employee.setDepartment(savedDepartment); // Save the updated employee's department
            employeeService.createEmployee(employee);

            return savedDepartment;  // Return the saved department
        }

        return null;  // If employee does not exist, return null or an error response
    }


    // Edit a department
    @PutMapping("/{id}")
    public Department editDepartment(@PathVariable long id, @RequestBody Department department) {
        return departmentService.editDepartment(id, department);
    }

    // Delete a department by ID
    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable long id) {
        departmentService.deleteDepartment(id);
        return "Department with ID " + id + " was deleted successfully.";
    }

    // Delete all departments
    @DeleteMapping("/deleteAll")
    public String deleteAllDepartments() {
        departmentService.deleteAllDepartments();
        return "All departments have been deleted successfully.";
    }
}
