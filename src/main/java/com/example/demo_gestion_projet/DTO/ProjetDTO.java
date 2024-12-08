package com.example.demo_gestion_projet.DTO;

import com.example.demo_gestion_projet.Entity.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjetDTO {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




    private  String name;
    private LocalDate debut;
    private LocalDate Fin;


    public List<UsersDTo> getUsers() {
        return users;
    }
    private List<UsersDTo> users;



    public void setUsers(List<UsersDTo> users) {
        this.users = users;
    }

    public LocalDate getDebut() {
        return debut;
    }

    public void setDebut(LocalDate debut) {
        this.debut = debut;
    }

    public LocalDate getFin() {
        return Fin;
    }

    public void setFin(LocalDate fin) {
        Fin = fin;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }









}
