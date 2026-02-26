package com.accenture.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@ToString
public class Client {

    @Id
    private int id;

    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String password;
    private String dateDeNaissance;
    private String dateInscription;
    private List<String> listeDesPermis;
    private boolean desactive;
}
