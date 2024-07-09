package com.mbds.xchange.service;

import com.mbds.xchange.model.Objet;
import com.mbds.xchange.repository.ObjetRepository;
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
    public ObjetService(ObjetRepository objetRepository) {
        this.objetRepository = objetRepository;
    }

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
}
