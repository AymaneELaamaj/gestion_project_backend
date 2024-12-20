package com.example.demo_gestion_projet.Entity;

import com.example.demo_gestion_projet.Enum.Statu;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
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
   // @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate debut;
   // @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate Fin;
    @OneToMany(mappedBy = "projet",cascade = CascadeType.REMOVE, orphanRemoval = true)
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
