package com.example.demo_gestion_projet.Controller;

import com.example.demo_gestion_projet.DTO.Addusertoprj;
import com.example.demo_gestion_projet.DTO.UsersDTo;
import com.example.demo_gestion_projet.Entity.Projet;
import com.example.demo_gestion_projet.Entity.Users;
import com.example.demo_gestion_projet.Services.UsersServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Users")

public class UsersContoller {
    @Autowired
    private UsersServcie usersServcie;
    @GetMapping("/findall")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public List<Users> findusers(){
        return usersServcie.USERS_LIST();
    }
    @PostMapping("/saveusers")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Users saveusers(@RequestBody Users users){
        return usersServcie.addUsers(users);
    }
    @PostMapping("/addtoproj")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Projet addusertoprj(@RequestBody Addusertoprj addusertoprj){
        return usersServcie.addusertoproect(addusertoprj);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public void removeuser(@PathVariable Long id){
        usersServcie.removeUsers(id);
    }
}
