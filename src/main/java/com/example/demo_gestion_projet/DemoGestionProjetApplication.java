package com.example.demo_gestion_projet;


import com.example.demo_gestion_projet.Entity.Projet;
import com.example.demo_gestion_projet.Entity.Tache;
import com.example.demo_gestion_projet.Entity.Users;
import com.example.demo_gestion_projet.Enum.Statu;
import com.example.demo_gestion_projet.Repository.ProjetRepo;
import com.example.demo_gestion_projet.Repository.TacheRepo;
import com.example.demo_gestion_projet.Repository.UsersRepo;
import com.example.demo_gestion_projet.Security.Service.AccountService;
import com.example.demo_gestion_projet.Security.entites.AppRoles;
import com.example.demo_gestion_projet.Security.entites.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DemoGestionProjetApplication implements CommandLineRunner {
	@Autowired
	private ProjetRepo projetRepo;
	@Autowired
	private TacheRepo tacheRepo;
	@Autowired
	private UsersRepo usersRepo;

	//@Bean
	PasswordEncoder passwordEncode() {
		return new BCryptPasswordEncoder();
	}
	@Autowired
	private AccountService accountService; // Votre service qui gère les utilisateurs et les rôles


	public static void main(String[] args) {
		SpringApplication.run(DemoGestionProjetApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
//		AppRoles roleUser = accountService.AddRoles("USER");
//		AppRoles roleAdmin = accountService.AddRoles("ADMIN");
//
//		// Ajout des utilisateurs avec leurs rôles respectifs
//		AppUser user1 = accountService.Adduser("user1", "user1@example.com", "1234", "1234");
//		AppUser user2 = accountService.Adduser("user2", "user2@example.com", "1234", "1234");
//		AppUser admin = accountService.Adduser("admin1", "admin@example.com", "1234", "1234");
//
//		// Ajout des rôles aux utilisateurs
//		accountService.AddRoletoUser("user1", "USER");
//		accountService.AddRoletoUser("admin1", "ADMIN");
//		accountService.AddRoletoUser("user2", "USER");
//		accountService.AddRoletoUser("admin1", "ADMIN");
//		Projet projet1=new Projet();
//		projet1.setDebut(LocalDate.now());
//		projet1.setFin(LocalDate.of(2025, 7, 1));
//		projet1.setStatus(Statu.En_cours);
//		projet1.setName("dev d'une app des gestion des employee");
//		projetRepo.save(projet1);
//
//		Users users=new Users();
//		users.setName("aymane");
//		users.setProjet(projet1);
//		usersRepo.save(users);
//		Users users2=new Users();
//		users2.setProjet(projet1);
//		users2.setName("youssef");
//		usersRepo.save(users2);
//		Tache tache1=new Tache();
//		tache1.setDebut(LocalDate.now());
//		tache1.setFin(LocalDate.of(2025, 7, 1));
//		tache1.setName("dev front");
//		tache1.setUsers(users);
//		tache1.setStatus(Statu.Non_commencé);
//		tacheRepo.save(tache1);
//		Tache tache2=new Tache();
//		tache2.setName("dev back");
//		tache2.setDebut(LocalDate.now());
//		tache2.setFin(LocalDate.of(2025, 7, 1));
//		tache2.setUsers(users2);
//		tache2.setStatus(Statu.En_cours);
//		tacheRepo.save(tache2);
	}
}
