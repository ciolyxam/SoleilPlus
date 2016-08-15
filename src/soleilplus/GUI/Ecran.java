/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soleilplus.GUI;



import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import soleilplus.utilitaires.ChangerEcranEvent;


/**
 * class permet d'afficher un ecran utilisant swing
 * @author Ciolyxam
 */
public abstract class Ecran extends JPanel {
    
    public static ChangerEcranEvent changementEcranEvent =  new ChangerEcranEvent();
    private String titre;
    
    public Ecran() {
        this(new GridBagLayout());
    }
    private Ecran(LayoutManager layout) {
        super(layout);
        init();
    }

    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    
    private void init(){
        initOptions();
        initComposants();
    }
    /**
     * Contient toutes les options definissant ce panel
     */
    public abstract void initOptions();
    /**
     * Methode permettant d'initialiser et positionner les composants
     * 
     */
    public abstract void initComposants();
    
}
