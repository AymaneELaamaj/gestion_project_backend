package com.example.demo_gestion_projet.DTO;

import com.example.demo_gestion_projet.Entity.Projet;
import com.example.demo_gestion_projet.Entity.Users;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tachedto {
    private Long tid;
    private String name;
    private Date debut;

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return Fin;
    }

    public void setFin(Date fin) {
        Fin = fin;
    }



    public UsersDTo getUsers() {
        return users;
    }

    public void setUsers(UsersDTo users) {
        this.users = users;
    }

    private Date Fin;

    private UsersDTo users;

}
