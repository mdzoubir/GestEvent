package com.example.GestEvent.Modul;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;

@Entity
public class Specialite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomSpecialite;

    public Specialite() {
    }

    public Specialite(String nomSpecialite) {
        this.nomSpecialite = nomSpecialite;
    }

    public Specialite(int id_specialite, String nomSpecialite) {
        this.id = id_specialite;
        this.nomSpecialite = nomSpecialite;
    }

    public int getId_specialite() {
        return id;
    }

    public void setId_specialite(int id_specialite) {
        this.id = id_specialite;
    }

    public String getNomSpecialite() {
        return nomSpecialite;
    }

    public void setNomSpecialite(String nomSpecialite) {
        this.nomSpecialite = nomSpecialite;
    }

    public void showSpecialite() {
        System.out.println("Specialite{" +
                "id_specialite=" + this.id +
                ", nomSpecialite='" + this.nomSpecialite + '\'' +
                '}'); ;
    }
}
