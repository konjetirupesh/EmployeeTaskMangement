package com.SpringbootProject.UniDirectionalMappingPractice.repository;

import com.SpringbootProject.UniDirectionalMappingPractice.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
