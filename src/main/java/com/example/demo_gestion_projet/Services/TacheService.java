package com.example.demo_gestion_projet.Services;

import com.example.demo_gestion_projet.DTO.Addusertoprj;
import com.example.demo_gestion_projet.DTO.ProjetDTO;
import com.example.demo_gestion_projet.DTO.Tachedto;
import com.example.demo_gestion_projet.Entity.Projet;
import com.example.demo_gestion_projet.Entity.Tache;
import com.example.demo_gestion_projet.Entity.Users;

import java.util.List;

public interface TacheService {
    public List<Tache> TACHES_LIST();
    public void removetache(Long id) ;

    public Tache addTache(Tache tache);
    public Users addtachetouser(Addusertoprj addusertoprj);

}
