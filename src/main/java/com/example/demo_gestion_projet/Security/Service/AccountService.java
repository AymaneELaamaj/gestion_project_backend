package com.example.demo_gestion_projet.Security.Service;

import com.example.demo_gestion_projet.Security.entites.AppRoles;
import com.example.demo_gestion_projet.Security.entites.AppUser;

public interface AccountService {
     AppUser Adduser(String username, String email, String password, String repeadpassword);
     AppRoles AddRoles(String roles);
      void AddRoletoUser(String username,String role);
      void removeRoleFromUser(String username,String role);
      AppUser loadUserByusername(String username);
}
