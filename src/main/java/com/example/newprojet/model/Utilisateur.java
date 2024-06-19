package com.example.newprojet.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String civilite;
    private String age;
    private String activiterProfessionnel;
    private String codePostale;
    private String ville;
    private String email;
    private String password;
    private String role;
    public String image;


}
