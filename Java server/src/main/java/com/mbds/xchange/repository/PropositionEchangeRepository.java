package com.mbds.xchange.repository;

import com.mbds.xchange.model.PropositionEchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PropositionEchangeRepository extends JpaRepository<PropositionEchange, Integer> {

    Optional<PropositionEchange> findById(Integer id);
}

