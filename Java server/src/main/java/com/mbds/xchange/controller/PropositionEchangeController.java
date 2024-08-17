package com.mbds.xchange.controller;

import com.mbds.xchange.configuration.ResourceNotFoundException;
import com.mbds.xchange.dto.ObjetEchangeDTO;
import com.mbds.xchange.dto.PropositionEchangeDTO;
import com.mbds.xchange.model.ObjetEchange;
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

import java.util.*;

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

    @GetMapping
    public ResponseEntity<?> getPropositionEchanges() {
        try {
            List<PropositionEchange> propositionEchanges = propositionEchangeService.getAllEchange();
            List<ObjetEchange> objetEchanges = objetEchangeService.getAllObjetEchange();

            Map<Integer, List<ObjetEchangeDTO>> propositionObjetMap = new HashMap<>();
            for (ObjetEchange objetEchange : objetEchanges) {
                int propositionId = objetEchange.getProposition().getId();
                ObjetEchangeDTO objetEchangeDTO = new ObjetEchangeDTO(objetEchange);
                propositionObjetMap
                        .computeIfAbsent(propositionId, k -> new ArrayList<>())
                        .add(objetEchangeDTO);
            }

            List<PropositionEchangeDTO> responseList = new ArrayList<>();
            for (PropositionEchange proposition : propositionEchanges) {
                List<ObjetEchangeDTO> objetsEchangesDTO = propositionObjetMap.getOrDefault(proposition.getId(), new ArrayList<>());
                PropositionEchangeDTO propositionDTO = new PropositionEchangeDTO(proposition);
                propositionDTO.setObjetsEchanges(objetsEchangesDTO);
                responseList.add(propositionDTO);
            }

            return new ResponseEntity<>(responseList, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPropositionEchanges(@PathVariable("id") int id) {
        try {
            Optional<PropositionEchange> optionalPropositionEchange = propositionEchangeService.getEchange(id);

            if (optionalPropositionEchange.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            List<ObjetEchange> objetEchanges = objetEchangeService.getObjetEchange(id);

            List<ObjetEchangeDTO> objetsEchangesDTO = new ArrayList<>();
            for (ObjetEchange objetEchange : objetEchanges) {
                ObjetEchangeDTO objetEchangeDTO = new ObjetEchangeDTO(objetEchange);
                objetsEchangesDTO.add(objetEchangeDTO);
            }

            PropositionEchangeDTO propositionDTO = new PropositionEchangeDTO(optionalPropositionEchange.get());
            propositionDTO.setObjetsEchanges(objetsEchangesDTO);

            return new ResponseEntity<>(propositionDTO, HttpStatus.OK);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }



}
