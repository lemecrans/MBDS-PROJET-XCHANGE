package com.mbds.xchange.controller;

import com.mbds.xchange.model.Objet;
import com.mbds.xchange.service.ObjetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/objet")
public class ObjetController {
    private final ObjetService objetService;

    @Autowired
    public ObjetController(ObjetService objetService) {
        this.objetService = objetService;
    }

    @GetMapping
    public ResponseEntity<List<Objet>> getAllObjets() {
        try {
            List<Objet> objets = objetService.getAllObjets();
            if (objets.isEmpty()) {
                return ResponseEntity.noContent().build(); // Retourner HTTP 204 si aucun contenu
            }
            return new ResponseEntity<>(objets, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Objet> createObjet(@Valid @RequestBody Objet objet) {
        Objet createdObjet = objetService.createObjet(objet);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdObjet);
    }
}
