package com.example.demo_gestion_projet.Services;

import com.example.demo_gestion_projet.Entity.Projet;
import com.example.demo_gestion_projet.Entity.Tache;
import com.example.demo_gestion_projet.Entity.Users;

import java.util.List;

public interface ProjectService {
    public List<Projet> PROJET_LIST();



    public Projet addproject(Projet projet);




    public void removeproject(Long id);
}
