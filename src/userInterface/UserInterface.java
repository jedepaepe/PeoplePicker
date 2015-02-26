/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import model.*;

/**
 *
 * @author localwsp
 */
public class UserInterface {

    /**
     * Start point of the PeoplePicker
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        //LinkedList<model.Travailleur> listWorker = new LinkedList<model.Travailleur>();

        //ListeTravailleur listPushWorker = new ListeTravailleur();

        System.out.println(args.length);
        if (args.length == 1) {
            File f = fileChooser();  
            if (f.exists()) {
                switch (args[0]) {
                    case "L": {
                        loadCvsFile(f);  
                        break;
                    }
                    case "S": {
                        searchList();
                        break;
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

    private static void searchList() {
        System.out.println("case S");
        Scanner searchScan = new Scanner(System.in);
        String nomSearch = searchScan.nextLine();
        //la ligne suivante permet de faire la recherche si la method search est passée en static
        ListeTravailleur temp = new ListeTravailleur();
        LinkedList<Travailleur> resultat = temp.search(nomSearch);
        for (Travailleur wt : resultat) {
            System.out.println(wt.getPrenom());
            System.out.println(wt.getNom());
            System.out.println(wt.getTel());
        }
    }

    private static void loadCvsFile(File f) {
        LinkedList<Travailleur> lt = loader.CvsLoader.load(f.toString());
        for (Travailleur wt : lt) {
            System.out.println(wt.getPrenom());
        }
        // ajouter le add du model -> method non static pour le moment donc on instancie
        ListeTravailleur temp = new ListeTravailleur();
        temp.add(lt);
    }
    //permet d'ouvrir la fenetre de choix du fichier .csv
    private static File fileChooser() throws FileNotFoundException {
        JFileChooser fileChooser = new JFileChooser();

        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

            java.io.File file = fileChooser.getSelectedFile();

            Scanner input = new Scanner(file);

            input.close();
            return file;
        } else {
            System.out.println("No file selected");
        }
        return null;
    }

}
