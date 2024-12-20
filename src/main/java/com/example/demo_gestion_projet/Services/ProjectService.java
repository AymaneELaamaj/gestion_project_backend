package com.example.demo_gestion_projet.Services;

import com.example.demo_gestion_projet.DTO.UpdateStatus;
import com.example.demo_gestion_projet.Entity.Projet;
import com.example.demo_gestion_projet.Entity.Tache;
import com.example.demo_gestion_projet.Entity.Users;
import com.example.demo_gestion_projet.Enum.Statu;

import java.util.List;
import java.util.Map;

public interface ProjectService {
    public List<Projet> PROJET_LIST();



    public Projet addproject(Projet projet);




    public void removeproject(Long id);

    Projet updateprojectstatus(Long id, UpdateStatus updateStatus);
    Map<Statu, Long> getcountstatus();
}
