package com.mbds.xchange.service;

import com.mbds.xchange.model.Utilisateur;
import com.mbds.xchange.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UtilisateurService {
    
    private final UtilisateurRepository utilisateurRepository;
    private final RatingService ratingService;
    public Utilisateur getUser(int id) throws Exception{
        try{
            return utilisateurRepository.findById(id);
        }catch(Exception e){
            throw new Exception("Une erreur s'est produit : "+e);
        }
    }
    public int DeleteUser(int id) throws Exception{
        try{
            if(utilisateurRepository.findById(id)!=null){
                ratingService.DeleteRate(utilisateurRepository.findById(id));
                utilisateurRepository.deleteById((long) id);
                return 0;
            }else{
                return 1;
            }
        }catch(Exception e){
            throw new Exception("Une erreur s'est produit : "+e);
        }
    }
    
}
