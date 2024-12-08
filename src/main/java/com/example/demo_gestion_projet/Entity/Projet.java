package com.example.demo_gestion_projet.Entity;

import com.example.demo_gestion_projet.Enum.Statu;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String name;
    private LocalDate debut;
    private LocalDate Fin;
    @OneToMany(mappedBy = "projet")
    private List<Users> users;
    public Statu getStatus() {
        return status;
    }

    public void setStatus(Statu status) {
        this.status = status;
    }

    @Enumerated(EnumType.STRING)
    private Statu status;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
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
