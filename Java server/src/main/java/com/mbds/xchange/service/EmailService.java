package com.mbds.xchange.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender emailSender;

    @Autowired
    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendSimpleMessage(String to, String username) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Bienvenue");
        message.setText("Cher " + username + ",\n\n"
                + "Bienvenue sur XChange ! Nous sommes ravis de vous accueillir parmi nous. "
                + "XChange est une plateforme dédiée à l'échange d'objets, où vous pourrez échanger vos objets avec ceux d'autres utilisateurs facilement!\n\n"
                + "Ce que vous pouvez faire sur XChange :\n"
                + "- Voir les objets des utilisateurs : Parcourir la liste des objets disponibles pour échange des utilisateurs.\n"
                + "- Proposer des échanges : Proposer des échanges avec les objets des autres utilisateurs.\n"
                + "- Echanger avec les utilisateurs : Discuter avec les utilisateurs pour faciliter les échanges.\n\n"
                + "N'hésitez pas à commencer à explorer XChange dès maintenant !\n\n"
                + "Si vous avez des questions ou avez besoin d'assistance, n'hésitez pas à nous contacter via l'adresse support@xchange.com.\n\n"
                + "Bienvenue encore une fois sur XChange !\n\n"
                + "Cordialement,\n"
                + "L'équipe XChange");
        emailSender.send(message);
    }
}
