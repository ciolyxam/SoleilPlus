/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soleilplus.GUI;

import soleilplus.utilitaires.EmptyComponent;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import soleilplus.utilitaires.ChangerEcranEvent;


/**
 *
 * @author Ciolyxam
 */
public class FenetrePrincipale extends JFrame {
    
    private final       String PATH = "C:/Users/Ciolyxam/Desktop/professionnel/AFPAR/12 - S+/E4 - GUI/SoleilPlus/ressources/";
    private final       ImageIcon ICONE = new ImageIcon(PATH+"images/icon.gif");
    private static      JPanel mainPanel;
    private static      BorderLayout layout = new BorderLayout(20, 20);
    private static      JLabel titreEcran = new JLabel("un titre de fagot");
    private static      Ecran pan;
    
    public static       Ecran ecranPrincipal;
    public static       Ecran ecranPlannings;

    public FenetrePrincipale(String title) {
        super(title);
        this.init();
    }

    public String getTitreEcran() {
        return titreEcran.getText();
    }
    public static void setTitreEcran(String titreEcran) {
        FenetrePrincipale.titreEcran.setText(titreEcran);
    }

    /**
     * initialise cette fenetre
     */
    private void        init(){
        initOptionFenetre();
        initEcrans();
        initUIFenetre();
        this.setVisible(true);
    }
    
    /**
     * initialise les options de cette fenetre
     */
    private void        initOptionFenetre(){
        this.setSize(1200, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(ICONE.getImage());
    }
    
    /**
     * initialise les composants de cette fenetre
     */
    private void        initUIFenetre(){
        FenetrePrincipale.pan = FenetrePrincipale.ecranPrincipal;
        FenetrePrincipale.setTitreEcran(pan.getTitre());
        
        this.setJMenuBar(new MenuBarre());
        mainPanel = (JPanel) this.getContentPane();
        mainPanel.setLayout(layout);

        titreEcran.setHorizontalAlignment(SwingConstants.CENTER);
        titreEcran.setFont(titreEcran.getFont().deriveFont(22.0f));
        
        mainPanel.add(titreEcran, BorderLayout.NORTH);
        mainPanel.add(pan, BorderLayout.CENTER);
        mainPanel.add(new EmptyComponent(), BorderLayout.WEST);
        mainPanel.add(new EmptyComponent(), BorderLayout.EAST);
        mainPanel.add(new EmptyComponent(), BorderLayout.SOUTH);
    }
    
    /**
     * initialise les ecrans de cette application
     */
    private void        initEcrans(){
        ChangerEcranEvent.init();
        FenetrePrincipale.ecranPrincipal = new EcranPrincipal();
        FenetrePrincipale.ecranPlannings = new EcranPlannings();
    }
    
    /**
     * Change l'ecran courant
     * @param ecran 
     */
    public static void  setEcran(Ecran ecran){
        if(layout.getLayoutComponent(BorderLayout.CENTER) != null) mainPanel.remove(pan);
        FenetrePrincipale.pan = ecran;
        mainPanel.add(FenetrePrincipale.pan);
        FenetrePrincipale.setTitreEcran(FenetrePrincipale.pan.getTitre());
        pan.updateUI();
    }
    
    

}
