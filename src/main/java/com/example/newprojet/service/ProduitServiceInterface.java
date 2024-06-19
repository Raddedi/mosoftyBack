package com.example.newprojet.service;

import com.example.newprojet.model.Produit;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProduitServiceInterface {
     List<Produit> findAllProduit();
    Produit addProduit(Produit produit, MultipartFile file);

    Produit findById(Long id);
     void deleteProduit(Long id);
     ResponseEntity<Resource> getFile(String filename);
}
