package com.mbds.xchange.repository;

import com.mbds.xchange.model.Objet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjetRepository extends JpaRepository<Objet, Integer> {

}

