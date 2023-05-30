package com.charge.charge.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Entity
@Table(name = "charges")

public class Charge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    //@Size(min=3 ,max = 20)
    private String title;
    private double montant;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
   //@PastOrPresent
    private LocalDate dateDernierDelai;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
   // @PastOrPresent
    private LocalDate datePaiement;
    private String observation;
    @ManyToOne
    @JoinColumn(name = "famille_id")
    private Famille famille;

    public Charge(){

    }

    @Override
    public String toString() {
        return "Charge{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", montant=" + montant +
                ", dateDernierDelai=" + dateDernierDelai +
                ", datePaiement=" + datePaiement +
                ", observation='" + observation + '\'' +
                ", famille=" + famille +
                '}';
    }

    public void setFamille(Famille famille) {
        this.famille = famille;
    }

    public Charge(int id, String title, double montant, LocalDate dateDernierDelai, LocalDate datePaiement, String observation, Famille famille) {
        this.id = id;
        this.title = title;
        this.montant = montant;
        this.dateDernierDelai = dateDernierDelai;
        this.datePaiement = datePaiement;
        this.observation = observation;
        this.famille = famille;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public LocalDate getDateDernierDelai() {
        return dateDernierDelai;
    }

    public void setDateDernierDelai(LocalDate dateDernierDelai) {
        this.dateDernierDelai = dateDernierDelai;
    }

    public LocalDate getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(LocalDate datePaiement) {
        this.datePaiement = datePaiement;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}
