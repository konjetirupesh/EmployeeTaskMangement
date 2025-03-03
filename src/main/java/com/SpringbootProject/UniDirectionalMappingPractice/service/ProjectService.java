package com.SpringbootProject.UniDirectionalMappingPractice.service;

import com.SpringbootProject.UniDirectionalMappingPractice.model.Project;
import com.SpringbootProject.UniDirectionalMappingPractice.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    //create project
    public Project createProject(Project project){
        return projectRepository.save(project);
    }

    //edit project
    public Project editProject(long id, Project project){
        Project isProject = projectRepository.findById(id).orElse(null);
        if(isProject!=null){
            isProject.setProject(project.getProject());
            isProject.setClientName(project.getClientName());
            isProject.setClientCountry(project.getClientCountry());
            return projectRepository.save(isProject);
        }
        else {
            return null;
        }
    }

    //get all projects
    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }

    //get project by id
    public Optional<Project> getProjectById(long id){
        return projectRepository.findById(id);
    }

    //delete employee by id
    public void deleteProjectById(long id){
        projectRepository.deleteById(id);
    }

    //delete all employees
    public void deleteAllProjects(){
        projectRepository.deleteAll();
    }
}
