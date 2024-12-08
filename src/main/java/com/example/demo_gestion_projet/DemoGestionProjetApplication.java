package com.example.demo_gestion_projet;


import com.example.demo_gestion_projet.Entity.Projet;
import com.example.demo_gestion_projet.Entity.Tache;
import com.example.demo_gestion_projet.Entity.Users;
import com.example.demo_gestion_projet.Enum.Statu;
import com.example.demo_gestion_projet.Repository.ProjetRepo;
import com.example.demo_gestion_projet.Repository.TacheRepo;
import com.example.demo_gestion_projet.Repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
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

	public static void main(String[] args) {
		SpringApplication.run(DemoGestionProjetApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		Projet projet1=new Projet();
		projet1.setDebut(LocalDate.now());
		projet1.setFin(LocalDate.of(2025,07,01));
		projet1.setName("dev d'une app des gestion des employee");
		projetRepo.save(projet1);

		Users users=new Users();
		users.setName("aymane");
		users.setProjet(projet1);
		usersRepo.save(users);
		Users users2=new Users();
		users2.setProjet(projet1);
		users2.setName("youssef");
		usersRepo.save(users2);
		Tache tache1=new Tache();
		tache1.setDebut(new Date());
		tache1.setFin(new Date());
		tache1.setName("dev front");
		tache1.setUsers(users);
		tache1.setStatus(Statu.Non_commence);
		tacheRepo.save(tache1);
		Tache tache2=new Tache();

		tache2.setName("dev back");
		tache2.setDebut(new Date());
		tache2.setFin(new Date());
		tache2.setUsers(users2);
		tache2.setStatus(Statu.En_cours);
		tacheRepo.save(tache2);
	}
}
