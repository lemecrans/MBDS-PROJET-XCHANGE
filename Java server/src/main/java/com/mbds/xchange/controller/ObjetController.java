package com.mbds.xchange.controller;

import com.mbds.xchange.configuration.ResourceNotFoundException;
import com.mbds.xchange.model.Objet;
import com.mbds.xchange.service.ObjetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/myThing")
    public ResponseEntity<List<Objet>> getMyObjets(@RequestParam Long idUser) {
        try {
            List<Objet> objets = objetService.getObjetsByProprietaire(idUser);
            if (objets.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return new ResponseEntity<>(objets, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{idObjet}")
    public ResponseEntity<Objet> getObjectById(@PathVariable int idObjet) {
        try {
            Objet objet = objetService.getObjectById(idObjet);
            return new ResponseEntity<>(objet, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }  catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<Objet> updateObjet(@RequestBody Objet objetDetails) {
        Objet updatedObjet = objetService.updateObjet(objetDetails);
        return ResponseEntity.ok(updatedObjet);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<Objet> patchObjet(@PathVariable int id, @RequestBody Map<String, Object> updates) {
        Objet patchedObjet = objetService.patchObjet(id, updates);
        return ResponseEntity.ok(patchedObjet);
    }
}
