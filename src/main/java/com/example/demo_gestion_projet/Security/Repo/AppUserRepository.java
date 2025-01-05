package com.example.demo_gestion_projet.Security.Repo;

import com.example.demo_gestion_projet.Security.entites.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,String> {
    AppUser findByUsername(String username);
}
