package com.example.demo_gestion_projet.Security.Service;

import com.example.demo_gestion_projet.Security.Repo.AppRoleRepository;
import com.example.demo_gestion_projet.Security.Repo.AppUserRepository;
import com.example.demo_gestion_projet.Security.entites.AppRoles;
import com.example.demo_gestion_projet.Security.entites.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AppRoleRepository appRoleRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // Encoder pour les mots de passe

    @Override
    public AppUser Adduser(String username, String email, String password, String repeatpassword) {
        // Vérification que les mots de passe correspondent
        if (!password.equals(repeatpassword)) {
            throw new IllegalArgumentException("Les mots de passe ne correspondent pas");
        }

        // Vérification si l'utilisateur existe déjà
        if (appUserRepository.findByUsername(username) != null) {
            throw new IllegalArgumentException("Nom d'utilisateur déjà pris");
        }

        // Création de l'utilisateur
        AppUser newUser = new AppUser();
        newUser.setId(UUID.randomUUID().toString());
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(passwordEncoder.encode(password)); // Encoder le mot de passe
        newUser.setEnabled(true);

        // Enregistrer l'utilisateur dans la base de données
        return appUserRepository.save(newUser);
    }

    @Override
    public AppRoles AddRoles(String roleName) {
        AppRoles appRoles = appRoleRepository.findById(roleName).orElse(null);
        if ( appRoles!= null) {
            throw new RuntimeException("Le rôle existe déjà");
        }

        // Créer un nouveau rôle
        AppRoles newRole = new AppRoles();
        newRole.setRole(roleName);

        // Sauvegarder le rôle
        return appRoleRepository.save(newRole);
    }

    @Override
    public void AddRoletoUser(String username, String role) {
        // Récupérer l'utilisateur par nom d'utilisateur
        AppUser user = appUserRepository.findByUsername(username);


        // Récupérer le rôle par son nom
        AppRoles appRole = appRoleRepository.findById(role).get();


        // Associer le rôle à l'utilisateur
        user.getRoles().add(appRole); // Assurez-vous que AppUser a une collection de rôles
        appUserRepository.save(user);
    }

    @Override
    public void removeRoleFromUser(String username, String role) {
        // Récupérer l'utilisateur par nom d'utilisateur
        AppUser user = appUserRepository.findByUsername(username);


        // Récupérer le rôle par son nom
        AppRoles appRole = appRoleRepository.findById(role).get();


        // Retirer le rôle de l'utilisateur
        user.getRoles().remove(appRole); // Assurez-vous que AppUser a une collection de rôles
        appUserRepository.save(user);
    }

    @Override
    public AppUser loadUserByusername(String username) {
        return appUserRepository.findByUsername(username);
    }
}
