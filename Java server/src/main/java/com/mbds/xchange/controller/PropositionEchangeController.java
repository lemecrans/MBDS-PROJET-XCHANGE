package com.mbds.xchange.controller;

import com.mbds.xchange.model.PropositionEchange;
import com.mbds.xchange.repository.ObjetEchangeRepository;
import com.mbds.xchange.repository.ObjetRepository;
import com.mbds.xchange.repository.UtilisateurRepository;
import com.mbds.xchange.service.PropositionEchangeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<PropositionEchange> createProposition(
            @Valid @RequestBody PropositionEchange propositionEchange,
            @RequestParam List<Integer> objetIds,
            @RequestParam int destinataireId,
            @RequestParam int proposantId) {
        PropositionEchange createdProposition = propositionEchangeService.createProposition(propositionEchange, objetIds, destinataireId,proposantId);
        return new ResponseEntity<>(createdProposition, HttpStatus.CREATED);
    }
}
