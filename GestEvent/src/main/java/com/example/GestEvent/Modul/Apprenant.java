package com.example.GestEvent.Modul;

import javax.persistence.*;

@Entity
public class Apprenant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idApprenant;
    @OneToOne
    @JoinColumn(name="idUser")
    private Users idusers;

    @ManyToOne
    @JoinColumn(name="idSpecialite")
    private Specialite idSpecialite;

    public Apprenant() {
    }

    public Apprenant(int idApprenant, Users idUsers, Specialite idSpecialite) {
        this.idApprenant = idApprenant;
        this.idusers = idUsers;
        this.idSpecialite = idSpecialite;
    }

    public Apprenant(Users idUsers, Specialite idSpecialite) {
        this.idusers = idUsers;
        this.idSpecialite = idSpecialite;
    }

    public int getIdApprenant() {
        return idApprenant;
    }

    public void setIdApprenant(int idApprenant) {
        this.idApprenant = idApprenant;
    }

    public Users getIdUsers() {
        return idusers;
    }

    public void setIdUsers(Users idUsers) {
        this.idusers = idUsers;
    }

    public Specialite getIdSpecialite() {
        return idSpecialite;
    }

    public void setIdSpecialite(Specialite idSpecialite) {
        this.idSpecialite = idSpecialite;
    }

    public void showApprenant() {
        System.out.println( "Apprenant{" +
                "idApprenant=" + idApprenant +
                ", idUsers=" + idusers +
                ", idSpecialite=" + idSpecialite +
                '}');
    }
}
