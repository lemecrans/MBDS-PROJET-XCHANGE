package com.mbds.xchange.repository;

import com.mbds.xchange.model.Objet;
import com.mbds.xchange.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ObjetRepository extends JpaRepository<Objet, Integer> {
    List<Objet> findByProprietaire(Utilisateur proprietaire);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO objet (description, disponible, image, nom, proprietaire_id, valeur) VALUES (:description, :disponible, :image, :nom, :proprietaireId, :valeur)", nativeQuery = true)
    void insertObjet(String description, Boolean disponible, byte[] image, String nom, Long proprietaireId, Integer valeur);

}

