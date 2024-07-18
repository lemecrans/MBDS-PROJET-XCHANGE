package com.mbds.xchange.controller;

import com.mbds.xchange.repository.NotificationRepository;
import com.mbds.xchange.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {
    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PutMapping("/{notificationId}/mark-as-seen")
    public ResponseEntity<String> markNotificationAsSeen(@PathVariable int notificationId) {
        try {
            notificationService.markNotificationAsSeen(notificationId);
            return ResponseEntity.ok("Notification marquée comme vue avec succès");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Notification introuvable avec l'id : " + notificationId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur s'est produite lors du marquage de la notification comme vue");
        }
    }
}
