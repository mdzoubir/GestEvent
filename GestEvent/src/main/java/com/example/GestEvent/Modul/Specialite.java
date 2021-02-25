package com.example.GestEvent.Modul;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Specialite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_specialite;
    private String nomSpecialite;

    public Specialite(Integer id_specialite, String nomSpecialite) {
        this.id_specialite = id_specialite;
        this.nomSpecialite = nomSpecialite;
    }

    public Specialite(String nomSpecialite) {
        this.nomSpecialite = nomSpecialite;
    }

    public Specialite() {
    }
    public int getId_specialite() {
        return id_specialite;
    }

    public void setId_specialite(int id) {
        this.id_specialite = id;
    }

    public String getNomSpecialite() {
        return nomSpecialite;
    }

    public void setNomSpecialite(String nomSpecialite) {
        this.nomSpecialite = nomSpecialite;
    }


    public void showSpecialite() {
        System.out.println("Specialite{" +
                "id_specialite=" + this.id_specialite +
                ", nomSpecialite='" + this.nomSpecialite + '\'' +
                '}'); ;
    }
}
