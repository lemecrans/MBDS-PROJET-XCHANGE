package com.mbds.xchange.repository;

import com.mbds.xchange.model.Objet;
import com.mbds.xchange.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjetRepository extends JpaRepository<Objet, Integer> {
    List<Objet> findByProprietaire(Utilisateur proprietaire);
}

