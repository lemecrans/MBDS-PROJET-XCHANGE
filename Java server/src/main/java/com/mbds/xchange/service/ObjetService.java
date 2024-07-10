package com.mbds.xchange.service;

import com.mbds.xchange.configuration.ResourceNotFoundException;
import com.mbds.xchange.model.Objet;
import com.mbds.xchange.model.Utilisateur;
import com.mbds.xchange.repository.ObjetRepository;
import com.mbds.xchange.repository.UtilisateurRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ObjetService {
    private final ObjetRepository objetRepository;

    @Autowired
    public ObjetService(ObjetRepository objetRepository,UtilisateurRepository utilisateurRepository) {
        this.objetRepository = objetRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<Objet> getAllObjets() {
        return objetRepository.findAll();
    }

    @Transactional
    public Objet createObjet(@Valid Objet objet) {
        try {
            return objetRepository.save(objet);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erreur lors de la création de l'objet", e);
        }
    }

    @Transactional
    public Objet changeProprietaire(int objetId, int nouveauProprietaireId) {
        // Vérifier si l'objet existe
        Objet objet = objetRepository.findById(objetId)
                .orElseThrow(() -> new ResourceNotFoundException("Objet non trouvé avec l'ID : " + objetId));

        // Vérifier si le nouveau propriétaire existe
        Utilisateur nouveauProprietaire = utilisateurRepository.findById(nouveauProprietaireId);

        // Changer le propriétaire de l'objet
        objet.setProprietaire(nouveauProprietaire);

        // Sauvegarder et retourner l'objet mis à jour
        return objetRepository.save(objet);
    }
}
