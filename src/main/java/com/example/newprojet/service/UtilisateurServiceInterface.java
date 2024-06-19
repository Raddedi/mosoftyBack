package com.example.newprojet.service;

import com.example.newprojet.model.Utilisateur;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UtilisateurServiceInterface {
     List<Utilisateur> findAllUtilisateur();
    Utilisateur addUtilisateur(Utilisateur utilisateur, MultipartFile file);

    Utilisateur findById(Long id);
     void deleteUtilisateur(Long id);
     ResponseEntity<Resource> getFile(String filename);
}
