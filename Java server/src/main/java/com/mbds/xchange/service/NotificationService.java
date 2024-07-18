package com.mbds.xchange.service;

import com.mbds.xchange.model.Notification;
import com.mbds.xchange.repository.NotificationRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    @Transactional
    public void markNotificationAsSeen(int notificationId) {
        try {
            Notification notification = notificationRepository.findById(notificationId)
                    .orElseThrow(() -> new IllegalArgumentException("Notification introuvable avec l'id : " + notificationId));

            notification.setVu(true);
            notificationRepository.save(notification);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Notification introuvable avec l'id : " + notificationId, ex);
        } catch (Exception ex) {
            throw new RuntimeException("Une erreur s'est produite lors du marquage de la notification comme vue", ex);
        }
    }
}
