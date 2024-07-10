package com.mbds.xchange.controller;

import com.mbds.xchange.configuration.ResourceNotFoundException;
import com.mbds.xchange.model.Utilisateur;
import com.mbds.xchange.service.UtilisateurService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Slf4j
public class UtilisateurController {
    private final UtilisateurService userServ;
    @GetMapping
    public ResponseEntity<?> getUser(@RequestParam  int id) {
        try {
            Utilisateur currentUser = userServ.getUser(id);
            if(currentUser!=null){
                return ResponseEntity.ok(currentUser);
            }else{
                throw new ResourceNotFoundException("Aucun Utilisateur trouvé");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }
    @DeleteMapping
    public ResponseEntity<?> DeleteUser(@RequestParam int id) {
        try {
            int stat = userServ.DeleteUser(id);
            if(stat==0){
                return ResponseEntity.ok("Utilisateur Supprimé");
            }else{
                throw new ResourceNotFoundException("Aucun Utilisateur trouvé");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }

}