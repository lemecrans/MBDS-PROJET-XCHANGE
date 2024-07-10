package com.mbds.xchange.service;

import com.mbds.xchange.model.ObjetEchange;
import com.mbds.xchange.repository.ObjetEchangeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjetEchangeService {

    @Autowired
    private ObjetEchangeRepository objetEchangeRepository;

    public ObjetEchange createObjetEchange(@Valid ObjetEchange objetEchange) {
        return objetEchangeRepository.save(objetEchange);
    }

}
