package com.SpringbootProject.UniDirectionalMappingPractice.service;

import com.SpringbootProject.UniDirectionalMappingPractice.model.Profile;
import com.SpringbootProject.UniDirectionalMappingPractice.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    //create profile
    @PostMapping
    public Profile createProfile(Profile profile){
        return profileRepository.save(profile);
    }



    //edit profile
    public Profile editProfile(long id, Profile profile){
        Profile isProfile = profileRepository.findById(id).orElse(null);
        isProfile.setAddress(profile.getAddress());
        isProfile.setEducation(profile.getEducation());
        return profileRepository.save(isProfile);
    }

    //get all profiles
    public List<Profile> getAllProfile(){
        return profileRepository.findAll();
    }

    //get profile by id
    public Optional<Profile> getProfileById(long id){
        return profileRepository.findById(id);
    }

    //delete all profile
    public boolean deleteAllProfiles(){
        profileRepository.deleteAll();
        return true;
    }

    //delete profile by id
    public boolean deleteProfile(long id){
        profileRepository.deleteById(id);
        return true;
    }
}

