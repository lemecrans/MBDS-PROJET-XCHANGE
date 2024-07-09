package com.mbds.xchange.service;

import com.mbds.xchange.configuration.ResourceNotFoundException;
import com.mbds.xchange.model.Rating;
import com.mbds.xchange.model.Utilisateur;
import com.mbds.xchange.repository.RatingRepository;
import com.mbds.xchange.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingService {

    private final RatingRepository ratingRepository;
    private final UtilisateurRepository utilisateurRepository;

    public void noterUtilisateur(Long utilisateurEvalueId, Long utilisateurNotantId, int note) {
        Utilisateur utilisateurEvalue = utilisateurRepository.findById(utilisateurEvalueId)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur non trouvé"));
        Utilisateur utilisateurNotant = utilisateurRepository.findById(utilisateurNotantId)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur non trouvé"));

        Rating evaluation = new Rating();
        evaluation.setUtilisateurEvalue(utilisateurEvalue);
        evaluation.setUtilisateurNotant(utilisateurNotant);
        evaluation.setNote(note);
        ratingRepository.save(evaluation);

        mettreAJourNoteMoyenne(utilisateurEvalue);
    }

    private void mettreAJourNoteMoyenne(Utilisateur utilisateurEvalue) {
        List<Rating> ratignsUser = ratingRepository.findByUtilisateurEvalue(utilisateurEvalue);
        double moyenne = ratignsUser.stream().mapToInt(Rating::getNote).average().orElse(0.0);

        utilisateurEvalue.setNoteMoyenne(moyenne);
        utilisateurEvalue.setNombreDeNotes(ratignsUser.size());
        utilisateurRepository.save(utilisateurEvalue);
    }
}
