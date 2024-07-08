package com.mbds.xchange.service;

import com.mbds.xchange.model.Utilisateur;
import com.mbds.xchange.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UtilisateurDetailService implements UserDetailsService {

    private final UtilisateurRepository utilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email);
        if(utilisateur == null) {
            throw new UsernameNotFoundException("Aucun utilisateur trouvé avec l'email : "+email);
        }
        return new User(utilisateur.getEmail(),utilisateur.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(utilisateur.getRole())));
    }
}
