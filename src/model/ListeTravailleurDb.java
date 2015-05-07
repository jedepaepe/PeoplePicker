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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
    static boolean isConnected;
    static Connection con;

    private static void connect() {
        if (!isConnected) {
            try {
                isConnected = true;
                Class mysqlDriver = Class.forName("com.mysql.jdbc.Driver");
                mysqlDriver.newInstance();
                con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/PeoplePicker?zeroDateTimeBehavior=convertToNull",
                        "root", "");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ListeTravailleurDb.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(ListeTravailleurDb.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ListeTravailleurDb.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ListeTravailleurDb.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void add(Travailleur t) {
        // INSERT
        connect();
    }

    public static void add(LinkedList<Travailleur> ts) {
        // INSERT
        connect();
    }

    public static void remove(Travailleur t) {
        // DELETE (id!)
        connect();
    }

    public static void update(Travailleur t) {
        // UPDATE (id!)
        connect();
    }

    public static LinkedList<Travailleur> search(String nom) {
        // SELECT WHERE ...
        connect();

        LinkedList<Travailleur> res = new LinkedList<>();
        Travailleur t = new Travailleur("Dupont", "T", "022222222");
        res.add(t);
        return res;
    }

    public static LinkedList<Travailleur> getAll() {
        connect();

        // SELECT ...
        return search("");
    }

}
