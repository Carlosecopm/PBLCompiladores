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
public class ScanUtil {

    public static final int PALAVRA_RESERVADA = 0;
    public static final int IDENTIFICADOR = 1;
    public static final int NUMERO = 2;
    public static final int OPERADOR_ARITMETICO = 3;
    public static final int OPERADOR_RELACIONAL = 4;
    public static final int OPERADOR_LÓGICO = 5;
    public static final int DELIMITADOR = 6;
    public static final int CADEIA_DE_CARACTER = 7;
    public static final int SIMBOLO = 8;
    public static final int ID = 9;

    public static void lookUp(Token token) {

        if (token.getLexema().equals("programa")) {
            token.setCodigo(PALAVRA_RESERVADA);
        } else if (token.getLexema().equals("constantes")) {
            token.setCodigo(PALAVRA_RESERVADA);

        } else if (token.getLexema().equals("variaveis")) {
            token.setCodigo(PALAVRA_RESERVADA);

        } else if (token.getLexema().equals("metodo")) {
            token.setCodigo(PALAVRA_RESERVADA);

        } else if (token.getLexema().equals("resultado")) {
            token.setCodigo(PALAVRA_RESERVADA);

        } else if (token.getLexema().equals("principal")) {
            token.setCodigo(PALAVRA_RESERVADA);

        } else if (token.getLexema().equals("se")) {
            token.setCodigo(PALAVRA_RESERVADA);

        } else if (token.getLexema().equals("entao")) {
            token.setCodigo(PALAVRA_RESERVADA);

        } else if (token.getLexema().equals("senao")) {
            token.setCodigo(PALAVRA_RESERVADA);

        } else if (token.getLexema().equals("equanto")) {
            token.setCodigo(PALAVRA_RESERVADA);

        } else if (token.getLexema().equals("leia")) {
            token.setCodigo(PALAVRA_RESERVADA);

        } else if (token.getLexema().equals("escreva")) {
            token.setCodigo(PALAVRA_RESERVADA);

        } else if (token.getLexema().equals("vazio")) {
            token.setCodigo(PALAVRA_RESERVADA);

        } else if (token.getLexema().equals("inteiro")) {
            token.setCodigo(PALAVRA_RESERVADA);

        } else if (token.getLexema().equals("real")) {
            token.setCodigo(PALAVRA_RESERVADA);

        } else if (token.getLexema().equals("boleano")) {
            token.setCodigo(PALAVRA_RESERVADA);

        } else if (token.getLexema().equals("texto")) {
            token.setCodigo(PALAVRA_RESERVADA);

        } else if (token.getLexema().equals("verdadeiro")) {
            token.setCodigo(PALAVRA_RESERVADA);

        } else if (token.getLexema().equals("falso")) {
            token.setCodigo(PALAVRA_RESERVADA);

        } else if (token.getLexema().equals("+")) {
            token.setCodigo(OPERADOR_ARITMETICO);

        } else if (token.getLexema().equals("*")) {
            token.setCodigo(OPERADOR_ARITMETICO);

        } else if (token.getLexema().equals("-")) {
            token.setCodigo(OPERADOR_ARITMETICO);

        } else if (token.getLexema().equals("/")) {
            token.setCodigo(OPERADOR_ARITMETICO);

        } else if (token.getLexema().equals("++")) {
            token.setCodigo(OPERADOR_ARITMETICO);

        } else if (token.getLexema().equals("--")) {
            token.setCodigo(OPERADOR_ARITMETICO);

        } else if (token.getLexema().equals("!=")) {
            token.setCodigo(OPERADOR_RELACIONAL);

        } else if (token.getLexema().equals("==")) {
            token.setCodigo(OPERADOR_RELACIONAL);

        } else if (token.getLexema().equals("<")) {
            token.setCodigo(OPERADOR_RELACIONAL);

        } else if (token.getLexema().equals("<=")) {
            token.setCodigo(OPERADOR_RELACIONAL);

        } else if (token.getLexema().equals(">")) {
            token.setCodigo(OPERADOR_RELACIONAL);

        } else if (token.getLexema().equals(">=")) {
            token.setCodigo(OPERADOR_RELACIONAL);

        } else if (token.getLexema().equals("=")) {
            token.setCodigo(OPERADOR_RELACIONAL);

        } else if (token.getLexema().equals("!")) {
            token.setCodigo(OPERADOR_LÓGICO);

        } else if (token.getLexema().equals("&&")) {
            token.setCodigo(OPERADOR_LÓGICO);

        } else if (token.getLexema().equals("||")) {
            token.setCodigo(OPERADOR_RELACIONAL);

        } else if (token.getLexema().equals(";")) {
            token.setCodigo(DELIMITADOR);

        } else if (token.getLexema().equals(",")) {
            token.setCodigo(DELIMITADOR);

        } else if (token.getLexema().equals("(")) {
            token.setCodigo(DELIMITADOR);

        } else if (token.getLexema().equals(")")) {
            token.setCodigo(DELIMITADOR);

        } else if (token.getLexema().equals("[")) {
            token.setCodigo(DELIMITADOR);

        } else if (token.getLexema().equals("]")) {
            token.setCodigo(DELIMITADOR);

        } else if (token.getLexema().equals("{")) {
            token.setCodigo(DELIMITADOR);

        } else if (token.getLexema().equals("}")) {
            token.setCodigo(DELIMITADOR);

        } else if (token.getLexema().equals(".")) {
            token.setCodigo(DELIMITADOR);
        
        }else if (token.getLexema().equals("a")) {
            token.setCodigo(IDENTIFICADOR);
        } 
//AQUI FAREI PARA O RESTO DAS PALAVRAS RESERVADAS
        else {

            token.setCodigo(ID);
        }
    }
}

