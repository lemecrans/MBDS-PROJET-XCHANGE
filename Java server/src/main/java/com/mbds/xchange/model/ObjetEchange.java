package com.mbds.xchange.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "ObjetEchange")
public class ObjetEchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "proposition_id", nullable = false)
    private PropositionEchange proposition;

    @ManyToOne
    @JoinColumn(name = "objet_id", nullable = false)
    private Objet objet;

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PropositionEchange getProposition() {
        return proposition;
    }

    public void setProposition(PropositionEchange proposition) {
        this.proposition = proposition;
    }

    public Objet getObjet() {
        return objet;
    }

    public void setObjet(Objet objet) {
        this.objet = objet;
    }

}
