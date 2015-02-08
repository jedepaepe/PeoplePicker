/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Véronique
 */
public class UISearch {

    static public LinkedList<model.Travailleur> loadTrav() {
        LinkedList<model.Travailleur> listTrav = null;
        listTrav.add(new model.Travailleur("Dupont", "Charles", "022222223"));
        listTrav.add(new model.Travailleur("Durant", "Georges", "023333333"));
        listTrav.add(new model.Travailleur("Duchant", "Albert", "024444444"));
        listTrav.add(new model.Travailleur("Dubois", "Alfred", "025555555"));
        return listTrav;
    }

    static public void searchTrav(int rep) {
        Scanner sc = new Scanner(System.in);
        switch (rep) {
            case 1: {
                System.out.println("Prenom: ");
                String prenom = sc.next();
                model.Travailleur trav = comparePrenom(prenom);
                if (trav != null) {
                    System.out.println("Trouvé travailleur sur prénom " + trav);
                }
                else    {
                    System.out.println("Erreur, ce prénom n'est pas dans la liste");
                }
                break;
            }
            case 2: {
                System.out.println("Nom: ");
                String nom = sc.next();
                model.Travailleur trav = compareNom(nom);
                if (trav != null)   {
                    System.out.println("Trouvé travailleur sur nom " + trav);
                }
                else    {
                    System.out.println("Erreur, ce nom n'est pas dans la liste");
                }
                break;
            }
            case 3: {
                System.out.println("Telephone: ");
                String telephone = sc.next();
                model.Travailleur trav = compareTel(telephone);
                if (trav != null)   {
                    System.out.println("Traouvé travailleur sur téléphone " + trav);
                }
                else    {
                    System.out.println("Erreur, ce téléphone n'est pas dans la liste");
                }
                break;
            }
            default: {
                System.err.println("Erreur, vous n'avez pas choisi une des options proposées");
            }
        }
    }

    static public model.Travailleur comparePrenom(String prenom) {
        LinkedList<model.Travailleur> listTrav = null;
        listTrav = loadTrav();
        for (int i = 0; i < listTrav.size(); i++) {
            model.Travailleur trav = listTrav.get(i);
            if (trav.getPrenom() == prenom) {
                return trav;
            }
        }
        model.Travailleur trav = null;
        return trav;
    }
    
    static public model.Travailleur compareNom(String nom) {
        LinkedList<model.Travailleur> listTrav = null;
        listTrav = loadTrav();
        for (int i = 0; i < listTrav.size(); i++) {
            model.Travailleur trav = listTrav.get(i);
            if (trav.getNom() == nom) {
                return trav;
            }
        }
        model.Travailleur trav = null;
        return trav;
    }
    
    static public model.Travailleur compareTel(String telephone) {
        LinkedList<model.Travailleur> listTrav = null;
        listTrav = loadTrav();
        for (int i = 0; i < listTrav.size(); i++) {
            model.Travailleur trav = listTrav.get(i);
            if (trav.getTel() == telephone) {
                return trav;
            }
        }
        model.Travailleur trav = null;
        return trav;
    }
}
