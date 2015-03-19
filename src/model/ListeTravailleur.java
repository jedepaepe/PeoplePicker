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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author localwsp
 */
public class ListeTravailleur {

    Logger trace = Logger.getLogger("PPLogger");
    private LinkedList<Travailleur> list = new LinkedList<>();

    public ListeTravailleur() {

        try {
            load();
        } catch (ClassNotFoundException e) {
            System.out.println("Error " + e);
            trace.log(Level.ALL, "Error " + e);

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
                    trace.log(Level.ALL, "Error " + ex);
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur" + e);
            trace.log(Level.ALL, "Error " + e);
        }

    }

    private void save() throws IOException {
        // place code to save to fichebin.bin
        try {
            ObjectOutputStream output
                    = new ObjectOutputStream(new FileOutputStream("fichbin.txt", true));
            try {
                for (Travailleur trav : list) {
                    // Write arrays to the object output stream
                    output.writeObject(trav);
                    try {
                        output.close();
                    } catch (Exception e) {
                        trace.log(Level.ALL, "Error " + e);
                    }
                }
            } catch (Exception e) {
                trace.log(Level.ALL, "Error " + e);
            }
        } catch (Exception e) {
            trace.log(Level.ALL, "Error " + e);
        }

        // Close the stream
    }

    public void add(Travailleur t) throws IOException {
        // add t to the list
        try {
            list.add(t);
            save();
        } catch (Exception e) {
            trace.log(Level.ALL, "Error " + e);
        }
    }

    public void add(LinkedList<Travailleur> ts) throws IOException {
        // add the list ts to the list
        try {
            list.addAll(ts);
            save();
        } catch (Exception e) {
            trace.log(Level.ALL, "Error " + e);
        }
    }

    public void remove(Travailleur t) throws IOException {
        try {
            list.remove(t);
            save();
        } catch (Exception e) {
            trace.log(Level.ALL, "Error " + e);
        }
    }

    public void update(Travailleur t) {
        // manque d'identifiant
       /* String nom = t.getNom();
         String prenom = t.getPrenom();
         String tel = t.getTel();*/

    }

    public LinkedList<Travailleur> search(String nom) {
        // do a real search
        try {
            LinkedList<Travailleur> res = new LinkedList<>();
            try {
                for (Travailleur t : list) {
                    if (t.getNom() == nom) {
                        System.out.println("OK, on a le travailleur " + t);
                        res.add(t);
                    }

                }
                return res;
            } catch (Exception e) {
                trace.log(Level.ALL, "Error " + e);
            }
        } catch (Exception e) {
            trace.log(Level.ALL, "Error " + e);
        }
        
    }

    public LinkedList<Travailleur> getAll() {
        @SuppressWarnings("unchecked")
        LinkedList<Travailleur> res = (LinkedList<Travailleur>) list.clone();
        return res;
    }

}
