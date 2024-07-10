package com.mbds.xchange.repository;

import com.mbds.xchange.model.ObjetEchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjetEchangeRepository extends JpaRepository<ObjetEchange, Integer> {
    List<ObjetEchange> findByProposition_IdAndObjet_Proprietaire_Id(int propositionId, long proposantId);

}
