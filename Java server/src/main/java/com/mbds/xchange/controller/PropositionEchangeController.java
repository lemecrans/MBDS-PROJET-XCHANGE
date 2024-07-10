package com.mbds.xchange.controller;

import com.mbds.xchange.configuration.ResourceNotFoundException;
import com.mbds.xchange.model.PropositionEchange;
import com.mbds.xchange.repository.ObjetEchangeRepository;
import com.mbds.xchange.repository.ObjetRepository;
import com.mbds.xchange.repository.UtilisateurRepository;
import com.mbds.xchange.service.ObjetEchangeService;
import com.mbds.xchange.service.PropositionEchangeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/propositions")
public class PropositionEchangeController {

    @Autowired
    private PropositionEchangeService propositionEchangeService;

    @Autowired
    private ObjetEchangeRepository objetEchangeRepository;

    @Autowired
    private ObjetRepository objetRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private ObjetEchangeService objetEchangeService;

    @PostMapping
    public ResponseEntity<PropositionEchange> createProposition(
            @Valid @RequestBody PropositionEchange propositionEchange,
            @RequestParam List<Integer> objetIds,
            @RequestParam int destinataireId,
            @RequestParam int proposantId) {
        PropositionEchange createdProposition = propositionEchangeService.createProposition(propositionEchange, objetIds, destinataireId,proposantId);
        return new ResponseEntity<>(createdProposition, HttpStatus.CREATED);
    }

    @PutMapping("/{propositionId}/valider")
    public ResponseEntity<?> validerProposition(@PathVariable int propositionId) {
        try {
            PropositionEchange proposition = objetEchangeService.switchProprietaire(propositionId);
            return ResponseEntity.ok().body(proposition);
        } catch (ResourceNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        } catch (IllegalStateException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        }
    }
}
