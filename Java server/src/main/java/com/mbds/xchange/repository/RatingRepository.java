package com.mbds.xchange.repository;

import com.mbds.xchange.model.Rating;
import com.mbds.xchange.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByUtilisateurEvalue(Utilisateur utilisateurEvalue);
    Rating findByUtilisateurEvalueAndUtilisateurNotant(Utilisateur utilisateurEvalue, Utilisateur utilisateurNotant);
}
