package com.SpringbootProject.UniDirectionalMappingPractice.controller;

import com.SpringbootProject.UniDirectionalMappingPractice.model.Employee;
import com.SpringbootProject.UniDirectionalMappingPractice.model.Profile;
import com.SpringbootProject.UniDirectionalMappingPractice.service.EmployeeService;
import com.SpringbootProject.UniDirectionalMappingPractice.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profiles")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Profile> getAll(){
        return profileService.getAllProfile();
    }

    @GetMapping("/{id}")
    public Optional<Profile> getById(@PathVariable long id){
        return profileService.getProfileById(id);
    }

    @PostMapping
    public Profile addProfile(@RequestBody Profile profile){
        return profileService.createProfile(profile);
    }

    @PostMapping("/{employeeid}")
    public Profile addProfile(@PathVariable long employeeid, @RequestBody Profile profile){
        Employee isEmployee =employeeService.getEmployee(employeeid).orElse(null);
        if(isEmployee!=null){
            profile.setEmployee(isEmployee);

            Profile savedProfile = profileService.createProfile(profile);

            isEmployee.setProfile(savedProfile);

            employeeService.createEmployee(isEmployee);
            return savedProfile;
        }
        return null;
    }

    @PutMapping("/{id}")
    public Profile editProfile(@PathVariable long id, @RequestBody Profile profile){
        return profileService.editProfile(id, profile);
    }

    @DeleteMapping("/{id}")
    public String deleteProfile(@PathVariable long id){
        profileService.deleteProfile(id);
        return "id : "+id+" deleted successfully";
    }

    @DeleteMapping("/deleteAll")
    public String deleteAllProfile(){
        profileService.deleteAllProfiles();
        return "All files are deleted";
    }

}
