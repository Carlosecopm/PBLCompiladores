/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pblcompiladores;

/**
 *
 * @author carlos
 */
@SuppressWarnings("serial")
public class EOFException extends Exception {
    
    public EOFException(){
        super("Fim de arquivo");
    } 
}
