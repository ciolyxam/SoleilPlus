/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soleilplus;

import soleilplus.application.Appli;
import soleilplus.donnees.JeuEssai;

/**
 *
 * @author DL.C03
 */
public class SoleilPlus {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JeuEssai.initialiser();
        Appli.tester();
    }
    
}
