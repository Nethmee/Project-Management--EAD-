package com.teamproj.hrtaskdivider.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamproj.hrtaskdivider.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

	
}
