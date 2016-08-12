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
public class Dossier {
    public static int nbDossier;
    private int idDossier;
    private String nomDossier;
    private String adresseDossier;
    public final static Dossier PAS_DE_DOSSIER = new Dossier(0, "-", "-");

    public Dossier(int idDossier, String nomDossier, String adresseDossier) {
        this.idDossier = idDossier;
        this.nomDossier = nomDossier;
        this.adresseDossier = adresseDossier;
        Dossier.nbDossier++;
    }
    public Dossier(String nomDossier, String adresseDossier) {
        this.idDossier = Dossier.nbDossier;
        this.nomDossier = nomDossier;
        this.adresseDossier = adresseDossier;
        Dossier.nbDossier++;
    }
    
    public int getId(){
        return this.idDossier;
    }
    
    public String details (){
        return "n°"+idDossier + " - "+nomDossier+"\n"+adresseDossier;
    }
    public boolean estSansDossier(){
        return this.equals(Dossier.PAS_DE_DOSSIER);
    }
}
