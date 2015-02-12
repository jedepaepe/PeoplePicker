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
public class ListeTravailleur {
    
    private LinkedList<Travailleur> list = new LinkedList<>();

    public ListeTravailleur() {
        load();
    }
    
    private void load() {
        // place code to load the fichebin.bin file
        //public static void load(String filename)
        InputStream inputstream=ListeTravailleur.class.getResourceAsStream("fichbin.txt");
    }
    
    private void save() {
        // place code to save to fichebin.bin
    }
    
    public void add(Travailleur t) {
        // add t to the list
        save();
    }
    
    public void add(LinkedList<Travailleur> ts) {
        // add the list ts to the list
        save();
    }
    
    public void remove(Travailleur t) {
        
    }
    
    public void update(Travailleur t) {
        
    }
    
    public LinkedList<Travailleur> search(String nom) {
        // todo add search
        return (LinkedList<Travailleur>) list.clone();
    }
    
    public LinkedList<Travailleur> getAll() {
        return (LinkedList<Travailleur>) list.clone();
    }
    
}
