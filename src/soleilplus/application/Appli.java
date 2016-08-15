/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soleilplus.application;

import soleilplus.donnees.JeuEssai;
import soleilplus.metier.Dossier;
import soleilplus.metier.Planning;

/**
 *
 * @author DL.C03
 */
public class Appli {
    public static void tester(){
        // affichage des tableau generer
        afficherDonnees();
        //quetion A
        afficherJourIncomplet();
        //quetion B
        afficherInterv();
        //quetion C
        miseAJour();
    }
    private static void afficherJourIncomplet () {
        JeuEssai.tabEquipe[0].p.tabPlanning[0][5][1] = Dossier.PAS_DE_DOSSIER;
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
    public static void afficherDonnees(){
        // TODO afficher les dossiers
        afficherDossiers();
        // TODO afficehr les plannings
        afficherPlannings();
    }
    public static void afficherDossiers(){
        for (int numDossier = 0 ; numDossier<Dossier.nbDossier; numDossier++){
            Dossier dossier = JeuEssai.tabDossier[numDossier];
            System.out.println(dossier.details());
        }
    }
    public static void afficherPlannings(){
        for (int numEquipe = 0; numEquipe<JeuEssai.nbEquipe; numEquipe++){
            System.out.println("\n\n ############ EQUIPE " + numEquipe + " ############" );
            JeuEssai.tabEquipe[numEquipe].afficherPlanning();
        }
    }
}
