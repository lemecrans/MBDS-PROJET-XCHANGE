package com.mbds.xchange.service;

import com.mbds.xchange.configuration.ResourceNotFoundException;
import com.mbds.xchange.model.*;
import com.mbds.xchange.repository.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    private NotificationRepository notificationRepository;

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

        Notification notif = new Notification(destinataire,new Date(),"Nouvelle proposition d'échange de la part de "+destinataire.getUsername(),false);
        notificationRepository.save(notif);

        return toCreate;
    }

    public List<PropositionEchange> getAllEchange(){
        return propositionEchangeRepository.findAll();
    }

    public Optional<PropositionEchange> getEchange(int id){
        return propositionEchangeRepository.findById(id);
    }
}
