package com.mbds.xchange.service;

import com.mbds.xchange.model.Objet;
import com.mbds.xchange.repository.ObjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
