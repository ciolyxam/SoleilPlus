/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soleilplus.GUI;

import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author Ciolyxam
 */
public final class EcranPrincipal extends Ecran {
    
    @Override
    public void initComposants() {
        JButton test =  new JButton("Aller au planning");
        test.setActionCommand("ecranPlannings");
        test.addActionListener(Ecran.changementEcranEvent);
        this.add(test);
    }

    @Override
    public void initOptions() {
        this.setTitre("Accueil");
    }


    
}
