/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import java.util.LinkedList;

/**
 *
 * @author localwsp
 */
public class Worker {

    private String name;
    private String surname;
    private String phone;
    

    public Worker() {
        this.name = "";
        this.surname = "";
        this.phone = "";
    }
    
    static public LinkedList tableauWorker()  {
        LinkedList <Worker> listWorker = new LinkedList <Worker>();
        Worker w = new Worker();
        w.setName("Dupont");
        w.setSurname("Gérard");
        w.setPhone("+3224567852");
        listWorker.add(w);
        w.setName("Durand");
        w.setSurname("Albert");
        w.setPhone("+3221114785");
        listWorker.add(w);
        w.setName("Manfroid");
        w.setSurname("Gérard");
        w.setPhone("+3228523699");
        listWorker.add(w);
        w.setName("Bol");
        w.setSurname("Maggy");
        w.setPhone("+3224455668");
        listWorker.add(w);
        w.setName("Dalors");
        w.setSurname("Homer");
        w.setPhone("+3224578236");
        listWorker.add(w);
        return listWorker ;
    }

    static int compareNom (String w1,Worker w2){   
        return (w1.compareTo(w2.name));
    };
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

}