package model;


import java.io.Serializable;

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
    private int tel;

    public Travailleur(String Nom, String prenom, int tel) {
        if(this.Nom.length()>=2) {this.Nom= Nom;}  
        this.prenom = prenom;
        this.tel = tel;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    
}