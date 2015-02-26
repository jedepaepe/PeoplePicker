package model;


import java.io.Serializable;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author localwsp
 */
public class Travailleur implements Serializable{
    private static final long serialVersionUID = 6529685098267757690L;
    private String Nom;
    private String prenom;
    private String tel;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.Nom);
        hash = 23 * hash + Objects.hashCode(this.prenom);
        hash = 23 * hash + Objects.hashCode(this.tel);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Travailleur other = (Travailleur) obj;
        if (!Objects.equals(this.Nom, other.Nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.tel, other.tel)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Travailleur{" + "Nom=" + Nom + ", prenom=" + prenom + ", tel=" + tel + '}';
    }

    public Travailleur(String Nom, String prenom, String tel) {
        setNom(Nom);
        setPrenom(prenom);
        setTel(tel);
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        if(Nom.length() >= 0) {
            this.Nom= Nom;
        }
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
