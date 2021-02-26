package com.example.GestEvent.Modul;

import javax.persistence.*;
@Entity
public class Formateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idFormatur;
    @OneToOne
    @JoinColumn(name="idUser")
    private Users idusers;
    @ManyToOne
    @JoinColumn(name="idSpecialite")
    private Specialite idSpecialite;

    public Formateur() {
    }

    public Formateur(Users idusers, Specialite idSpecialite) {
        this.idusers = idusers;
        this.idSpecialite = idSpecialite;
    }

    public Formateur(int idFormatur, Users idusers, Specialite idSpecialite) {
        this.idFormatur = idFormatur;
        this.idusers = idusers;
        this.idSpecialite = idSpecialite;
    }

    public int getIdFormatur() {
        return idFormatur;
    }

    public void setIdFormatur(int idFormatur) {
        this.idFormatur = idFormatur;
    }

    public Users getIdusers() {
        return idusers;
    }

    public void setIdusers(Users idusers) {
        this.idusers = idusers;
    }

    public Specialite getIdSpecialite() {
        return idSpecialite;
    }

    public void setIdSpecialite(Specialite idSpecialite) {
        this.idSpecialite = idSpecialite;
    }
}
