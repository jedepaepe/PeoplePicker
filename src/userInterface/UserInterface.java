/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;
import loader.*;
import model.*;

/**
 *
 * @author localwsp
 */
public class UserInterface { 

    /**
     * Start point of the PeoplePicker
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        LinkedList<model.Travailleur> listWorker= new LinkedList<model.Travailleur> () ;
        
        System.out.println(args.length);
        if(args.length == 2) {
            File f = new File(args[1]);
            if(f.exists()) {
                switch (args[0]) {
                    case "L": {
                        listWorker = loader.CvsLoader.load(args[1]);                        
                        
                        System.out.println("case L");
                        break;
                    }
                    case "S": {
                        System.out.println("case L");
                        /*
                        System.out.println(
                                "Sur quoi voulez vous faire la recherche? (1: Prenom, 2:Nom, 3: Telephone");
                        int reponse = sc.nextInt();
                        userInterface.UISearch.searchTrav(reponse);
                        */
                    }
                }
            } else {
                System.out.println("file doesn't exists");
                System.exit(1);
            }
        } else {
            System.out.println("invalid arguments");
            System.exit(1);
        }
        
        /*
        Scanner sc = new Scanner(System.in);

        System.out.println("Voulez-vous charger un fichier (L) ou rechercher des données (S) ? ");
        String rep = sc.next();
        switch (rep) {
            case "L": {
                userInterface.ReadFileUsingJFileChooser.main(args);
                break;
            }
            case "S": {
                System.out.println(
                        "Sur quoi voulez vous faire la recherche? (1: Prenom, 2:Nom, 3: Telephone");
                int reponse = sc.nextInt();
                userInterface.UISearch.searchTrav(reponse);
            }
        }
        */
    }
}