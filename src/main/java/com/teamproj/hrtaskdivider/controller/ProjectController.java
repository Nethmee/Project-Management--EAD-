package com.teamproj.hrtaskdivider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.teamproj.hrtaskdivider.exception.ResourceNotFoundException;
import com.teamproj.hrtaskdivider.model.Project;
import com.teamproj.hrtaskdivider.repository.ProjectRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

 // Get All Projects
    @GetMapping("/projects")
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

 // Create a new Project
    @PostMapping("/projects")
    public Project createProject(@Valid @RequestBody Project project) {
        return projectRepository.save(project);
    }

 // Get a Single Project
    @GetMapping("/projects/{id}")
    public Project getProjectById(@PathVariable(value = "id") Long projectId) {
        return projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project", "id", projectId));
    }

 // Update a Project
    @PutMapping("/projects/{id}")
    public Project updateProject(@PathVariable(value = "id") Long projectId,
                                            @Valid @RequestBody Project projectDetails) {

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project", "id", projectId));

        project.setClientName(projectDetails.getClientName());
        project.setName(projectDetails.getName());
        project.setDescription(projectDetails.getDescription());
        project.setDueDate(projectDetails.getDueDate());
        
        Project updatedProject = projectRepository.save(project);
        return updatedProject;
    }

 // Delete a Project
    @DeleteMapping("/projects/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable(value = "id") Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project", "id", projectId));

        projectRepository.delete(project);

        return ResponseEntity.ok().build();
    }
}
