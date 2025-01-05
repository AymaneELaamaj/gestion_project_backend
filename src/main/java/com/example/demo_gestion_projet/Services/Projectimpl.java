package com.example.demo_gestion_projet.Services;

import com.example.demo_gestion_projet.DTO.UpdateStatus;
import com.example.demo_gestion_projet.Entity.Projet;
import com.example.demo_gestion_projet.Entity.Tache;
import com.example.demo_gestion_projet.Enum.Statu;
import com.example.demo_gestion_projet.Repository.ProjetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
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
    public Map<Statu, Long> getcountstatus() {
        Map<Statu,Long> map=new HashMap<>();
        map.put(Statu.En_cours,projetRepo.countBystatus(Statu.En_cours));
        map.put(Statu.Non_commencé,projetRepo.countBystatus(Statu.Non_commencé));
        map.put(Statu.Terminé,projetRepo.countBystatus(Statu.Terminé));
        return map;

    }


    @Override
    public Projet addproject(Projet projet) {
        return projetRepo.save(projet);
    }

}
