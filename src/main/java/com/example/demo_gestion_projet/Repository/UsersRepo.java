package com.example.demo_gestion_projet.Repository;

import com.example.demo_gestion_projet.Entity.Users;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UsersRepo extends JpaRepository<Users,Long> {

}
