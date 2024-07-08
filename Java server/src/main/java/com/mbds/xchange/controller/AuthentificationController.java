package com.mbds.xchange.controller;

import com.mbds.xchange.configuration.JwtUtils;
import com.mbds.xchange.model.Utilisateur;
import com.mbds.xchange.repository.UtilisateurRepository;
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

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Utilisateur utilisateur) {
        if(utilisateurRepository.findByEmail(utilisateur.getEmail()) != null) {
            return ResponseEntity.badRequest().body("Ce compte est déjà utilisé");
        }
        utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
        return ResponseEntity.ok().body(utilisateurRepository.save(utilisateur));
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Utilisateur utilisateur) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(utilisateur.getEmail(), utilisateur.getPassword()));
            if(authentication.isAuthenticated()) {
                Map<String,Object> authData = new HashMap<>();
                authData.put("token", jwtUtils.generateToken(utilisateur.getEmail()));
                authData.put("token_type", "Bearer");
                return ResponseEntity.ok(authData);
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou mots de passe incorrect");
        }catch (AuthenticationException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou mots de passe incorrect");
        }
    }

}
