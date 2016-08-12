/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soleilplus.metier;

import soleilplus.donnees.JeuEssai;
import soleilplus.exception.PasDeDossierException;

/**
 *
 * @author DL.C03
 */
public class Planning {

    private static int nbSemaines = 3;
    private static int nbJours = 6;
    private static int nbInterventions = 4;

    public Dossier [][][] tabPlanning = new Dossier[nbSemaines][nbJours][nbInterventions];
    
    public final static String [] TAB_SEMAINE = { "Lun", "Mar", "Mer", "Jeu", "Ven", "Sam"};

    public Dossier[][][] getTabPlanning() {
        return tabPlanning;
    }

    public static int getNbSemaines() {
        return nbSemaines;
    }

    public static int getNbJours() {
        return nbJours;
    }

    public static int getNbInterventions() {
        return nbInterventions;
    }
    public  void     afficherJourNonPlein (int semaine) {
         for ( int numJour = 0 ; numJour < nbJours ; numJour++) {
             if (estUnJourIncomplet(tabPlanning[semaine][numJour])) 
                 System.out.print("| "+Planning.TAB_SEMAINE[numJour] +" ");
         }
     }
     public boolean  estUnJourIncomplet( Dossier [] tabInterventions){
         for ( int numInterv = 0 ; numInterv<nbInterventions ; numInterv++ ) {
             if (tabInterventions[numInterv].estSansDossier()) return true;
         }
         return false;
     }
     public void     afficherIntervention (int semaine, int jour){
         for ( int numInterv = 0 ; numInterv<nbInterventions ; numInterv++ ) {

             int numDossier = tabPlanning[semaine][jour][numInterv].getId();
             try {
                Dossier dossier = JeuEssai.chercherIdDossier(numDossier);
                dossier.details();
             }catch (IndexOutOfBoundsException e) {
                 System.err.println(e);
             }
         }
     }
     public void miseAJourSemaine(){
         for ( int numSemaine = 0 ; numSemaine < nbSemaines-1 ; numSemaine++) {
             miseAJourJournee(numSemaine);
         }
         effacerSemaine(nbSemaines-1);
     }
     public void miseAJourJournee (int semaine){
         for ( int numJour = 0; numJour<nbJours; numJour++){
             Dossier [] tabJourSemaine = tabPlanning[semaine][numJour];
             Dossier [] tabJourSemaineSuivante = tabPlanning[semaine+1][numJour];
             miseAJourInterventions(tabJourSemaine, tabJourSemaineSuivante);
         }
     }
     public void miseAJourInterventions(Dossier [] tabJourSemaine, Dossier [] tabJourSemaineSuivante){
         for (int numInterv = 0; numInterv<nbInterventions; numInterv++){
             tabJourSemaine[numInterv] = tabJourSemaineSuivante[numInterv];
         }
     }
     public void effacerSemaine(int semaine){
         for (int numJour = 0; numJour<nbJours; numJour++){
             Dossier [] tabJour = tabPlanning[semaine][numJour];
             effacerJour(tabJour);
         }
     }
     public static void effacerJour (Dossier [] tabJour){
         for (int numInterv = 0 ; numInterv<nbInterventions; numInterv++)
             tabJour[numInterv] = Dossier.PAS_DE_DOSSIER;
     }
}
