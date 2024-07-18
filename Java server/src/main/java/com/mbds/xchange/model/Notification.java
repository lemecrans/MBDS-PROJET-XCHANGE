package com.mbds.xchange.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "Notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @NotNull(message = "L'ID de l'utilisateur ne peut pas être nul")
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

    @NotNull(message = "La date de la notification ne peut pas être nulle")
    private Date dateNotification;

    @NotBlank(message = "Le message de la notification ne peut pas être vide")
    @Size(max = 255, message = "Le message de la notification ne peut pas dépasser {max} caractères")
    @Column(length = 255)
    private String message;

    private boolean isVu;

    public Notification(){

    }
    public Notification(Utilisateur utilisateur, Date dateNotification, String message, boolean isVu) {
        this.utilisateur = utilisateur;
        this.dateNotification = dateNotification;
        this.message = message;
        this.isVu = isVu;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateNotification() {
        return dateNotification;
    }

    public void setDateNotification(Date dateNotification) {
        this.dateNotification = dateNotification;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isVu() {
        return isVu;
    }

    public void setVu(boolean vu) {
        isVu = vu;
    }
}

