/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soleilplus.metier;

/**
 *
 * @author DL.C03
 */
public class Salarie {
    /** nom du salarie */
    private String nom;
    /** prenom du salarie */
    private String prenom;
    
    /**
     * Constructeur basique
     * @param nom
     * @param prenom 
     */
    public Salarie(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
    
    /**
     * get nom
     * @return String nom
     */
    public String getNom() {
        return nom;
    }
    /**
     * get prenom
     * @return String prenom
     */
    public String getPrenom() {
        return prenom;
    }
    /**
     * set nom
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * set nom
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

}
