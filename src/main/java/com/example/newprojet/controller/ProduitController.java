package com.example.newprojet.controller;

import com.example.newprojet.model.Produit;
import com.example.newprojet.service.ProduitServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/produit")
@CrossOrigin("*")
public class ProduitController {

    @Autowired
    public ProduitServiceInterface produitServiceInterface;
    @GetMapping("/findAllProduit")
    public List<Produit> findAllProduit(){
        return produitServiceInterface.findAllProduit();
    }
    @GetMapping("/findById/{id}")
    public Produit findById(@PathVariable Long id){
        return produitServiceInterface.findById(id);
    }
    @PostMapping("/addProduit")
    public Produit addProduit(Produit produit, @RequestParam MultipartFile file){
        return produitServiceInterface.addProduit(produit,file);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        produitServiceInterface.deleteProduit(id);
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        return produitServiceInterface.getFile(filename);
    }
}
