package com.example.demo_gestion_projet.Entity;

import com.example.demo_gestion_projet.Enum.Statu;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tid;
    private String name;
    private Date debut;

    public Statu getStatus() {
        return status;
    }

    public void setStatus(Statu status) {
        this.status = status;
    }

    @Enumerated(EnumType.STRING)
    private Statu status;
    private Date Fin;
    @OneToOne
    @JoinColumn(name = "users_id")

    @JsonIgnore
    private Users users;


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



    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }



}