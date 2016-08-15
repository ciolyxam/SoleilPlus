/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soleilplus.GUI;

import javax.swing.JButton;

/**
 *
 * @author Ciolyxam
 */
public class EcranPlannings extends Ecran{

    @Override
    public void initComposants() {
        JButton test =  new JButton("Aller a l'accueil");
        test.setActionCommand("ecranPrincipal");
        test.addActionListener(Ecran.changementEcranEvent);
        this.add(test);
    }

    @Override
    public void initOptions() {
        this.setTitre("Planning general");
    }

    
}
