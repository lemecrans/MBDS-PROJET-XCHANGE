package com.mbds.tpt_android.Domains;

public class ObjectsDomain {
    private String id;
    private String nom;
    private String description;
    private String valeur;
    private String proprietaire;
    private Boolean disponible;
    private String image;

    public ObjectsDomain(){

    }

    public ObjectsDomain(String nom, String description, String proprietaire) {
        this.nom = nom;
        this.description = description;
        this.proprietaire = proprietaire;
    }

    public ObjectsDomain(String id, String nom, String description, String valeur, String proprietaire, Boolean disponible) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.valeur = valeur;
        this.proprietaire = proprietaire;
        this.disponible = disponible;
    }

    public ObjectsDomain(String id, String nom, String description, String valeur, String proprietaire, Boolean disponible, String image) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.valeur = valeur;
        this.proprietaire = proprietaire;
        this.disponible = disponible;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
