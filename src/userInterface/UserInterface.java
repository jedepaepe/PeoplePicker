/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author localwsp
 */
public class UserInterface {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList <Worker> listWorker = Worker.tableauWorker() ;
        
        System.out.println(
                "Sur quoi voulez vous faire la recherche? (1: Prenom, 2:Nom, 3: Telephone");
        int reponse = sc.nextInt();
        switch (reponse) {
            case 1: {
                System.out.println("Prenom: ");
                String prenom = sc.nextLine();
                
                if (Worker.compareNom(prenom, null) == 0) {
                    System.out.println("trouvé");
                };
                break;
            }
            case 2: {
                System.out.println("Nom: ");
                String nom = sc.nextLine();
                break;
            }
            case 3: {
                System.out.println("Telephone: ");
                String telephone = sc.nextLine();
                break;
            }
            default: {
                System.err.println("Erreur");
            }
        }        
    }
}