/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soleilplus.donnees;

import soleilplus.metier.Dossier;
import soleilplus.metier.Equipe;
import soleilplus.metier.Ouvrier;
import soleilplus.metier.Planning;
import soleilplus.metier.ResponsableEquipe;

/**
 *
 * @author DL.C03
 */
public class JeuEssai {
    public static int nbEquipe = 5;
    public static int nbDossier = 500;
    public static Equipe [] tabEquipe = new Equipe[nbEquipe];
    public static Dossier [] tabDossier = new Dossier[nbDossier];

    public static void initialiser(){
        initDossier();
        initEquipe();

    }
    public static void initDossier(){
        Dossier.nbDossier=0;
        tabDossier[0]= Dossier.PAS_DE_DOSSIER;
        for (int numDossier = 1 ; numDossier<nbDossier ; numDossier++){
            String nomDossier = "nom"+numDossier;
            String adresseDossier = "adresse"+numDossier;
            Dossier dossier =  new Dossier(numDossier, nomDossier, adresseDossier);
            tabDossier[numDossier]=dossier;
        }
    }
    public static void initEquipe(){
        for(int numEquipe = 0 ; numEquipe<nbEquipe ; numEquipe++){
            Planning p = initPlanning();
            ResponsableEquipe re = genererRE(numEquipe);
            Ouvrier o1 = genererOuvrier(10+numEquipe);
            Ouvrier o2 = genererOuvrier(20+numEquipe);
            Equipe equipe =  new Equipe(re, o1, o2, p);
            tabEquipe [numEquipe] = equipe;
        }
    }
    public static Planning initPlanning () {
        Planning p = new Planning();
        for (int numSemaine = 0 ; numSemaine<Planning.getNbSemaines(); numSemaine++) {
            for (int numJour = 0 ; numJour<Planning.getNbJours(); numJour++){
                for (int numInterv = 0 ; numInterv<Planning.getNbInterventions(); numInterv++){
                    p.tabPlanning[numSemaine][numJour][numInterv] = genererDossier();
                }
            }
        }
        return p;
    }

    public static ResponsableEquipe genererRE(int id){
        String nom = "nomRE"+id;
        String prenom = "prenomRE"+id;
        ResponsableEquipe re = new  ResponsableEquipe(nom, prenom);
        return re;
    }
    public static Ouvrier genererOuvrier(int id){
        String nom = "nomO"+id;
        String prenom = "prenomO"+id;
        Ouvrier re = new  Ouvrier(nom, prenom);
        return re;
    }
    public static Dossier genererDossier(){
        int idDossier = (int)(Math.random()*nbDossier);
        Dossier dossier = chercherIdDossier(idDossier);
        return dossier;
    }
    public static Dossier chercherIdDossier (int idDossierChercher) throws IndexOutOfBoundsException{
        int numDossier = 0;
        boolean continuer = true;
        Dossier dossier = null;
        while (continuer){
            dossier = tabDossier[numDossier];
            if (dossier.getId() == idDossierChercher) continuer = false;
            numDossier++;
        }
        return dossier;
    }
}
