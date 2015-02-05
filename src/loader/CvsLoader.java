//
// class CvsLoader charge un fichier csv et extrait les travailleurs
package loader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.io.File;

import model.Travailleur;

public class CvsLoader {

    public static void main(String[] args) {
        try {
            File f = new File("Travailleur.csv");
            if (f.exists()) {
                InputStream flux = new FileInputStream("Travailleur.csv");
                InputStreamReader lecture = new InputStreamReader(flux);
                try (BufferedReader buff = new BufferedReader(lecture)) {
                    String ligne;
                    LinkedList<Travailleur> listTravailleur = new LinkedList<>();
                    buff.readLine();
// lit la première ligne : header
                    while ((ligne = buff.readLine()) != null) {
                        String[] tabFields = ligne.split(";");
                        // attention, tabFields[2] - tel n'est pas un entier

                        listTravailleur.add(new Travailleur(tabFields[0], tabFields[1], tabFields[1]));
                    }

                    // code de vérification
                    listTravailleur.stream().forEach((t) -> {
                        System.out.println(t.getNom());
                    });
                }
            } else {
                System.out.println("ce fichier n'existe pas");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}
