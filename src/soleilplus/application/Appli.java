/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soleilplus.application;

import soleilplus.donnees.JeuEssai;
import soleilplus.metier.Planning;

/**
 *
 * @author DL.C03
 */
public class Appli {
    public static void tester(){
        //quetion A
        afficherJourIncomplet();
        //quetion B
        afficherInterv();
        //quetion C
        miseAJour();
    }
    private static void afficherJourIncomplet () {
        for (int numEquipe = 0 ; numEquipe<JeuEssai.nbEquipe; numEquipe++){
            for (int numSemaine = 0 ; numSemaine<Planning.getNbSemaines(); numSemaine++){
                JeuEssai.tabEquipe[numEquipe].afficherJourNonPlein(numSemaine);
            }
        }
    }
    private static void afficherInterv(){
        for (int numEquipe = 0 ; numEquipe<JeuEssai.nbEquipe; numEquipe++){
            JeuEssai.tabEquipe[numEquipe].afficherToutesInterventions();
        }
    }
    private static void miseAJour (){
        for (int numEquipe = 0 ; numEquipe<JeuEssai.nbEquipe; numEquipe++){
            JeuEssai.tabEquipe[numEquipe].miseAJour();
        }
    }
}
