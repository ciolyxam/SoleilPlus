/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soleilplus.utilitaires;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import soleilplus.GUI.Ecran;
import soleilplus.GUI.EcranDossier;
import soleilplus.GUI.EcranDossierClient;
import soleilplus.GUI.EcranOption;
import soleilplus.GUI.EcranPlanningEquipe;
import soleilplus.GUI.EcranPlannings;
import soleilplus.GUI.EcranPrincipal;
import soleilplus.GUI.FenetrePrincipale;

/**
 *
 * @author Ciolyxam
 */
public class ChangerEcranEvent implements ActionListener{
    
    public static       HashMap<String, Ecran> ecrans = new HashMap();
    
    public static void init () {
        ecrans.put("ecranPrincipal", new EcranPrincipal());
        ecrans.put("ecranPlannings", new EcranPlannings());
        ecrans.put("ecranPlanningEquipe", new EcranPlanningEquipe());
        ecrans.put("ecranOption", new EcranOption());
        ecrans.put("ecranDossier", new EcranDossier());
        ecrans.put("ecransDossierClient", new EcranDossierClient());
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        FenetrePrincipale.setEcran(ecrans.get(e.getActionCommand()));
    }
}
