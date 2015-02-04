//
// class CvsLoader charge un fichier csv et extrait les travailleurs

package loader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class CvsLoader {

    public static void main(String[] args) {
        try {
            InputStream flux = new FileInputStream("Travailleur.csv");
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader buff = new BufferedReader(lecture);
            String ligne;
            LinkedList<Travailleur> listTravailleur = new LinkedList<>();
            buff.readLine();    // lit la première ligne : header
            while ((ligne = buff.readLine()) != null) {
                String[] tabFields = ligne.split(";");
                // attention, tabFields[3] (actif) n'est pas implémenté par Travailleur
                listTravailleur.add(new Travailleur(tabFields[0], 
                        tabFields[1], tabFields[2], tabFields[4], 
                        tabFields[5], tabFields[6], tabFields[7], 
                        tabFields[8], tabFields[9]));
            }
            
            // code de vérification
            for(Travailleur t : listTravailleur) {
                System.out.println(t.getNom());
            }

            buff.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}
