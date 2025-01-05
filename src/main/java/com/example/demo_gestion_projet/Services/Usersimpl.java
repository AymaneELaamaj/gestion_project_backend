package com.example.demo_gestion_projet.Services;

import com.example.demo_gestion_projet.DTO.Addusertoprj;
import com.example.demo_gestion_projet.Entity.Projet;
import com.example.demo_gestion_projet.Entity.Users;
import com.example.demo_gestion_projet.Repository.ProjetRepo;
import com.example.demo_gestion_projet.Repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Usersimpl implements UsersServcie{
    @Autowired
    private UsersRepo usersRepo;
    @Autowired
    private ProjetRepo projetRepo;

    @Override
    public List<Users> USERS_LIST() {
        return usersRepo.findAll();
    }

    @Override
    public void removeUsers(Long id) {
        usersRepo.deleteById(id);
    }

    @Override
    public Users addUsers(Users users) {
        return usersRepo.save(users);
    }
    @Override
    public Projet addusertoproect(Addusertoprj addusertoprj){
        Users users = usersRepo.findById(addusertoprj.uid()).orElseThrow(() -> new RuntimeException("User not found"));
        Projet projet = projetRepo.findById(addusertoprj.id()).orElseThrow(() -> new RuntimeException("Project not found"));
        if (users != null && projet != null) {
            if (!projet.getUsers().contains(users)) {
                projet.getUsers().add(users);
                users.setProjet(projet);
            }
        } else {
            throw new RuntimeException("User or Project not found");
        }
        usersRepo.save(users);
        projetRepo.save(projet);

        return projet;

    }
}
