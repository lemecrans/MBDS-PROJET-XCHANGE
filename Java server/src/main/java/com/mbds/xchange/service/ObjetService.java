package com.mbds.xchange.service;

import com.mbds.xchange.configuration.ResourceNotFoundException;
import com.mbds.xchange.model.Objet;
import com.mbds.xchange.model.ObjetEchange;
import com.mbds.xchange.model.PropositionEchange;
import com.mbds.xchange.model.Utilisateur;
import com.mbds.xchange.repository.ObjetEchangeRepository;
import com.mbds.xchange.repository.ObjetRepository;
import com.mbds.xchange.repository.PropositionEchangeRepository;
import com.mbds.xchange.repository.UtilisateurRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ObjetService {
    private final ObjetRepository objetRepository;

    @Autowired
    private ObjetEchangeRepository objetEchangeRepository;

    @Autowired
    private PropositionEchangeRepository propositionEchangeRepository;

    @Autowired
    public ObjetService(ObjetRepository objetRepository, UtilisateurRepository utilisateurRepository) {
        this.objetRepository = objetRepository;
        this.utilisateurRepository = utilisateurRepository;
    }


    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Objet> getAllObjets() {
        return objetRepository.findAll();
    }

    @Transactional
    public int createObjet(Objet objet, MultipartFile file) {
        try {
            byte[] imageBytes = file.getBytes();
            objetRepository.insertObjet(
                    objet.getDescription(),
                    objet.isDisponible(),
                    imageBytes,
                    objet.getNom(),
                    objet.getProprietaire().getId(),
                    objet.getValeur()
            );
            String sql = "SELECT currval(pg_get_serial_sequence('objet', 'id'))";
            return jdbcTemplate.queryForObject(sql, Integer.class);
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
    public List<Objet> getObjetsByProprietaire(long proprietaireId) {
        Utilisateur proprietaire = utilisateurRepository.findById(proprietaireId);
        return objetRepository.findByProprietaire(proprietaire);
    }

    public Objet getObjectById(int idObjet) {
        return objetRepository.findById(idObjet)
                .orElseThrow(() -> new ResourceNotFoundException("Objet not found with id " + idObjet));
    }

    public Objet updateObjet(Objet objetDetails) {
        int id = objetDetails.getId();
        Optional<Objet> objetOptional = objetRepository.findById(id);
        if (objetOptional.isPresent()) {
            Objet objet = objetOptional.get();
            objet.setNom(objetDetails.getNom());
            objet.setDescription(objetDetails.getDescription());
            objet.setValeur(objetDetails.getValeur());
            objet.setProprietaire(objetDetails.getProprietaire());
            objet.setDisponible(objetDetails.isDisponible());
            return objetRepository.save(objet);
        } else {
            throw new ResourceNotFoundException("Objet not found with id " + id);
        }
    }
    public Objet patchObjet(int id, Map<String, Object> updates) {
        Optional<Objet> objetOptional = objetRepository.findById(id);
        if (objetOptional.isPresent()) {
            Objet objet = objetOptional.get();
            updates.forEach((key, value) -> {
                switch (key) {
                    case "nom":
                        if (value instanceof String) {
                            objet.setNom((String) value);
                        }
                        break;
                    case "description":
                        if (value instanceof String) {
                            objet.setDescription((String) value);
                        }
                        break;
                    case "valeur":
                        if (value instanceof Integer) {
                            objet.setValeur((Integer) value);
                        } else if (value instanceof Number) {
                            objet.setValeur(((Number) value).intValue());
                        }
                        break;
                    case "proprietaire":
                        if (value instanceof Utilisateur) {
                            objet.setProprietaire((Utilisateur) value);
                        }
                        break;
                    case "disponible":
                        if (value instanceof Boolean) {
                            objet.setDisponible((Boolean) value);
                        }
                        break;
                    default:
                        // Vous pouvez gérer des cas par défaut ici si nécessaire
                        break;
                }
            });
            return objetRepository.save(objet);
        } else {
            throw new ResourceNotFoundException("Objet not found with id " + id);
        }
    }
    @Transactional
    public boolean deleteObjetById(int id) {
        try {
            // Récupération de l'objet à supprimer
            Objet objetToDelete = this.getObjectById(id);
            if (objetToDelete == null) {
                throw new IllegalArgumentException("Objet introuvable avec l'ID : " + id);
            }
            List<ObjetEchange> listObjetEchange = this.objetEchangeRepository.findByObjet_id(objetToDelete.getId());

            // Suppression des ObjetEchange et PropositionEchange associés
            for (ObjetEchange objetEchange : listObjetEchange) {
                Optional<PropositionEchange> optionalPropositionEchange = this.propositionEchangeRepository.findById(objetEchange.getId());
                if (!optionalPropositionEchange.isPresent()) {
                    throw new IllegalArgumentException("PropositionEchange introuvable avec l'ID : " + objetEchange.getId());
                }
                PropositionEchange propositionEchange = optionalPropositionEchange.get();
                this.propositionEchangeRepository.delete(propositionEchange);
                this.objetEchangeRepository.delete(objetEchange);
            }
            this.objetRepository.delete(objetToDelete);
            return true;

        } catch (Exception e) {
            System.err.println("Erreur lors de la suppression de l'objet avec l'ID : " + id + " - " + e.getMessage());
            throw e;
        }
    }


}
