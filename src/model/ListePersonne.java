/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.InputStream;
import java.util.LinkedList;

/**
 *
 * @author localwsp
 */
public class ListePersonne {
    
    private LinkedList<Travailleur> list = new LinkedList<>();

    public ListePersonne() {
        load();
    }

    
    void load() {
        // place code to load the fichebin.bin file
        //public static void load(String filename)
        InputStream inputstream=ListePersonne.class.getResourceAsStream("fichbin.txt");
    }
    
    void save() {
        // place code to save to fichebin.bin
    }
    
    void add(Travailleur t) {
        // add t to the list
    }
    
    LinkedList<Travailleur> search(String nom) {
        return list;
    }
    
}
