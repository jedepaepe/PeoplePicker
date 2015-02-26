/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

/**
 *
 * @author localwsp
 */
public class ListeTravailleur {

    private LinkedList<Travailleur> list = new LinkedList<>();

    public ListeTravailleur() {
        try {
            load();
        } catch (ClassNotFoundException e) {
            System.out.println("Error " + e);
        }
    }

    private void load() throws ClassNotFoundException {
        // place code to load the fichebin.bin file
        //public static void load(String filename)
        try {
            ObjectInputStream input
                    = new ObjectInputStream(new FileInputStream("fichbin.txt"));
            boolean check = true;
            while (check) {
                try {
                    Travailleur arr = (Travailleur) input.readObject();
                    System.out.println(arr.getNom());
                    list.add(arr);
                } catch (EOFException ex) {
                    check = false;
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur" + e);
        }

    }

    private void save() throws IOException {
        // place code to save to fichebin.bin
        ObjectOutputStream output
                = new ObjectOutputStream(new FileOutputStream("fichbin.txt", true));
        // Write arrays to the object output stream
        for (Travailleur trav : list) {
            output.writeObject(trav);
        }
        // Close the stream
        output.close();

    }

    public void add(Travailleur t) throws IOException {
        // add t to the list
        list.add(t);
        save();
    }

    public void add(LinkedList<Travailleur> ts) throws IOException {
        // add the list ts to the list
        list.addAll(ts);
        save();
    }

    public void remove(Travailleur t) throws IOException {
        list.remove(t);
        save();
    }

    public void update(Travailleur t) {
        // manque d'identifiant
       /* String nom = t.getNom();
         String prenom = t.getPrenom();
         String tel = t.getTel();*/

    }

    public LinkedList<Travailleur> search(String nom) {
        // do a real search
        LinkedList<Travailleur> res = new LinkedList<>();
        for (Travailleur t : list) {
            if (t.getNom() == nom) {
                System.out.println("OK, on a le travailleur " + t);
                res.add(t);
            }
        }
        return res;
    }

    public LinkedList<Travailleur> getAll() {
        LinkedList<Travailleur> res = (LinkedList<Travailleur>) list.clone();
        return res;
    }

}
