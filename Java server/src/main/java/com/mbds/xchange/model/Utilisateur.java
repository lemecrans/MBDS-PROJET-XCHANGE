package com.mbds.xchange.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "utilisateurs")
@Data
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, length = 100, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String username;

    private String role;

    @Column(name = "nombre_de_notes", nullable = false)
    private int nombreDeNotes;
    @Column(name = "noteMoyenne", nullable = false)
    private double noteMoyenne = 0.0;

}
