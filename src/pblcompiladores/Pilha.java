/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pblcompiladores;

import java.util.*;

/**
 *
 * @author carlos
 */
public class Pilha {
    //Variavel para definição do topo da pilha.

    No topo = null;
    //Método que empilha valores.

    public void empilha(String valor, int linha) {
        No novo = new No();
        novo.setValor(valor,linha);
        novo.setAnterior(topo);
        topo = novo;
    }
    //Método para desempilhar valores

    public String desempilha() throws EmptyStackException {
        if (topo == null) {
            throw new EmptyStackException("A pilha está vazia");
        } else {
            String valor = topo.getValor();
            topo = topo.getAnterior();
            return valor;
        }
    }
    //Método para listar pilha. Percorre os nós da pilha atribuindo seus valores em um ArrayList

    public ArrayList<String> listar() throws EmptyStackException {
        if (topo == null) {
            throw new EmptyStackException("A pilha está vazia");
        } else {
            ArrayList<String> listar = new ArrayList<String>();
            No aux = topo;
            while (aux != null) {
                listar.add(aux.getValor());
                aux = aux.getAnterior();
            }
            return listar;
        }
    }
    
    public void empilhaCaracter(char outros, int linha) {
        No novo = new No();
        String valor = String.valueOf(outros);
        novo.setValor(valor,linha);
        novo.setAnterior(topo);
        topo = novo;
    }

    
}
