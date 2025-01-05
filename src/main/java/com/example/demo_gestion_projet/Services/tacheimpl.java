package com.example.demo_gestion_projet.Services;

import com.example.demo_gestion_projet.DTO.Addusertoprj;
import com.example.demo_gestion_projet.DTO.ProjetDTO;
import com.example.demo_gestion_projet.DTO.Tachedto;
import com.example.demo_gestion_projet.Entity.Projet;
import com.example.demo_gestion_projet.Entity.Tache;
import com.example.demo_gestion_projet.Entity.Users;
import com.example.demo_gestion_projet.Mapper.mapper;
import com.example.demo_gestion_projet.Repository.ProjetRepo;
import com.example.demo_gestion_projet.Repository.TacheRepo;
import com.example.demo_gestion_projet.Repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class tacheimpl implements TacheService{
    @Autowired
    private TacheRepo tacheRepo;
    @Autowired
    private ProjetRepo projetRepo;
    @Autowired
    private UsersRepo usersRepo;
    @Autowired
    private mapper mappere;

    @Override
    public List<Tache> TACHES_LIST() {

        return tacheRepo.findAll();
    }

    @Override
    public void removetache(Long id) {
        tacheRepo.deleteById(id);
    }

    @Override
    public Tache addTache(Tache tache) {
        Tache savedProjet = tacheRepo.save(tache);

        return savedProjet;
    }
    @Override
    public Users addtachetouser(Addusertoprj addusertoprj){
        Tache tache = tacheRepo.findById(addusertoprj.tid()).orElseThrow(() -> new RuntimeException("Tache not found"));
        Users user = usersRepo.findById(addusertoprj.uid()).orElseThrow(() -> new RuntimeException("User not found"));
        if (tache != null && user != null) {

            tache.setUsers(user);
            user.setTache(tache);


        } else {
            throw new RuntimeException("Tache or user not found");
        }

        tacheRepo.save(tache);
        usersRepo.save(user);

        return user;

    }







}
