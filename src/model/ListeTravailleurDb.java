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

    static Logger trace = Logger.getLogger("PPLogger");
    static private LinkedList<Travailleur> list = new LinkedList<>();


    private static void load() {
        // place code to load the fichebin.bin file
        //public static void load(String filename)
        try {
            ObjectInputStream input
                    = new ObjectInputStream(new FileInputStream("fichbin.txt"));
            boolean check = true;
            while (check) {
                try {
                    Travailleur arr = (Travailleur) input.readObject();
//                    System.out.println(arr.getNom());
                    list.add(arr);
                } catch (EOFException ex) {
                    check = false;
                    trace.log(Level.SEVERE, "Error {0}", ex);
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur" + e);
            trace.log(Level.SEVERE, "Error " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur" + e);
            trace.log(Level.SEVERE, "Error " + e); 
        }

    }

    private static void save() {
        // place code to save to fichebin.bin
        load();
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

    public static void add(Travailleur t) {
        // add t to the list
        load();
        try {
            list.add(t);
            save();
        } catch (Exception e) {
            trace.log(Level.ALL, "Error " + e);
        }
    }

    public static void add(LinkedList<Travailleur> ts) {
        // add the list ts to the list
        load();
        try {
            list.addAll(ts);
            save();
        } catch (Exception e) {
            trace.log(Level.ALL, "Error " + e);
        }
    }

    public static void remove(Travailleur t) {
        load();
        try {
            list.remove(t);
            save();
        } catch (Exception e) {
            trace.log(Level.ALL, "Error " + e);
        }
    }

    public static void update(Travailleur t) {
        load();
        // manque d'identifiant
       /* String nom = t.getNom();
         String prenom = t.getPrenom();
         String tel = t.getTel();*/

    }

    public static LinkedList<Travailleur> search(String nom) {
        // do a real search
        load();
        LinkedList<Travailleur> res = new LinkedList<>();
        try {
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
        return res;
    }

    public static LinkedList<Travailleur> getAll() {
        @SuppressWarnings("unchecked")            
        LinkedList<Travailleur> res = (LinkedList<Travailleur>) list.clone();
        return res;
    }

}
