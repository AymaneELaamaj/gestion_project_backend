package com.example.demo_gestion_projet.Services;

import com.example.demo_gestion_projet.DTO.UpdateStatus;
import com.example.demo_gestion_projet.Entity.Projet;
import com.example.demo_gestion_projet.Entity.Tache;
import com.example.demo_gestion_projet.Enum.Statu;
import com.example.demo_gestion_projet.Repository.ProjetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Projectimpl implements ProjectService{
    @Autowired
    private ProjetRepo projetRepo;
    @Override
    public List<Projet> PROJET_LIST() {
        return projetRepo.findAll() ;
    }

    @Override
    public void removeproject(Long id) {
        projetRepo.deleteById(id);
    }

    @Override
    public Projet updateprojectstatus(Long id, UpdateStatus updateStatus) {

        return projetRepo.findById(id)
                .map(projet -> {
                    projet.setStatus(updateStatus.getStatus());
                    return projetRepo.save(projet);
                })
                .orElseThrow(() -> new RuntimeException("Projet introuvable avec l'ID : " + id));



    }


    @Override
    public Projet addproject(Projet projet) {
        return projetRepo.save(projet);
    }

}
