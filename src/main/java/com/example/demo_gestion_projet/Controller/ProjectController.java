package com.example.demo_gestion_projet.Controller;

import com.example.demo_gestion_projet.DTO.UpdateStatus;
import com.example.demo_gestion_projet.Entity.Projet;
import com.example.demo_gestion_projet.Enum.Statu;
import com.example.demo_gestion_projet.Repository.ProjetRepo;
import com.example.demo_gestion_projet.Services.ProjectService;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Project")
@CrossOrigin("*")

public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    public List<Projet> projets(){
        return projectService.PROJET_LIST();
    }
    @PostMapping("/saveProject")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
    public Projet addproject(@RequestBody Projet projet) {
        return projectService.addproject(projet);
    }
    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
    public Projet updateprojectstatus(@PathVariable Long id, @RequestBody UpdateStatus updateStatus) {
        return projectService.updateprojectstatus(id,updateStatus);
    }
    @GetMapping("/getstatus")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
    public Map<Statu,Long>getstatus(){
        return projectService.getcountstatus();
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    public void removeproject(@PathVariable Long id) {
        projectService.removeproject(id);
    }



}
