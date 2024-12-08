package com.example.demo_gestion_projet.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;
    private String name;
    @OneToOne(mappedBy = "users",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Tache tache;
    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonIgnore
    private Projet projet;








    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

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



    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }


}
