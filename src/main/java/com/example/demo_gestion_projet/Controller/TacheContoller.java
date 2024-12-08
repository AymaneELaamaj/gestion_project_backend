    package com.example.demo_gestion_projet.Controller;

    import com.example.demo_gestion_projet.DTO.Addusertoprj;
    import com.example.demo_gestion_projet.DTO.Tachedto;
    import com.example.demo_gestion_projet.Entity.Projet;
    import com.example.demo_gestion_projet.Entity.Tache;
    import com.example.demo_gestion_projet.Entity.Users;
    import com.example.demo_gestion_projet.Repository.TacheRepo;
    import com.example.demo_gestion_projet.Services.TacheService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.security.access.prepost.PreAuthorize;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequestMapping("/taches")
    public class TacheContoller {
        @Autowired
        private TacheService tacheService;
        @GetMapping("/all")
        @PreAuthorize("hasAuthority('SCOPE_USER')")
        public List<Tache> taches(){
            return tacheService.TACHES_LIST();
        }
        @PostMapping("/savetaches")
        @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
        public Tache savetache( @RequestBody Tache tache){
            return tacheService.addTache(tache);
        }
        @PostMapping("/addtachetoprj")
        @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
        public Users addtachetoproject(@RequestBody Addusertoprj addusertoprj){
            return tacheService.addtachetouser(addusertoprj);
        }
        @DeleteMapping("/{id}")
        @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
        public void removetache(@PathVariable Long id){
            tacheService.removetache(id);
        }
    }
