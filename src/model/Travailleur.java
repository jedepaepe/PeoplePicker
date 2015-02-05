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
    String Nom;
    String prenom;
    int tel;

    public Travailleur(String Nom, String prenom, int tel) {
        this.Nom = Nom;
        this.prenom = prenom;
        this.tel = tel;
    }
}