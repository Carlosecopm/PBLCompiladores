/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pblcompiladores;

import java.io.BufferedReader;
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

    PilhaArqTemp pilhaArqTemp = new PilhaArqTemp();
    ArrayList<String> listarInvertida = new ArrayList<String>();
    int indice = 0;
    String listarInvertidadesempilha = null;
    String valor;
    boolean resultado = true;
    Object objeto = null;

    public void lerArquivo() throws FileNotFoundException, IOException {
        FileInputStream stream = new FileInputStream("temp.txt");
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader br = new BufferedReader(reader);
        String linha = br.readLine();
        while (linha != null) {
            valor = linha;
            pilhaArqTemp.empilha(valor);
            System.out.println(linha);

            linha = br.readLine();
        }

    }

    public boolean defPrograma() {
        listarInvertida = pilhaArqTemp.listar();
        String local = null;
        int indiceLocal = 0;
        while (indiceLocal < listarInvertida.size()) {
            local = (String) listarInvertida.get(indice);
            listarInvertidadesempilha = pilhaArqTemp.desempilha();
        }

        return false;
    }

    public boolean defGlobal(String vl, int indice) throws IOException {
        String local = vl;
        int indiceLocal =0;
        System.out.println("defGlobal: " + vl);
        System.out.println("indiceLocal: " + indiceLocal);
        if (local.equals("constantes")) {

            indiceLocal++;
            local = (String) listarInvertida.get(indiceLocal);
            listarInvertidadesempilha = pilhaArqTemp.desempilha();
            if (local.equals("{")) {
                //resultado = defConstante(local, indiceLocal);
                return true;
            }

        }
        return false;
    }

    /**
     *
     * @param equals
     * @throws IOException
     */
    public boolean defConstante(String local, int indiceLocal) throws IOException {
        String localConst = local;
        int indiceConst = indiceLocal;

        if (localConst.equals("{")) {
            while (local.equals("}")) {

                indiceConst++;
                localConst = (String) listarInvertida.get(indiceConst);
                listarInvertidadesempilha = pilhaArqTemp.desempilha();

                if (localConst.equals("texto") || localConst.equals("inteiro")
                        || localConst.equals("real")
                        || localConst.equals("boleano")) {
                    indiceConst++;
                    localConst = (String) listarInvertida.get(indiceConst);
                    listarInvertidadesempilha = pilhaArqTemp.desempilha();
                    objeto = (String) localConst;

                    if (localConst.equals(objeto)) {
                        indiceConst++;
                        localConst = (String) listarInvertida.get(indiceConst);
                        listarInvertidadesempilha = pilhaArqTemp.desempilha();

                        if (localConst.equals("=")) {
                            indiceConst++;
                            localConst = (String) listarInvertida.get(indiceConst);
                            listarInvertidadesempilha = pilhaArqTemp.desempilha();
                            objeto = (String) localConst;

                            if (localConst.equals(objeto)) {
                                indiceConst++;
                                localConst = (String) listarInvertida.get(indiceConst);
                                listarInvertidadesempilha = pilhaArqTemp.desempilha();

                                if (localConst.equals(",")) {

                                } else if (localConst.equals(";")) {

                                }
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    public boolean defMetodos(String vl) throws IOException {
        String localPrincipal = vl;
        if (localPrincipal.equals("principal") || localPrincipal.equals(vl)) {
            while (indice < listarInvertida.size()) {
                //String vl = (String) listarInvertida.get(indice);
                listarInvertidadesempilha = pilhaArqTemp.desempilha();

                if (!listarInvertidadesempilha.equals("reslutado") || listarInvertidadesempilha.equals("vazio")) {
                    vl = (String) listarInvertida.get(indice);
                    listarInvertidadesempilha = pilhaArqTemp.desempilha();
                    Object Obejct = (Object) vl;

                    if (listarInvertidadesempilha.equals("(")) {
                        vl = (String) listarInvertida.get(indice);
                        listarInvertidadesempilha = pilhaArqTemp.desempilha();

                        if (listarInvertidadesempilha.equals("texto") || listarInvertidadesempilha.equals("inteiro")
                                || listarInvertidadesempilha.equals("real") || listarInvertidadesempilha.equals("boleano")) {
                            vl = (String) listarInvertida.get(indice);
                            listarInvertidadesempilha = pilhaArqTemp.desempilha();

                            if (listarInvertidadesempilha.equals(Obejct)) {
                                vl = (String) listarInvertida.get(indice);
                                listarInvertidadesempilha = pilhaArqTemp.desempilha();

                                if (listarInvertidadesempilha.equals(")")) {
                                    vl = (String) listarInvertida.get(indice);
                                    listarInvertidadesempilha = pilhaArqTemp.desempilha();

                                    if (listarInvertidadesempilha.equals(":")) {
                                        vl = (String) listarInvertida.get(indice);
                                        listarInvertidadesempilha = pilhaArqTemp.desempilha();

                                        if (listarInvertidadesempilha.equals("vazio")
                                                || listarInvertidadesempilha.equals("resultado")) {
                                            vl = (String) listarInvertida.get(indice);
                                            listarInvertidadesempilha = pilhaArqTemp.desempilha();

                                            if (listarInvertidadesempilha.equals("{")) {
                                                vl = (String) listarInvertida.get(indice);
                                                listarInvertidadesempilha = pilhaArqTemp.desempilha();

                                                if (listarInvertidadesempilha.equals("variaveis")) {
                                                    defVariaveis(vl);

                                                }

                                            }

                                        }

                                    }

                                }

                            }

                        }
                    }
                }
            }
            indice++;

        }
        vl = (String) listarInvertida.get(indice);
        listarInvertidadesempilha = pilhaArqTemp.desempilha();
        if (vl.equals("vazio") || vl.equals("resustado")) {
            indice++;
            vl = (String) listarInvertida.get(indice);
            listarInvertidadesempilha = pilhaArqTemp.desempilha();
            objeto = (String) vl;
            if (vl.equals(objeto)) {
                indice++;
                vl = (String) listarInvertida.get(indice);
                listarInvertidadesempilha = pilhaArqTemp.desempilha();
                indice++;
                vl = (String) listarInvertida.get(indice);
                listarInvertidadesempilha = pilhaArqTemp.desempilha();
                if (vl.equals(";")) {
                    indice++;
                    vl = (String) listarInvertida.get(indice);
                    listarInvertidadesempilha = pilhaArqTemp.desempilha();
                    if (vl.equals("}")) {
                        return resultado;
                    }
                }
            }

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
            listarInvertidadesempilha = pilhaArqTemp.desempilha();

            if (listarInvertidadesempilha.equals("metodo")) {
                while (!listarInvertidadesempilha.equals("}")) {
                    vl = (String) listarInvertida.get(indice);
                    listarInvertidadesempilha = pilhaArqTemp.desempilha();
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
                listarInvertidadesempilha = pilhaArqTemp.desempilha();

                if (!listarInvertidadesempilha.equals("}")) {
                    vl = (String) listarInvertida.get(indice);
                    listarInvertidadesempilha = pilhaArqTemp.desempilha();
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
                listarInvertidadesempilha = pilhaArqTemp.desempilha();

                if (!listarInvertidadesempilha.equals("}")) {
                    vl = (String) listarInvertida.get(indice);
                    listarInvertidadesempilha = pilhaArqTemp.desempilha();

                    if (listarInvertidadesempilha.equals("(")) {
                        indice++;
                        vl = (String) listarInvertida.get(indice);
                        listarInvertidadesempilha = pilhaArqTemp.desempilha();
                        Object Obejct = (Object) vl;

                        if (listarInvertidadesempilha.equals("(inteiro") || listarInvertidadesempilha.equals("real")
                                || listarInvertidadesempilha.equals("texto") || listarInvertidadesempilha.equals("boleano")) {
                            vl = (String) listarInvertida.get(indice);
                            listarInvertidadesempilha = pilhaArqTemp.desempilha();

                            if (listarInvertidadesempilha.equals(Obejct)) {
                                vl = (String) listarInvertida.get(indice);
                                listarInvertidadesempilha = pilhaArqTemp.desempilha();
                                //!= | == | < | <= | > | >= | =
                                if (listarInvertidadesempilha.equals("!=") || listarInvertidadesempilha.equals("==") | listarInvertidadesempilha.equals("!=")
                                        || listarInvertidadesempilha.equals("<") || listarInvertidadesempilha.equals("<=")
                                        || listarInvertidadesempilha.equals(">") || listarInvertidadesempilha.equals(">=")
                                        || listarInvertidadesempilha.equals("=")) {
                                    indice++;
                                    vl = (String) listarInvertida.get(indice);
                                    listarInvertidadesempilha = pilhaArqTemp.desempilha();

                                    if (listarInvertidadesempilha.equals(Obejct)) {
                                        indice++;
                                        vl = (String) listarInvertida.get(indice);
                                        listarInvertidadesempilha = pilhaArqTemp.desempilha();
                                        if (listarInvertidadesempilha.equals(")")) {
                                            indice++;
                                            vl = (String) listarInvertida.get(indice);
                                            listarInvertidadesempilha = pilhaArqTemp.desempilha();
                                            if (listarInvertidadesempilha.equals("{")) {
                                                indice++;
                                                vl = (String) listarInvertida.get(indice);
                                                listarInvertidadesempilha = pilhaArqTemp.desempilha();
                                                if (listarInvertidadesempilha.equals("leia") || listarInvertidadesempilha.equals("escreva")) {
                                                    resultado = defLeiaEScreva(vl);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }

                    } else if (listarInvertidadesempilha.equals(";") || listarInvertidadesempilha.equals(",")) {

                    }
                }
                return resultado;
            }
            indice++;

        }

        return false;

    }

    public boolean defLeiaEScreva(String vl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean defSe() {

        Object obejct;
        while (indice < listarInvertida.size()) {
            String vl = (String) listarInvertida.get(indice);
            listarInvertidadesempilha = pilhaArqTemp.desempilha();
            if (listarInvertidadesempilha.equals("se")) {
                while (indice < listarInvertida.size()) {
                    vl = (String) listarInvertida.get(indice);
                    listarInvertidadesempilha = pilhaArqTemp.desempilha();

                    if (!listarInvertidadesempilha.equals("}")) {
                        indice++;
                        vl = (String) listarInvertida.get(indice);
                        listarInvertidadesempilha = pilhaArqTemp.desempilha();
                        if (listarInvertidadesempilha.equals("(")) {
                            indice++;
                            vl = (String) listarInvertida.get(indice);
                            listarInvertidadesempilha = pilhaArqTemp.desempilha();
                            obejct = (Object) vl;
                            if (listarInvertidadesempilha.equals(obejct)) {
                                indice++;
                                vl = (String) listarInvertida.get(indice);
                                listarInvertidadesempilha = pilhaArqTemp.desempilha();

                                if (listarInvertidadesempilha.equals("!=") || listarInvertidadesempilha.equals("==") | listarInvertidadesempilha.equals("!=")
                                        || listarInvertidadesempilha.equals("<") || listarInvertidadesempilha.equals("<=")
                                        || listarInvertidadesempilha.equals(">") || listarInvertidadesempilha.equals(">=")
                                        || listarInvertidadesempilha.equals("=")) {
                                    indice++;
                                    vl = (String) listarInvertida.get(indice);
                                    listarInvertidadesempilha = pilhaArqTemp.desempilha();
                                    if (listarInvertidadesempilha.equals(obejct)) {
                                        indice++;
                                        vl = (String) listarInvertida.get(indice);
                                        listarInvertidadesempilha = pilhaArqTemp.desempilha();
                                        if (listarInvertidadesempilha.equals(obejct)) {
                                            indice++;
                                            vl = (String) listarInvertida.get(indice);
                                            listarInvertidadesempilha = pilhaArqTemp.desempilha();
                                            if (listarInvertidadesempilha.equals(")")) {
                                                indice++;
                                                vl = (String) listarInvertida.get(indice);
                                                listarInvertidadesempilha = pilhaArqTemp.desempilha();
                                                if (listarInvertidadesempilha.equals("entao")) {
                                                    indice++;
                                                    vl = (String) listarInvertida.get(indice);
                                                    listarInvertidadesempilha = pilhaArqTemp.desempilha();
                                                    if (listarInvertidadesempilha.equals("{")) {
                                                        indice++;
                                                        vl = (String) listarInvertida.get(indice);
                                                        listarInvertidadesempilha = pilhaArqTemp.desempilha();
                                                        if (listarInvertidadesempilha.equals("leia") || listarInvertidadesempilha.equals("escreva")) {
                                                            resultado = defLeiaEScreva(vl);
                                                        }
                                                    }
                                                }

                                            }
                                        }
                                    }

                                }
                            }
                        }
                    }
                }
                indice++;
            }
        }
        indice++;
        return false;

    }

    boolean defSenao() {

        while (indice < listarInvertida.size()) {
            String vl = (String) listarInvertida.get(indice);
            listarInvertidadesempilha = pilhaArqTemp.desempilha();
            if (listarInvertidadesempilha.equals("senao")) {
                while (!vl.equals("}")) {

                    indice++;
                    vl = (String) listarInvertida.get(indice);
                    listarInvertidadesempilha = pilhaArqTemp.desempilha();
                    if (listarInvertidadesempilha.equals("{")) {
                        indice++;
                        vl = (String) listarInvertida.get(indice);
                        listarInvertidadesempilha = pilhaArqTemp.desempilha();
                        resultado = defExpressao(vl, indice);
                        return resultado;
                    }
                    return resultado;
                }

            }
        }
        indice++;
        return false;

    }

    private boolean defExpressao(String vl, int indice1) {
        int indiceExp = indice;
        String varExpr = vl;

        if (varExpr.equals(vl)) {
            while (indiceExp < listarInvertida.size()) {
                indiceExp++;
                vl = (String) listarInvertida.get(indiceExp);
                listarInvertidadesempilha = pilhaArqTemp.desempilha();
                objeto = (String) vl;

                if (vl.equals("!=") || vl.equals("==") | vl.equals("!=")
                        || vl.equals("<") || vl.equals("<=")
                        || vl.equals(">") || vl.equals(">=")
                        || vl.equals("=")) {
                    indiceExp++;
                    vl = (String) listarInvertida.get(indiceExp);
                    listarInvertidadesempilha = pilhaArqTemp.desempilha();

                    objeto = (String) vl;
                    if (listarInvertidadesempilha.equals(objeto)) {
                        indiceExp++;
                        vl = (String) listarInvertida.get(indiceExp);
                        listarInvertidadesempilha = pilhaArqTemp.desempilha();
                        indice++;
                        //+ | - | * | / | ++ | --

                        if (vl.equals("+") || vl.equals("-")
                                || vl.equals("*") || vl.equals("/")
                                || vl.equals("++") || vl.equals("--")) {

                            indiceExp++;
                            vl = (String) listarInvertida.get(indice);
                            listarInvertidadesempilha = pilhaArqTemp.desempilha();
                            objeto = (String) vl;

                            if (listarInvertidadesempilha.equals(objeto)) {
                                indiceExp++;
                                vl = (String) listarInvertida.get(indice);
                                listarInvertidadesempilha = pilhaArqTemp.desempilha();
                                objeto = (String) vl;

                                if (vl.equals(";")) {
                                    return resultado;
                                }
                            }

                        }
                    }
                }
            }
        }
        return false;
        //To change body of generated methods, choose Tools | Templates.
    }

}
