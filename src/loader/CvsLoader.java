//
// class CvsLoader charge un fichier csv et extrait les travailleurs
package loader;

import static Logger.TestLogger.loggeur;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.LinkedList;
import java.util.logging.Level;
import model.Travailleur;

public class CvsLoader {

    /**
     * Load a cvs file, parse it and create a list of Travailleur
     *
     * @param fileName : path & name of the cvs file
     * @return : the list of Travailleur
     */
    public static LinkedList<Travailleur> load(String fileName) {
        //LinkedList<Travailleur> lt = new LinkedList<>();
        // todo code to load the list
        Logger.TestLogger.loggeur.setLevel(Level.WARNING);
    loggeur.log(Level.INFO, "imports inutilisés");
        return loadTest();
    }

    /**
     * Caution : test purpoes only Load an hard coded list of Travailleur.
     *
     * @return a list of Travailleur
     */
    public static LinkedList<Travailleur> loadTest() {
        LinkedList<Travailleur> lt = new LinkedList<>();
        lt.add(new Travailleur("Durant", "Jean", "023158762"));
        lt.add(new Travailleur("Damians", "Soda", "012365478"));
        lt.add(new Travailleur("Duke", "John", "01485478"));
        lt.add(new Travailleur("Dupont", "Marie", "012365478"));
        return lt;
    }

    /**
     * Caution : test purpoes only load a list of Travailleur from a test file
     * (file deployed by the program)
     *
     * @return a list of Travailleur
     */
    public static LinkedList<Travailleur> loadTestFile() {
        LinkedList<Travailleur> lt = new LinkedList<>();
        try {
            File f = new File("Travailleur.csv");
            if (f.exists()) {
                FileInputStream flux = new FileInputStream(f);
                InputStreamReader lecture = new InputStreamReader(flux);
                try (BufferedReader buff = new BufferedReader(lecture)) {
                    String ligne;
                    buff.readLine(); // lit la première ligne : header
                    while ((ligne = buff.readLine()) != null) {
                        String[] tabFields = ligne.split(";");
                        lt.add(new Travailleur(tabFields[0], tabFields[1], tabFields[2]));
                    }
                }
            } else {
                loggeur.log(Level.INFO, "ce fichier n'existe pas");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return lt;
    }

    /**
     * use it only to test the class
     *
     * @param args
     */
    public static void main(String[] args) {
        //programLoader();
        /*LinkedList<Travailleur> list = loadTest();
        for (Travailleur t : list) {
            //System.out.println(t.getNom());
        }*/
        
        System.out.println("\n");
        LinkedList<Travailleur> list = loadTestFile();
        list.stream().forEach((t) -> {
            System.out.println(t.getNom());
        });
    }

    private static void programLoader() {
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
                    listTravailleur.stream().forEach((t) -> {
                        System.out.println(t.getNom());
                    });
                }
            } else {
                loggeur.log(Level.INFO, "ce fichier n'existe pas");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}
