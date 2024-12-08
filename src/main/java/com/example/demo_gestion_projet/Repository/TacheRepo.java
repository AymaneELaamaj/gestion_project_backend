package com.example.demo_gestion_projet.Repository;

import com.example.demo_gestion_projet.Entity.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TacheRepo extends JpaRepository<Tache,Long> {
}
