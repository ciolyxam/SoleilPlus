/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soleilplus.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import soleilplus.utilitaires.ChangerEcranEvent;

/**
 *
 * @author Ciolyxam
 */
public class MenuBarre extends JMenuBar{

    private ChangerEcranEvent changementEcranEvent = new ChangerEcranEvent();
    
    public MenuBarre() {
        init();
    }
    private void init() {
        initMenuFichier();
        initMenuOutils();
        initMenuCommande();
        initMenuClient();
        initMenuEquipe();
    }
    private void initMenuFichier() {
        JMenu fichier = new JMenu("Fichier");
        
        JMenuItem connexion =  new JMenuItem("Connexion ...");
        JMenuItem deconnexion = new JMenuItem("Deconnexion...");
        JMenuItem rafraichissement = new JMenuItem("Rafraichissement");
        JMenuItem quitter = new JMenuItem("Quitter");
        
        fichier.add(connexion);
        fichier.add(deconnexion);
        fichier.add(rafraichissement);
        fichier.add(quitter);
        
        this.add(fichier);
    }
    private void initMenuOutils() {
        JMenu outils = new JMenu("Outils");
        
        JMenuItem copier =  new JMenuItem("Copier");
        JMenuItem couper = new JMenuItem("Couper");
        JMenuItem coller = new JMenuItem("Coller");
        
        outils.add(copier);
        outils.add(couper);
        outils.add(coller);
        
        this.add(outils);
    }
    private void initMenuCommande(){
        JMenu commande = new JMenu("Commande");
        
        JMenuItem listeCommande =  new JMenuItem("Liste des commandes");
        JMenuItem chercherCommande = new JMenuItem("Chercher une commande");
        JMenuItem ajouterCommande = new JMenuItem("Ajouter une commande");
        
        commande.add(listeCommande);
        commande.add(chercherCommande);
        commande.add(ajouterCommande);
        
        this.add(commande);
    }
    private void initMenuClient() {
        JMenu client = new JMenu("Client");
        
        JMenuItem listeClient =  new JMenuItem("Liste des clients");
        JMenuItem chercherClient = new JMenuItem("Chercher un client");
        JMenuItem ajouterClient = new JMenuItem("Ajouter un client");
        
        client.add(listeClient);
        client.add(chercherClient);
        client.add(ajouterClient);
        
        this.add(client);
    }
    private void initMenuEquipe() {
        JMenu equipe = new JMenu("Equipe");
        
        JMenuItem listeEquipe =  new JMenuItem("Liste des equipes");
        listeEquipe.addActionListener(changementEcranEvent);
        listeEquipe.setActionCommand("ecranPlannings");
        JMenuItem chercherEquipe = new JMenuItem("Chercher un equipe");
        JMenuItem ajouterEquipe = new JMenuItem("Ajouter un equipe");
        
        equipe.add(listeEquipe);
        equipe.add(chercherEquipe);
        equipe.add(ajouterEquipe);
        
        this.add(equipe);
    }
}
