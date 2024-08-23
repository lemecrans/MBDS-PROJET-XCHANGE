package com.mbds.xchange.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mbds.xchange.configuration.ResourceNotFoundException;
import com.mbds.xchange.model.Objet;
import com.mbds.xchange.service.ObjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

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

    @PostMapping(consumes={MediaType.MULTIPART_FORM_DATA_VALUE},produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Integer> createObjet(
            @RequestParam("objet") String objetString,
            @RequestParam("image") MultipartFile file) {
        try {
            Objet objet = new ObjectMapper().readValue(objetString, Objet.class);
            byte[] fileBytes = file.getBytes();
            int id = objetService.createObjet(objet,file);
            return ResponseEntity.status(HttpStatus.CREATED).body(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
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
    @DeleteMapping
    public ResponseEntity<?> DeleteObjet(@RequestParam int id) {
        try {
            Boolean isdeleted = objetService.deleteObjetById(id);
            if(isdeleted){
                return ResponseEntity.ok("Objet Supprimé");
            }else{
                throw new ResourceNotFoundException("Aucun Objet trouvé");
            }
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }
}
