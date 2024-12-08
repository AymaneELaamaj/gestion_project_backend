package com.example.demo_gestion_projet.Services;

import com.example.demo_gestion_projet.DTO.Addusertoprj;
import com.example.demo_gestion_projet.Entity.Projet;
import com.example.demo_gestion_projet.Entity.Users;

import java.util.List;

public interface UsersServcie {
    public List<Users> USERS_LIST();
    public void removeUsers(Long id) ;
    public Projet addusertoproect(Addusertoprj addusertoprj);

    public Users addUsers(Users users);
}
