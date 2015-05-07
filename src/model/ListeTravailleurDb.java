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
public class ListeTravailleurDb {

    static Logger trace = Logger.getLogger("PPLogger");
    static private LinkedList<Travailleur> list = new LinkedList<>();

    public static void add(Travailleur t) {
        // INSERT
    }

    public static void add(LinkedList<Travailleur> ts) {
        // INSERT
    }

    public static void remove(Travailleur t) {
        // DELETE (id!)
    }

    public static void update(Travailleur t) {
        // UPDATE (id!)
    }

    public static LinkedList<Travailleur> search(String nom) {
        // SELECT WHERE ...
        LinkedList<Travailleur> res = new LinkedList<>();
        Travailleur t = new Travailleur("Dupont", "T", "022222222");
        res.add(t);
        return res;
    }

    public static LinkedList<Travailleur> getAll() {
        // SELECT ...
        return search("");
    }

}
