package com.mbds.xchange.service;

import com.mbds.xchange.configuration.ResourceNotFoundException;
import com.mbds.xchange.model.ObjetEchange;
import com.mbds.xchange.model.PropositionEchange;
import com.mbds.xchange.repository.ObjetEchangeRepository;
import com.mbds.xchange.repository.ObjetRepository;
import com.mbds.xchange.repository.PropositionEchangeRepository;
import com.mbds.xchange.repository.UtilisateurRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ObjetEchangeService {

    @Autowired
    private ObjetEchangeRepository objetEchangeRepository;

    @Autowired
    private PropositionEchangeRepository propositionEchangeRepository;

    @Autowired
    private ObjetRepository objetRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public ObjetEchange createObjetEchange(@Valid ObjetEchange objetEchange) {
        return objetEchangeRepository.save(objetEchange);
    }

    @Transactional(readOnly = false) // On rend la transaction non-lue seule pour permettre la modification
    public PropositionEchange switchProprietaire(int propositionId) {
        ObjetService objetService = new ObjetService(objetRepository,utilisateurRepository);

        PropositionEchange proposition = propositionEchangeRepository.findById(propositionId)
                .orElseThrow(() -> new ResourceNotFoundException("Proposition introuvable"));

        List<ObjetEchange> objetsDestinataire = objetEchangeRepository.findByProposition_IdAndObjet_Proprietaire_Id(propositionId, (int) proposition.getDestinataire().getId());
        if (objetsDestinataire.isEmpty()) {
            throw new IllegalStateException("Aucun objetEchange trouvé pour le destinataire dans la proposition avec l'ID : " + propositionId);
        }

        List<ObjetEchange> objetsProposant = objetEchangeRepository.findByProposition_IdAndObjet_Proprietaire_Id(propositionId, (int) proposition.getProposant().getId());
        if (objetsProposant.isEmpty()) {
            throw new IllegalStateException("Aucun objetEchange trouvé pour le proposant dans la proposition avec l'ID : " + propositionId);
        }

        for (ObjetEchange objet : objetsDestinataire) {
            objetService.changeProprietaire(objet.getObjet().getId(),(int) proposition.getProposant().getId());
        }

        for (ObjetEchange objet : objetsProposant) {
            objetService.changeProprietaire(objet.getObjet().getId(),(int) proposition.getDestinataire().getId());
        }
        proposition.setEtat("Validé");
        proposition = propositionEchangeRepository.save(proposition);
        return proposition;
    }

}
