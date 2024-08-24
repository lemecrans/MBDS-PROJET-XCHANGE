package com.mbds.xchange.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mbds.xchange.configuration.ResourceNotFoundException;
import com.mbds.xchange.model.Chat;
import com.mbds.xchange.model.Utilisateur;
import com.mbds.xchange.service.ChatService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
@Slf4j
public class ChatController {
    private final ChatService chatServ;
    @PostMapping("/start")
    public ResponseEntity<?> Start(@RequestParam int sender, @RequestParam int desti) {
        try {
            Chat currentChat = chatServ.Start(sender,desti);
            if(currentChat!=null){
                return ResponseEntity.ok(currentChat);
            }else{
                throw new ResourceNotFoundException("Aucun Utilisateur trouvé");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }
    @PostMapping("/get")
    public ResponseEntity<?> Get(@RequestParam int sender, @RequestParam int desti) {
        try {
            Chat currentChat = chatServ.get(sender,desti);
            if(currentChat!=null){
                return ResponseEntity.ok(currentChat);
            }else{
                throw new ResourceNotFoundException("Aucun Utilisateur trouvé");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }
    @PostMapping("/getall")
    public ResponseEntity<?> Getall(@RequestParam int sender) {
        try {
            List<Chat> currentChat = chatServ.getAll(sender);
            if(currentChat!=null){
                return ResponseEntity.ok(currentChat);
            }else{
                throw new ResourceNotFoundException("Aucun Utilisateur trouvé");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }
    @PostMapping("/send")
    public ResponseEntity<?> send(@RequestParam int sender, @RequestParam int desti, @RequestParam String message) {
        try {
            Chat currentChat = chatServ.send(sender,desti,message);
            if(currentChat!=null){
                return ResponseEntity.ok(currentChat);
            }else{
                throw new ResourceNotFoundException("Aucun Utilisateur trouvé");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }

}
