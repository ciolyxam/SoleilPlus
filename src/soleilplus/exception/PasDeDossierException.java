/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soleilplus.exception;

/**
 *
 * @author DL.C03
 */
public class PasDeDossierException extends Exception {

    /**
     * Creates a new instance of <code>PasDeDossierException</code> without
     * detail message.
     */
    public PasDeDossierException() {
    }

    /**
     * Constructs an instance of <code>PasDeDossierException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PasDeDossierException(String msg) {
        super(msg);
    }
}
