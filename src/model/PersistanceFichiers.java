package model;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PersistanceFichiers {

    public static void main(String[] args)
            throws ClassNotFoundException, IOException {
        Travailleur[] il = new Travailleur[4];
        Travailleur t = new Travailleur("Louis", "iojhofa", "021234567");
        Travailleur t1 = new Travailleur("Igor", "mozgk", "021234455");
        Travailleur t2 = new Travailleur("Julien", "sht", "1");
        Travailleur t3 = new Travailleur("Pelagia", "zhhrh", "1");
        il[0] = t;
        il[1] = t1;
        il[2] = t2;
        il[3] = t3;

        // Create an output stream for file array.dat
        ObjectOutputStream output = 
                new ObjectOutputStream(new FileOutputStream("fichbin.txt", true));
        // Write arrays to the object output stream
        for(Travailleur trav : il) {
            output.writeObject(trav);
        }
        // Close the stream
        output.close();

        ObjectInputStream input = 
                new ObjectInputStream(new FileInputStream("fichbin.txt"));

        boolean check = true;
        while (check) {
            try {
                Travailleur arr = (Travailleur) input.readObject();
                System.out.println(arr.getNom());
            } catch (EOFException ex) {
                check = false;
            }
        }

         //for (Travailleur arr2 : arr)
        //  System.out.println(arr2);
        // Create an input stream for file array.dat
        // Display arrays

        /*for (int i = 0; i < newll.size(); i++) {
         System.out.print(newll.get(i));
         }*/
        // Close the stream
        input.close();
    }
}