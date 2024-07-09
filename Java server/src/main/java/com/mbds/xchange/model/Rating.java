package com.mbds.xchange.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ratings")
@Data
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utilisateur_evalue_id")
    private Utilisateur utilisateurEvalue;

    @ManyToOne
    @JoinColumn(name = "utilisateur_notant_id")
    private Utilisateur utilisateurNotant;

    private int note;
}
