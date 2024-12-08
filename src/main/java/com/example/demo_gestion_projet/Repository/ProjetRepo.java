package com.example.demo_gestion_projet.Repository;


import com.example.demo_gestion_projet.Entity.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetRepo extends JpaRepository<Projet,Long> {
}
