package com.mbds.xchange.repository;

import com.mbds.xchange.model.ObjetEchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjetEchangeRepository extends JpaRepository<ObjetEchange, Integer> {
}
