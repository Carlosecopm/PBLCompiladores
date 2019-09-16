/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pblcompiladores;

import java.util.ArrayList;

/**
 *
 * @author carlos
 */
public class PilhaArqTemp {

    No topo = null;

    //Método que empilha valores.
    public void empilha(String valor) {
        No novo = new No();
        novo.setValor(valor);
        novo.setAnterior(topo);
        topo = novo;
        //System.out.println("pilha invertida: "+ novo.getValor());
    }
    //Método para desempilhar valores

   /* public String desempilha() throws EmptyStackException {
        if (topo == null) {
            throw new EmptyStackException("A pilha está vazia");
        } else {
            String valor = topo.getValor();
            topo = topo.getAnterior();
            return valor;
        }
    }*/
    //Método para listar pilha. Percorre os nós da pilha atribuindo seus valores em um ArrayList

    public ArrayList<String> listar() throws EmptyStackException {
        if (topo == null) {
            throw new EmptyStackException("A pilha invertida está vazia");
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

    public No retornatopo() {
        if (topo == null) {
            throw new EmptyStackException("A pilha está vazia");
        } else {
            String valor = topo.getValor();
            return topo;
        }
    }

}
