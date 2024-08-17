package com.mbds.xchange.dto;

import com.mbds.xchange.model.PropositionEchange;
import com.mbds.xchange.model.Utilisateur;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PropositionEchangeDTO  {

    private int id;
    private Utilisateur proposant;
    private Utilisateur destinataire;
    private Date dateProposition;
    private Float latitude;
    private Float longitude;
    private String etat;
    private List<ObjetEchangeDTO> objetsEchanges;

    public PropositionEchangeDTO(PropositionEchange proposition) {
        this.id = proposition.getId();
        this.proposant = proposition.getProposant();
        this.destinataire = proposition.getDestinataire();
        this.dateProposition = proposition.getDateProposition();
        this.latitude = proposition.getLatitude();
        this.longitude = proposition.getLongitude();
        this.etat = proposition.getEtat();
        this.objetsEchanges = proposition.getObjetsEchanges().stream()
                .map(ObjetEchangeDTO::new)
                .collect(Collectors.toList());
    }

    // Getters et Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Utilisateur getProposant() {
        return proposant;
    }

    public void setProposant(Utilisateur proposant) {
        this.proposant = proposant;
    }

    public Utilisateur getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(Utilisateur destinataire) {
        this.destinataire = destinataire;
    }

    public Date getDateProposition() {
        return dateProposition;
    }

    public void setDateProposition(Date dateProposition) {
        this.dateProposition = dateProposition;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public List<ObjetEchangeDTO> getObjetsEchanges() {
        return objetsEchanges;
    }

    public void setObjetsEchanges(List<ObjetEchangeDTO> objetsEchanges) {
        this.objetsEchanges = objetsEchanges;
    }
}

