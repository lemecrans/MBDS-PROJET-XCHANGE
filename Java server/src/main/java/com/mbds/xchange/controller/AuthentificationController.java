package com.mbds.xchange.controller;

import com.mbds.xchange.configuration.JwtUtils;
import com.mbds.xchange.model.Utilisateur;
import com.mbds.xchange.repository.UtilisateurRepository;
import com.mbds.xchange.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthentificationController {

    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;
    private final EmailService emailService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Utilisateur utilisateur) {
        if(utilisateurRepository.findByEmail(utilisateur.getEmail()) != null) {
            return ResponseEntity.badRequest().body("Ce compte est déjà utilisé");
        }
        utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));

        // Envoyer l'email de bienvenue
        emailService.sendSimpleMessage(utilisateur.getEmail(),utilisateur.getUsername());

        return ResponseEntity.ok().body(utilisateurRepository.save(utilisateur));
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Utilisateur utilisateur) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(utilisateur.getEmail(), utilisateur.getPassword()));
            if (authentication.isAuthenticated()) {
                Utilisateur loggedUser = utilisateurRepository.findByEmail(utilisateur.getEmail());
                loggedUser.setPassword(null);
                Map<String, Object> authData = new HashMap<>();
                authData.put("token", jwtUtils.generateToken(utilisateur.getEmail()));
                authData.put("token_type", "Bearer");
                authData.put("user", loggedUser);
                return ResponseEntity.status(HttpStatus.OK).body(authData);
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou mot de passe incorrect");
        } catch (AuthenticationException e) {
            log.error("Erreur d'authentification: {}", e.getMessage());
            // Renvoie d'une réponse 401 UNAUTHORIZED en cas d'exception liée à l'authentification
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou mot de passe incorrect");
        } catch (Exception e) {
            log.error("Erreur serveur: {}", e.getMessage());
            // Renvoie d'une réponse 500 INTERNAL SERVER ERROR pour toute autre exception inattendue
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur interne s'est produite, veuillez réessayer plus tard.");
        }
    }
}

