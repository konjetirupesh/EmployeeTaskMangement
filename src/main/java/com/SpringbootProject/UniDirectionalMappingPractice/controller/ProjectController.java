package com.SpringbootProject.UniDirectionalMappingPractice.controller;

import com.SpringbootProject.UniDirectionalMappingPractice.model.Employee;
import com.SpringbootProject.UniDirectionalMappingPractice.model.Project;
import com.SpringbootProject.UniDirectionalMappingPractice.service.EmployeeService;
import com.SpringbootProject.UniDirectionalMappingPractice.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private EmployeeService employeeService;

    //get all projects
    @GetMapping
    public List<Project> getAll(){
        return projectService.getAllProjects();
    }

    //get project by id
    @GetMapping("/{id}")
    public Optional<Project> getProjectById(@PathVariable long id){
        return projectService.getProjectById(id);
    }


    //create Project with Bidirectional
    @PostMapping("/add/{employeeId}")
    public Project addProject(@PathVariable long employeeId, @RequestBody Project project) {
        Employee employee = employeeService.getEmployee(employeeId).orElse(null);
        if (employee != null) {
            // Ensure the employee list in the project is initialized
            if (project.getEmployee() == null) {
                project.setEmployee(new ArrayList<>());
            }

            // Add the employee to the project
            project.getEmployee().add(employee);

            // Ensure the project list in the employee is initialized
            if (employee.getProject() == null) {
                employee.setProject(new ArrayList<>());
            }

            // Add the project to the employee
            employee.getProject().add(project);

            // Save the project (this will cascade to the employee due to CascadeType.ALL)
            Project  savedProject = projectService.createProject(project);
            return savedProject;
        }
        return null; // Handle error if employee doesn't exist
    }


    //edit project
    @PutMapping("/{id}")
    public Project editProject(@PathVariable long id, @RequestBody Project project){
        return projectService.editProject(id, project);
    }

    //delete project
    @DeleteMapping("/{id}")
    public String deleteProject(@PathVariable long id){
        projectService.deleteProjectById(id);
        return id+" : deleted Successfully";
    }

    //delete all projects
    @DeleteMapping("/deleteAll")
    public String deleteAllProjects(){
        projectService.deleteAllProjects();
        return "All Projects are deleted";
    }

}
