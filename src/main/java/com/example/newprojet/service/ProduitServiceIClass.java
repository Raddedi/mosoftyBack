package com.example.newprojet.service;

import com.example.newprojet.model.Produit;
import com.example.newprojet.repository.ProduitRepository;
import com.example.newprojet.utils.StoregeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ProduitServiceIClass implements ProduitServiceInterface {
    @Autowired
    public ProduitRepository produitRepository;
    @Autowired
    public StoregeService storegeService;

    public List<Produit> findAllProduit(){
        return produitRepository.findAll();
    }

    public Produit addProduit(Produit produit, MultipartFile file){
        String fileName=storegeService.CreateNameImage(file);
        storegeService.store(file,fileName);
        produit.setImage(fileName);
        return produitRepository.save(produit);
    }
    public Produit findById(Long id){
        return produitRepository.findById(id).orElse(null);
    }
    public void deleteProduit(Long id){
        produitRepository.deleteById(id);
    }
    public ResponseEntity<Resource> getFile(String filename) {
        Resource file = storegeService.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);

}
}
