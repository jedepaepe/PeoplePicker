//
// class CvsLoader charge un fichier csv et extrait les travailleurs
package loader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.LinkedList;
import model.Travailleur;

public class CvsLoader {
    
    /**
     * Load a cvs file, parse it and create a list of Travailleur
     * @param fileName : path & name of the cvs file
     * @return : the list of Travailleur
     */
    public static LinkedList<Travailleur> load(String fileName) {
        LinkedList<Travailleur> lt = new LinkedList<>();
        // todo code to load the list
        return lt;
    }
    
    /**
     * Caution : test purpoes only
     * Load an hard coded list of Travailleur.
     * @return a list of Travailleur
     */
    public static LinkedList<Travailleur> loadTest() {
        LinkedList<Travailleur> lt = new LinkedList<>();
        lt.add(new Travailleur("Durant", "Jean", "023158762"));
        // todo code to return a hard coded list
        return lt;        
    }
    
    /**
     * Caution : test purpoes only
     * load a list of Travailleur from a test file (file deployed by the program)
     * @return a list of Travailleur
     */
    public static LinkedList<Travailleur> loadTestFile() {
        LinkedList<Travailleur> lt = new LinkedList<>();
        // todo : load the list from a test file (file controlled by the program)
        return lt;
    }
    
    /**
     * use it only to test the class
     * @param args 
     */
    public static void main(String[] args) {
        try {
            File f = new File("Travailleur.csv");
            if (f.exists()) {
                FileInputStream flux = new FileInputStream(f);
                InputStreamReader lecture = new InputStreamReader(flux);
                try (BufferedReader buff = new BufferedReader(lecture)) {
                    String ligne;
                    LinkedList<Travailleur> listTravailleur = new LinkedList<>();
                    buff.readLine(); // lit la première ligne : header
                    while ((ligne = buff.readLine()) != null) {
                        String[] tabFields = ligne.split(";");
                        // attention, tabFields[2] - tel n'est pas un entier

                        listTravailleur.add(new Travailleur(tabFields[0], tabFields[1], tabFields[2]));
                    }

                    // code de vérification
                    /* Code avancé encore non vu au cours
                    listTravailleur.stream().forEach((t) -> {
                        System.out.println(t.getNom());
                    });*/
                    for(Travailleur t : listTravailleur) {
                        System.out.println(t.getNom());
                    }
                }
            } else {
                System.out.println("ce fichier n'existe pas");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}
