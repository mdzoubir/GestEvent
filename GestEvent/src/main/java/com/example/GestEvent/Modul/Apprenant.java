package com.example.GestEvent.Modul;

import org.hibernate.mapping.Set;

import javax.persistence.*;

@Entity
public class Apprenant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idApprenant;
    @JoinColumn(name="idApprenant")
    private Users idUsers;
    private int idSpecialite;

    public Apprenant() {
    }

    public Apprenant(int idApprenant, Users idUsers, int idSpecialite) {
        this.idApprenant = idApprenant;
        this.idUsers = idUsers;
        this.idSpecialite = idSpecialite;
    }

    public Apprenant(Users idUsers, int idSpecialite) {
        this.idUsers = idUsers;
        this.idSpecialite = idSpecialite;
    }

    public int getIdApprenant() {
        return idApprenant;
    }

    public void setIdApprenant(int idApprenant) {
        this.idApprenant = idApprenant;
    }

    public Users getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(Users idUsers) {
        this.idUsers = idUsers;
    }

    public int getIdSpecialite() {
        return idSpecialite;
    }

    public void setIdSpecialite(int idSpecialite) {
        this.idSpecialite = idSpecialite;
    }
}
