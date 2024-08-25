package com.mbds.xchange.service;

import com.mbds.xchange.model.Chat;
import com.mbds.xchange.model.Message;
import com.mbds.xchange.model.Utilisateur;
import com.mbds.xchange.repository.ChatRepository;
import com.mbds.xchange.repository.UtilisateurRepository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    @Autowired
    private ChatRepository reposi;
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Chat get(int user1, int user2) throws Exception {
        try {
            Utilisateur desti= utilisateurRepository.findById(user2);
            Utilisateur send= utilisateurRepository.findById(user1);
            return reposi.findBySenderAndDesti(desti,send );
        } catch (Exception e) {
            throw new Exception("Une erreur s'est produite : " + e.getMessage());
        }
    }

    public List<Chat> getAll(int user1) throws Exception {
        try {
            Utilisateur send= utilisateurRepository.findById(user1);
            List<Chat> lista = reposi.findByDesti(send );
            lista.addAll(reposi.findBySender(send));
            return lista;
        } catch (Exception e) {
            throw new Exception("Une erreur s'est produite : " + e.getMessage());
        }
    }

    public Chat Start(int user1, int user2) throws Exception{
        try{
            Utilisateur desti= utilisateurRepository.findById(user2);
            Utilisateur send= utilisateurRepository.findById(user1);
            Chat newchat= new Chat(send, desti,new ArrayList<Message>());
            return reposi.insert(newchat);
        }catch(Exception e){
            throw new Exception("Une erreur s'est produit : "+e);
        }
    }
    
    public Chat send(int sender, int recepient, String message) throws Exception {
        Chat currentChat;
        try {
            Utilisateur desti= utilisateurRepository.findById(recepient);
            Utilisateur send= utilisateurRepository.findById(sender);
            currentChat = reposi.findBySenderAndDesti(send,desti );
            if (currentChat == null) {
                currentChat = reposi.findBySenderAndDesti(desti,send );
                if (currentChat == null) {
                    currentChat = this.Start(sender, recepient);
                }
            }
            Message newMessage = new Message(send, message);
            List<Message> current = currentChat.getDiscussion();
            current.add(newMessage);
            currentChat.setDiscussion(current);
            return reposi.save(currentChat);
        } catch (Exception e) {
            throw new Exception("Une erreur s'est produite : " + e.getMessage());
        }
    }
}
