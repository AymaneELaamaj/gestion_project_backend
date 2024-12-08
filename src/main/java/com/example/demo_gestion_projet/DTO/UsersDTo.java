package com.example.demo_gestion_projet.DTO;

import com.example.demo_gestion_projet.Entity.Projet;
import com.example.demo_gestion_projet.Entity.Tache;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersDTo {
    private Long uid;
    private String name;
    private ProjetDTO projet;
    private Tachedto tache;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProjetDTO getProjet() {
        return projet;
    }

    public void setProjet(ProjetDTO projet) {
        this.projet = projet;
    }

    public Tachedto getTache() {
        return tache;
    }

    public void setTache(Tachedto tache) {
        this.tache = tache;
    }
}
