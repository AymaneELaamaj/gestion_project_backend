package com.example.demo_gestion_projet.Mapper;

import com.example.demo_gestion_projet.DTO.ProjetDTO;
import com.example.demo_gestion_projet.DTO.Tachedto;
import com.example.demo_gestion_projet.DTO.UsersDTo;
import com.example.demo_gestion_projet.Entity.Projet;
import com.example.demo_gestion_projet.Entity.Tache;
import com.example.demo_gestion_projet.Entity.Users;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
@Service
public class mapper {

    public Tachedto tachetotachedto(Tache tache){
        Tachedto tachedto=new Tachedto();
        BeanUtils.copyProperties(tache,tachedto);
        tachedto.setUsers(touserdto(tache.getUsers()));
        return tachedto;
    }
    public Tache tachedtototache(Tachedto tachedto){
        Tache tache=new Tache();
        BeanUtils.copyProperties(tachedto,tache);
        tache.setUsers(tousers(tachedto.getUsers()));
        return tache;
    }
    public ProjetDTO toprojectdto(Projet projet){
        ProjetDTO projetDTO=new ProjetDTO();
        BeanUtils.copyProperties(projet,projetDTO);
        projetDTO.setUsers(projet.getUsers().stream().map(u->touserdto(u)).collect(Collectors.toList()));
        return projetDTO;
    }
    public Projet toproject(ProjetDTO projetdto){
        Projet projet=new Projet();
        BeanUtils.copyProperties(projetdto,projet);
        projet.setUsers(projetdto.getUsers().stream().map(u->tousers(u)).collect(Collectors.toList()));
        return projet;
    }
    public UsersDTo touserdto(Users users){
        UsersDTo usersDTo=new UsersDTo();
        BeanUtils.copyProperties(usersDTo,users);
        usersDTo.setProjet(toprojectdto(users.getProjet()));
        usersDTo.setTache(tachetotachedto(users.getTache()));
        return usersDTo;
    }
    public Users tousers(UsersDTo usersDTo){
        Users users=new Users();
        BeanUtils.copyProperties(users,usersDTo);
        users.setProjet(toproject(usersDTo.getProjet()));
        users.setTache(tachedtototache(usersDTo.getTache()));
        return users;
    }
}
