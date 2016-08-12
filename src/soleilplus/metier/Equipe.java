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
public class Equipe {
    
    private ResponsableEquipe re;
    private Ouvrier o1, o2;
    private Planning p;

    public Equipe() {
    }

    public Equipe(ResponsableEquipe re, Ouvrier o1, Ouvrier o2, Planning p) {
        this.re = re;
        this.o1 = o1;
        this.o2 = o2;
        this.p = p;
    }
    

    public void setRe(ResponsableEquipe re) {
        this.re = re;
    }

    public void setO1(Ouvrier o1) {
        this.o1 = o1;
    }

    public void setO2(Ouvrier o2) {
        this.o2 = o2;
    }

    public void setP(Planning p) {
        this.p = p;
    }

    public ResponsableEquipe getRe() {
        return re;
    }

    public Ouvrier getO1() {
        return o1;
    }

    public Ouvrier getO2() {
        return o2;
    }

    public Planning getP() {
        return p;
    }
    public void     afficherJourNonPlein (int semaine) {
        System.out.println("Les jours non complet de l'equipe de "+re+" de la semaine "+semaine+" sont :");
        this.p.afficherJourNonPlein(semaine);
     }
    public void    afficherToutesInterventions (){
         for (int numSemaine = 0 ; numSemaine<Planning.getNbSemaines(); numSemaine++){
             for (int numJour = 0 ; numJour<Planning.getNbJours(); numJour++){
                System.out.println("interventions de l'equipe de "+re+" de la semaine "+numSemaine+" le "+Planning.TAB_SEMAINE[numJour]);
                p.afficherIntervention(numSemaine, numJour);
             }
         }
     }
    public void     miseAJour(){
        p.miseAJourSemaine();
    }
}
