package com.mbds.xchange.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mbds.xchange.model.Chat;
import com.mbds.xchange.model.Utilisateur;

import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends MongoRepository<Chat, String> {
    Chat findBySenderAndDesti(Utilisateur Sender, Utilisateur desti);
    List<Chat> findByDesti(Utilisateur desti);
    List<Chat> findBySender(Utilisateur Sender);
}
