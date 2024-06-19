package com.example.newprojet.service;

import com.example.newprojet.model.Utilisateur;
import com.example.newprojet.repository.UtilisateurRepository;
import com.example.newprojet.utils.StoregeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class UtilisateurServiceIClass implements UtilisateurServiceInterface {
    @Autowired
    public UtilisateurRepository utilisateurRepository;
    @Autowired
    public StoregeService storegeService;

    public List<Utilisateur> findAllUtilisateur(){
        return utilisateurRepository.findAll();
    }

    public Utilisateur addUtilisateur(Utilisateur utilisateur, MultipartFile file){
        String fileName=storegeService.CreateNameImage(file);
        storegeService.store(file,fileName);
        utilisateur.setImage(fileName);
        return utilisateurRepository.save(utilisateur);
    }
    public Utilisateur findById(Long id){
        return utilisateurRepository.findById(id).orElse(null);
    }
    public void deleteUtilisateur(Long id){
        utilisateurRepository.deleteById(id);
    }
    public ResponseEntity<Resource> getFile(String filename) {
        Resource file = storegeService.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);

}
}
