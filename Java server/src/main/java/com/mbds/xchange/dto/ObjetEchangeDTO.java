package com.mbds.xchange.dto;

import com.mbds.xchange.model.Objet;
import com.mbds.xchange.model.ObjetEchange;

public class ObjetEchangeDTO {

    private int id;
    private Objet objet; // ID de l'objet associé

    public ObjetEchangeDTO() {}

    public ObjetEchangeDTO(ObjetEchange objetEchange) {
        this.id = objetEchange.getId();
        this.objet = objetEchange.getObjet();
    }

    public Objet getObjet() {
        return objet;
    }

    public void setObjet(Objet objet) {
        this.objet = objet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

