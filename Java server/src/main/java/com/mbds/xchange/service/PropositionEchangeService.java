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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropositionEchangeService {
    @Autowired
    private PropositionEchangeRepository propositionEchangeRepository;

    @Autowired
    private ObjetEchangeRepository objetEchangeRepository;

    @Autowired
    private ObjetRepository objetRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Transactional
    public PropositionEchange createProposition(@Valid PropositionEchange propositionEchange, List<Integer> listeObjetIds, int destinataireId, int proposantId) {
        // Vérification si le destinataire existe
        Utilisateur destinataire = utilisateurRepository.findById(destinataireId);
        Utilisateur proposant = utilisateurRepository.findById(proposantId);
        // Assignation du destinataire à la proposition
        propositionEchange.setDestinataire(destinataire);
        // Assignation du destinataire à la proposition
        propositionEchange.setProposant(proposant);

        // Sauvegarde de la proposition
        PropositionEchange toCreate = propositionEchangeRepository.save(propositionEchange);

        // Création des objets d'échange
        for (Integer objetId : listeObjetIds) {
            Objet objet = objetRepository.findById(objetId)
                    .orElseThrow(() -> new ResourceNotFoundException("Objet inexistant"));

            ObjetEchange objetEchange = new ObjetEchange();
            objetEchange.setProposition(toCreate);
            objetEchange.setObjet(objet);

            objetEchangeRepository.save(objetEchange);
        }

        return toCreate;
    }
}
