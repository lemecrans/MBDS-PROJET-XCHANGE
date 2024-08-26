package com.mbds.xchange.controller;

import com.mbds.xchange.configuration.ResourceNotFoundException;
import com.mbds.xchange.model.*;
import com.mbds.xchange.service.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/stat")
@RequiredArgsConstructor
@Slf4j
public class StatistiqueController {
    private final ObjetService objServ;
    private final UtilisateurService userServ;
    private final PropositionEchangeService propServ;

    @GetMapping("/objet")
    public ResponseEntity<?> statObj() {
        try {
            Statistique stat = new Statistique("Objet en échange",objServ.getAllObjets().size());
            if(stat!=null){
                return ResponseEntity.ok(stat);
            }else{
                throw new ResourceNotFoundException("Aucun Utilisateur trouvé");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }
    @GetMapping("/user")
    public ResponseEntity<?> statUser() {
        try {
            Statistique stat = new Statistique("Utilisateurs",userServ.getUsers().size());
            if(stat!=null){
                return ResponseEntity.ok(stat);
            }else{
                throw new ResourceNotFoundException("Aucun Utilisateur trouvé");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }
    @GetMapping("/proposition")
    public ResponseEntity<?> statProp() {
        try {
            Statistique stat = new Statistique("Echange",propServ.getAllEchange().size());
            if(stat!=null){
                return ResponseEntity.ok(stat);
            }else{
                throw new ResourceNotFoundException("Aucun Utilisateur trouvé");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }
    
}