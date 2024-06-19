package com.example.newprojet.controller;

import com.example.newprojet.model.Utilisateur;
import com.example.newprojet.repository.UtilisateurRepository;
import com.example.newprojet.service.UtilisateurServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/utilisateur")
@CrossOrigin("*")
public class UtilisateurController {

    @Autowired
    public UtilisateurServiceInterface utilisateurServiceInterface;

    @Autowired
    public UtilisateurRepository utilisateurRepository;

    @PostMapping(path = "/login")
    public Utilisateur Login (@RequestBody Utilisateur util) {

        Utilisateur util1  = utilisateurRepository.getUtilisateurByEmailAndPassword(util.getEmail(),util.getPassword());

        if (util1!=null) {

            System.out.println("Login avec succè");
            return util1;
        } else {
            System.out.println("erreur de connection");
            return null;
        }

    }
    @GetMapping("/findAllUtilisateur")
    public List<Utilisateur> findAllUtilisateur(){
        return utilisateurServiceInterface.findAllUtilisateur();
    }
    @GetMapping("/findById/{id}")
    public Utilisateur findById(@PathVariable Long id){
        return utilisateurServiceInterface.findById(id);
    }
    @PostMapping("/addUtilisateur")
    public Utilisateur addUtilisateur(Utilisateur utilisateur, @RequestParam MultipartFile file){
        return utilisateurServiceInterface.addUtilisateur(utilisateur,file);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        utilisateurServiceInterface.deleteUtilisateur(id);
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        return utilisateurServiceInterface.getFile(filename);
    }
}
