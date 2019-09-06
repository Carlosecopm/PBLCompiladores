/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pblcompiladores;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PushbackReader;
import java.util.ArrayList;
import java.util.List;
import jdk.nashorn.internal.ir.BreakNode;

/**
 *
 * @author carlos
 */
public class Scan {

    PilhaInvertida pilhaInvertida = new PilhaInvertida();
    ArrayList<String> listarInvertida = new ArrayList<String>();
    int indice = 0;
    String listarInvertidadesempilha = null;

    public boolean defGlobal(String equals) throws IOException {
        //String c = equals;
        while (indice < listarInvertida.size()) {
            //String vl = (String) listarInvertida.get(indice);
            listarInvertidadesempilha = pilhaInvertida.desempilha();

            if (listarInvertidadesempilha.equals("constantes")) {
                while (!listarInvertidadesempilha.equals("}")) {
                    //vl = (String) listarInvertida.get(indice);
                    listarInvertidadesempilha = pilhaInvertida.desempilha();
                    if (listarInvertidadesempilha.equals("inteiro") || listarInvertidadesempilha.equals("real")
                            || listarInvertidadesempilha.equals("texto") || listarInvertidadesempilha.equals("boleano")) {

                    }
                }
            }
            indice++;

        }
        return false;
    }

    /**
     *
     * @param equals
     * @throws IOException
     */
    public void defConstante(boolean equals) throws IOException {
        String c = null;
        if (c.equals("constates")) {
            if (c.equals('{')) {
                listaConstate();

            }
        }
        return;
    }

    public boolean defMetodos(String vl) throws IOException {
        String localPrincipal = vl;
        if (localPrincipal.equals("principal") || localPrincipal.equals(vl)) {
            while (indice < listarInvertida.size()) {
                //String vl = (String) listarInvertida.get(indice);
                listarInvertidadesempilha = pilhaInvertida.desempilha();

                if (!listarInvertidadesempilha.equals("}")) {
                    vl = (String) listarInvertida.get(indice);
                    listarInvertidadesempilha = pilhaInvertida.desempilha();
                    Object Obejct = (Object) vl;
                    if (listarInvertidadesempilha.equals("(")) {

                    } else if (listarInvertidadesempilha.equals("texto") || listarInvertidadesempilha.equals("inteiro")
                            || listarInvertidadesempilha.equals("real") || listarInvertidadesempilha.equals("boleano")) {

                    } else if (listarInvertidadesempilha.equals(Obejct)) {

                    } else if (listarInvertidadesempilha.equals(")")) {

                    } else if (listarInvertidadesempilha.equals(":")) {

                    } else if (listarInvertidadesempilha.equals("vazio")
                            || listarInvertidadesempilha.equals("resultado")) {

                    } else if (listarInvertidadesempilha.equals("{")) {

                    } else if (listarInvertidadesempilha.equals("variaveis")) {
                        defVariaveis(vl);
                    }
                }
            }
            indice++;

        }
        return false;
    }

    public boolean defGlobal2() throws IOException {
        String c = null;
        if (c.equals("global")) {

            if (c.equals("metodo")) {
                defMetodo();

                if (c.equals("global")) {
                    defGlobal2();

                } else {
                    //ERRO
                }
            } else {
                //ERRO
            }

        } else {
            //ERRO
        }
        return false;
    }

    public boolean defMetodo() throws IOException {
        while (indice < listarInvertida.size()) {
            String vl = (String) listarInvertida.get(indice);
            listarInvertidadesempilha = pilhaInvertida.desempilha();

            if (listarInvertidadesempilha.equals("metodo")) {
                while (!listarInvertidadesempilha.equals("}")) {
                    vl = (String) listarInvertida.get(indice);
                    listarInvertidadesempilha = pilhaInvertida.desempilha();
                    if (listarInvertidadesempilha.equals("principal")) {
                        defMetodos(vl);
                    }
                    Object object = (Object) vl;
                    if (listarInvertidadesempilha.equals(object)) {
                        defMetodos(vl);
                    }

                }
            }
            indice++;

        }
        return false;
    }

    public void tipo() throws IOException {
        //To change body of generated methods, choose Tools | Templates.

        String c = null;
        if (c.equals("tipo")) {
            tipoId(c.equals("tipo"));

        }
        return;
    }

    public String tipoId(boolean equals) throws IOException {
        String c = null;
        if (c.equals("inteiro")) {

        } else if (c.equals("real")) {

        } else if (c.equals("texto")) {

        } else if (c.equals("boleano")) {

        } else {
            //erro
        }
        return null;
    }

    public void valor() {
        for (char a = 'a'; a <= 'z'; a++) {
            //letra.add(Character.valueOf(a));  // sem autoboxing
            // lista.add(ch);  // autoboxing aqui, equivale aa linha anterior
            //System.out.println("" + a+ Character.toUpperCase(a));
        }
        return;
    }

    public void valorConstante() {
        //NUMERO ou CADEIA DE CARACTER
        return;
    }

    public void listaParametro() throws IOException {
        String tipoId = null,
                c = null;

        tipoId = tipoId(c.equals("tipo"));
        //concatenar com identificador

        listaParametro2();
        return;
    }

    public void listaParametro2() throws IOException {
        String c = null;
        if (c.equals(',')) {
            String tipoId;
            //tipoId = tipoId(c.equals("tipo"));
            //concatenar com identificador
            listaParametro2();

        }
        return;
    }

    public void listaArgumentos() throws IOException {
        atribuicao();
        listaArgumentos2();
        return;
    }

    public void atribuicao() {
        //To change body of generated methods, choose Tools | Templates.
        return;
    }

    public void listaArgumentos2() throws IOException {
        String c = null;
        if (c.equals(',')) {
            String tipoId;
            //tipoId = tipoId(c.equals("tipo"));
            //concatenar com identificador
            listaArgumentos2();

        }
        return;
    }

    //Constantes
    public void listaConstate() throws IOException {
        constante();
        return;
    }

    public void constante() throws IOException {
        String c = null;
        if (c.equals(';')) {
            listaConstante2();
        } else if (c.equals("identificador")) {
            tipoId(c.equals("tipo"));
        } else if (true) {
            atribuicaoConstate();
        }
        return;
    }

    public void listaConstante2() throws IOException {
        listaConstate();
        return;
    }

    public void atribuicaoConstate() {
        String c = null;
        listaATribuicaoConstante();
        if (c.equals("identificador")) {

        }
        return;
    }

    public void listaATribuicaoConstante() {
        String c = null;
        if (c.equals(';')) {
            atribuicaoConstate();
        }
        return;
    }

    public void declaracao() {
        //To change body of generated methods, choose Tools | Templates.
        return;
    }

    private boolean defVariaveis(String vl) {
        String localPrincipal = vl;
        boolean resultado = true;
        if (localPrincipal.equals("variaveis")) {
            while (indice < listarInvertida.size()) {
                //String vl = (String) listarInvertida.get(indice);
                listarInvertidadesempilha = pilhaInvertida.desempilha();

                if (!listarInvertidadesempilha.equals("}")) {
                    vl = (String) listarInvertida.get(indice);
                    listarInvertidadesempilha = pilhaInvertida.desempilha();
                    Object Obejct = (Object) vl;
                    if (listarInvertidadesempilha.equals("(inteiro") || listarInvertidadesempilha.equals("real")
                            || listarInvertidadesempilha.equals("texto") || listarInvertidadesempilha.equals("boleano")) {

                    } else if (listarInvertidadesempilha.equals(Obejct)) {

                    } else if (listarInvertidadesempilha.equals(";") || listarInvertidadesempilha.equals(",")) {

                    }
                }
                return resultado;
            }
            indice++;

        }
        //To change body of generated methods, choose Tools | Templates.
        return false;
    }

   public boolean defEnquanto(String vl) {
       String localEnquanto = vl;
        boolean resultado = true;
        if (localEnquanto.equals("enquanto")) {
            while (indice < listarInvertida.size()) {
                //String vl = (String) listarInvertida.get(indice);
                listarInvertidadesempilha = pilhaInvertida.desempilha();

                if (!listarInvertidadesempilha.equals("}")) {
                    vl = (String) listarInvertida.get(indice);
                    listarInvertidadesempilha = pilhaInvertida.desempilha();
                    Object Obejct = (Object) vl;
                    if (listarInvertidadesempilha.equals("(inteiro") || listarInvertidadesempilha.equals("real")
                            || listarInvertidadesempilha.equals("texto") || listarInvertidadesempilha.equals("boleano")) {

                    } else if (listarInvertidadesempilha.equals(Obejct)) {

                    } else if (listarInvertidadesempilha.equals(";") || listarInvertidadesempilha.equals(",")) {

                    }
                }
                return resultado;
            }
            indice++;

        }
       
        return false;
        
    }

}
