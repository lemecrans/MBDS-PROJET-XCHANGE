package com.mbds.xchange.controller;

import com.mbds.xchange.configuration.ResourceNotFoundException;
import com.mbds.xchange.service.RatingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rating")
@RequiredArgsConstructor
@Slf4j
public class RatingController {

    private final RatingService ratingService;

    @PostMapping
    public ResponseEntity<String> ajouterEvaluation(@RequestParam Long utilisateurEvalueId,
                                                    @RequestParam Long utilisateurNotantId,
                                                    @RequestParam int note) {
        try {
            ratingService.noterUtilisateur(utilisateurEvalueId, utilisateurNotantId, note);
            return ResponseEntity.ok("Évaluation ajoutée avec succès");
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur interne du serveur");
        }
    }
}
