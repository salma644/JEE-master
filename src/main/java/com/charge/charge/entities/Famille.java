package com.charge.charge.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "familles")
public class Famille {
    public static final String EXPLOITATION = "charges d'exploitation";
    public static final String FINANCIERES = "charges financières";
    public static final String EXCEPTIONNELLES = "charges exceptionnelles";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    //@NotNull
    private String nom;
    //@NotNull
    private String type;

    @OneToMany(mappedBy = "famille")
    private List<Charge> charges;
    public Famille(){

    }
    public Famille(int id, String nom, String type) {
        this.id = id;
        this.nom = nom;
        this.type = type;
    }

    public Famille(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
