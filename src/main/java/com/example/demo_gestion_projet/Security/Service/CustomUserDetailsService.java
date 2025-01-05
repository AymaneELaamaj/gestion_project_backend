package com.example.demo_gestion_projet.Security.Service;

import com.example.demo_gestion_projet.Repository.UserRepository;
import com.example.demo_gestion_projet.Security.entites.AppUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = userRepository.findByUsername(username);
        if (appUser == null) {
            System.out.println("User not found with username: " + username);
            throw new UsernameNotFoundException("User not found");
        }
        System.out.println("User found: " + appUser.getUsername());
        String[] role = appUser.getRoles().stream().map(u -> u.getRole()).toArray(String[] ::new);
        return User.builder()
                .username(appUser.getUsername())
                .password(appUser.getPassword())
                .roles(role)
                .build();
    }

}

