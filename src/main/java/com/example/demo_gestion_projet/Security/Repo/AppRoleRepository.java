package com.example.demo_gestion_projet.Security.Repo;

import com.example.demo_gestion_projet.Security.entites.AppRoles;
import com.example.demo_gestion_projet.Security.entites.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRoles,String> {
}
