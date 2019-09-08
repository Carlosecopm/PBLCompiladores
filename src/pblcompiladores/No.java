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
public class No {
//
    private String valor,linha;
    private No anterior;
    //Define nó anterior

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }
    //Retorna nó anterior.

    public No getAnterior() {
        return anterior;
    }
    //Define valor do nó

    public void setValor(String valor, int linha) {
        this.valor = valor;
    }
    
     public void setValor(String valor) {
        this.valor = valor;
    }
    //Retorna valor do nó

    public String getValor() {
        return valor;
    }
}
