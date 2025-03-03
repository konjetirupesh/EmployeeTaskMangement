package com.SpringbootProject.UniDirectionalMappingPractice.service;

import com.SpringbootProject.UniDirectionalMappingPractice.model.Department;
import com.SpringbootProject.UniDirectionalMappingPractice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.zip.DeflaterOutputStream;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    //get department
    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

    //get department by id
    public Optional<Department> getDepartmentById(long id){
        return departmentRepository.findById(id);
    }

    //create department
    public Department createDepartment(Department department){
        return departmentRepository.save(department);
    }

    //edit department
    public Department editDepartment(long id, Department department){
        Department isDepartment = departmentRepository.findById(id).orElse(null);
        if(isDepartment!=null){
            isDepartment.setName(department.getName());
            isDepartment.setLocation((department.getLocation()));
            return departmentRepository.save(isDepartment);
        }
        else{
            return null;
        }
    }

    //delete department
    public void deleteDepartment(long id){
        departmentRepository.deleteById(id);
    }

    //delete All departments
    public void deleteAllDepartments(){
        departmentRepository.deleteAll();
    }
}
