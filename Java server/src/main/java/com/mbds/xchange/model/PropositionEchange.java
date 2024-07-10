package com.mbds.xchange.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "PropositionEchange")
public class PropositionEchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "proposant_id", nullable = false)
    private Utilisateur proposant;

    @ManyToOne
    @JoinColumn(name = "destinataire_id", nullable = false)
    private Utilisateur destinataire;

    @NotNull(message = "La date de proposition ne peut pas être nulle")
    @Temporal(TemporalType.DATE)
    @Column(name = "date_proposition")
    private Date dateProposition;

    @NotNull(message = "La latitude ne peut pas être nulle")
    private Float latitude;

    @NotNull(message = "La longitude ne peut pas être nulle")
    private Float longitude;

    @NotBlank(message = "L'état ne peut pas être vide")
    private String etat;

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
}

