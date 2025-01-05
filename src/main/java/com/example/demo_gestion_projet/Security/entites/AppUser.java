package com.example.demo_gestion_projet.Security.entites;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @Column(unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<AppRoles> getRoles() {
        return roles;
    }

    public void setRoles(List<AppRoles> roles) {
        this.roles = roles;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Id
    private String id;
    @Column(unique = true)
    private String username;
    private String password;
    private String email;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<AppRoles> roles; // Stockez les rôles séparés par des virgules ("USER,ADMIN")
    private boolean enabled = true; // Pour activer ou désactiver un compte

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
// Getters et setters
}
