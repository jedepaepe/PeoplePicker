
package loader;

/**
 *
 * @author 2203allarreadelpozo
 */
public class Travailleur {

    /**
     * @return the count
     */
    public static int getCount() {
        return count;
    }
    private String nom, prenom, titre, departement, fonction, 
            mail, type, telephone, id;
    private static int count = 0;   //nr de travailleur

    public Travailleur(String Nom, String Prenom, String Titre,
            String Departement, String Fonction, String Mail, String Type, String Telephone, String Id) {
        setNom(Nom);
        this.prenom = Prenom;
        this.titre = Titre;
        this.departement = Departement;
        this.fonction = Fonction;
        this.mail = Mail;
        this.type = Type;
        this.telephone = Telephone;
        this.id = Id;
        Travailleur.count++;
    }

    /**
     * @return the Nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param Nom the Nom to set
     */
    public void setNom(String Nom) {
        // vérification de la sémantique à ajouter
        this.nom = Nom;
    }

    /**
     * @return the Prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param Prenom the Prenom to set
     */
    public void setPrenom(String Prenom) {
        this.prenom = Prenom;
    }

    /**
     * @return the Titre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * @param Titre the Titre to set
     */
    public void setTitre(String Titre) {
        this.titre = Titre;
    }

    /**
     * @return the Departement
     */
    public String getDepartement() {
        return departement;
    }

    /**
     * @param Departement the Departement to set
     */
    public void setDepartement(String Departement) {
        this.departement = Departement;
    }

    /**
     * @return the Fonction
     */
    public String getFonction() {
        return fonction;
    }

    /**
     * @param Fonction the Fonction to set
     */
    public void setFonction(String Fonction) {
        this.fonction = Fonction;
    }

    /**
     * @return the Mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param Mail the Mail to set
     */
    public void setMail(String Mail) {
        this.mail = Mail;
    }

    /**
     * @return the Type
     */
    public String getType() {
        return type;
    }

    /**
     * @param Type the Type to set
     */
    public void setType(String Type) {
        this.type = Type;
    }

    /**
     * @return the Telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param Telephone the Telephone to set
     */
    public void setTelephone(String Telephone) {
        this.telephone = Telephone;
    }

    /**
     * @return the Id
     */
    public String getId() {
        return id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(String Id) {
        this.id = Id;
    }
}