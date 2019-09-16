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
    ArrayList<String> listarPilhaArqTemp = new ArrayList<String>();
    int indice = 0;
    String valor;
    boolean resultado = false;
    Object objeto = null;
    No topo = null;

    public boolean lerArquivo() throws FileNotFoundException, IOException {
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

        ArrayList<String> listar = new ArrayList<String>();
        try {
            listar = pilhaArqTemp.listar();

        } catch (EmptyStackException e) {
            System.out.println(e.getMessage());
        }

        for (String vl : listar) {
            pilhaArqTemp.empilha(vl);
            if (vl.equals("programa")) {
                defPrograma(vl);
            }
            System.out.println("pilha scan:" + vl);

        }
        return false;

    }

    public boolean defPrograma(String vl) throws IOException {
        System.out.println("defPrograma:" + vl);
        listarPilhaArqTemp = pilhaArqTemp.listar();
        
        String local = vl;
        int indiceLocal = 0;
        while (indiceLocal < listarPilhaArqTemp.size()) {
            local = (String) listarPilhaArqTemp.get(indice);
            if (local.equals("{")) {
                indiceLocal++;
                local = (String) listarPilhaArqTemp.get(indice);
                if (local.equals("constantes")) {
                    resultado = defGlobal(local, indiceLocal);

                    if (resultado == true) {
                        return true;
                    } else {
                        return false;
                    }
                }

            }
        }
        indiceLocal++;

        return false;
    }

    public boolean defGlobal(String vl, int indice) throws IOException {
        System.out.println("defGlobal:" + vl);
        String local = vl;
        int indiceLocal = 0;
        if (local.equals("constantes")) {

            indiceLocal++;
            local = (String) listarPilhaArqTemp.get(indiceLocal);
            if (local.equals("{")) {
                resultado = defConstante(local, indiceLocal);
                if (resultado == true) {
                    return true;
                } else {
                    return false;
                }

            }

        } else if (local.equals("metodo")) {
            defMetodo();
        }
        return false;
    }

    /**
     *
     * @param equals
     * @throws IOException
     */
    public boolean defConstante(String local, int indiceLocal) throws IOException {
        System.out.println("defPrograma:" + local);
        String localConst = local;
        int indiceConst = indiceLocal;

        if (localConst.equals("{")) {
            do {

                indiceConst++;
                localConst = (String) listarPilhaArqTemp.get(indiceConst);
                if (localConst.equals("texto") || localConst.equals("inteiro")
                        || localConst.equals("real")
                        || localConst.equals("boleano")) {
                    indiceConst++;
                    localConst = (String) listarPilhaArqTemp.get(indiceConst);
                    objeto = (String) localConst;

                    if (localConst.equals(objeto)) {
                        indiceConst++;
                        localConst = (String) listarPilhaArqTemp.get(indiceConst);

                        if (localConst.equals("=")) {
                            indiceConst++;
                            localConst = (String) listarPilhaArqTemp.get(indiceConst);
                            objeto = (String) localConst;

                            if (localConst.equals(objeto)) {
                                indiceConst++;
                                localConst = (String) listarPilhaArqTemp.get(indiceConst);

                                if (localConst.equals(",")) {
                                    while (local.equals("}"));
                                } else if (localConst.equals(";")) {
                                    return true;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
            } while (local.equals("}"));
        }

        return false;
    }

    public boolean defMetodos(String vl) throws IOException {
        System.out.println("defMetodos:" + vl);
        String localPrincipal = vl;
        if (localPrincipal.equals("principal") || localPrincipal.equals(vl)) {
            while (indice < listarPilhaArqTemp.size()) {
                localPrincipal = (String) listarPilhaArqTemp.get(indice);

                if (localPrincipal.equals("reslutado") || localPrincipal.equals("vazio")) {
                    localPrincipal = (String) listarPilhaArqTemp.get(indice);

                    Object Obejct = (Object) localPrincipal;

                    if (localPrincipal.equals("(")) {
                        localPrincipal = (String) listarPilhaArqTemp.get(indice);

                        if (localPrincipal.equals("texto") || localPrincipal.equals("inteiro")
                                || localPrincipal.equals("real") || localPrincipal.equals("boleano")) {
                            localPrincipal = (String) listarPilhaArqTemp.get(indice);

                            if (localPrincipal.equals(Obejct)) {
                                localPrincipal = (String) listarPilhaArqTemp.get(indice);

                                if (localPrincipal.equals(")")) {
                                    localPrincipal = (String) listarPilhaArqTemp.get(indice);

                                    if (localPrincipal.equals(":")) {
                                        localPrincipal = (String) listarPilhaArqTemp.get(indice);

                                        if (localPrincipal.equals("vazio")
                                                || localPrincipal.equals("resultado")) {
                                            localPrincipal = (String) listarPilhaArqTemp.get(indice);

                                            if (localPrincipal.equals("{")) {
                                                localPrincipal = (String) listarPilhaArqTemp.get(indice);

                                                if (localPrincipal.equals("variaveis")) {
                                                    resultado = defVariaveis(localPrincipal);
                                                    if (resultado == true) {
                                                        return true;
                                                    }
                                                    return false;
                                                }
                                                return false;
                                            }
                                            return false;
                                        }
                                        return false;
                                    }
                                    return false;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            indice++;

        }
        localPrincipal = (String) listarPilhaArqTemp.get(indice);

        if (vl.equals("vazio") || vl.equals("resustado")) {
            indice++;
            localPrincipal = (String) listarPilhaArqTemp.get(indice);

            objeto = (String) localPrincipal;
            if (localPrincipal.equals(objeto)) {
                indice++;
                localPrincipal = (String) listarPilhaArqTemp.get(indice);

                indice++;
                localPrincipal = (String) listarPilhaArqTemp.get(indice);

                if (localPrincipal.equals(";")) {
                    indice++;
                    localPrincipal = (String) listarPilhaArqTemp.get(indice);

                    if (localPrincipal.equals("}")) {
                        return resultado;
                    }
                    return false;
                }
                return false;
            }
            return false;

        }
        return false;
    }

    public boolean defMetodo() throws IOException {

        String localDefMetodo = topo.getValor();
        System.out.println("defMetodo:" + localDefMetodo);
        int indiceMetodo = 0;
        while (indiceMetodo < listarPilhaArqTemp.size()) {
            localDefMetodo = (String) listarPilhaArqTemp.get(indiceMetodo);

            if (localDefMetodo.equals("metodo")) {
                while (!localDefMetodo.equals("}")) {
                    localDefMetodo = (String) listarPilhaArqTemp.get(indiceMetodo);
                    if (localDefMetodo.equals("principal")) {
                        resultado = defMetodos(localDefMetodo);
                        if (resultado == true) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                    Object object = (Object) localDefMetodo;
                    if (localDefMetodo.equals(object)) {
                        resultado = defMetodos(localDefMetodo);
                        if (resultado == true) {
                            return true;
                        } else {
                            return false;
                        }
                    }

                }
            }
            indice++;

        }
        return false;
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
        System.out.println("defVariaveis:" + vl);
        String localVariaveis = vl;

        if (localVariaveis.equals("variaveis")) {
            do {
                localVariaveis = (String) listarPilhaArqTemp.get(indice);

                if (!localVariaveis.equals("}")) {
                    localVariaveis = (String) listarPilhaArqTemp.get(indice);

                    Object Obejct = (Object) vl;
                    if (localVariaveis.equals("(inteiro") || localVariaveis.equals("real")
                            || localVariaveis.equals("texto") || localVariaveis.equals("boleano")) {

                        if (localVariaveis.equals(Obejct)) {
                            localVariaveis = (String) listarPilhaArqTemp.get(indice);

                            if (localVariaveis.equals(";") || localVariaveis.equals(",")) {
                                while (indice < listarPilhaArqTemp.size());
                                return true;
                            }
                            return false;
                        }
                        return false;

                    }
                    return false;
                }
                return true;

            } while (indice < listarPilhaArqTemp.size());

        }
        //To change body of generated methods, choose Tools | Templates.
        return false;
    }

    public boolean defEnquanto(String vl) {
        System.out.println("defEquanto:" + vl);
        String localEnquanto = vl;
        boolean resultado = true;
        if (localEnquanto.equals("enquanto")) {
            do {

                localEnquanto = (String) listarPilhaArqTemp.get(indice);
                indice++;

                if (!localEnquanto.equals("}")) {
                    localEnquanto = (String) listarPilhaArqTemp.get(indice);

                    if (localEnquanto.equals("(")) {
                        indice++;
                        localEnquanto = (String) listarPilhaArqTemp.get(indice);

                        Object Obejct = (Object) vl;

                        if (localEnquanto.equals("(inteiro") || localEnquanto.equals("real")
                                || localEnquanto.equals("texto") || localEnquanto.equals("boleano")) {
                            localEnquanto = (String) listarPilhaArqTemp.get(indice);

                            if (localEnquanto.equals(Obejct)) {
                                localEnquanto = (String) listarPilhaArqTemp.get(indice);

                                //!= | == | < | <= | > | >= | =
                                if (localEnquanto.equals("!=") || localEnquanto.equals("==") || localEnquanto.equals("!=")
                                        || localEnquanto.equals("<") || localEnquanto.equals("<=")
                                        || localEnquanto.equals(">") || localEnquanto.equals(">=")
                                        || localEnquanto.equals("=")) {
                                    indice++;
                                    localEnquanto = (String) listarPilhaArqTemp.get(indice);

                                    if (localEnquanto.equals(Obejct)) {
                                        indice++;
                                        localEnquanto = (String) listarPilhaArqTemp.get(indice);

                                        if (localEnquanto.equals(")")) {
                                            indice++;
                                            localEnquanto = (String) listarPilhaArqTemp.get(indice);

                                            if (localEnquanto.equals("{")) {
                                                indice++;
                                                localEnquanto = (String) listarPilhaArqTemp.get(indice);

                                                if (localEnquanto.equals("leia") || localEnquanto.equals("escreva")) {
                                                    resultado = defLeiaEScreva(vl, indice);
                                                    if (resultado == true) {

                                                        return true;
                                                    } else {
                                                        return false;
                                                    }
                                                }
                                                return false;
                                            }
                                            return false;
                                        }
                                        return false;
                                    }
                                    return false;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;

                    } else if (localEnquanto.equals(";") || localEnquanto.equals(",")) {
                        while (indice < listarPilhaArqTemp.size());
                    }
                }
                return resultado;
            } while (indice < listarPilhaArqTemp.size());

        }

        return false;

    }

    public boolean defLeiaEScreva(String vl, int indice1) {
        System.out.println("defLeiaEscreva:" + vl + indice1);
        String localLeiaEscreva = vl;
        int indiceLeiaEscreva = indice1;
        if (localLeiaEscreva.equals("leia") || localLeiaEscreva.equals("escreva")) {
            indiceLeiaEscreva++;
            localLeiaEscreva = (String) listarPilhaArqTemp.get(indiceLeiaEscreva);

            if (localLeiaEscreva.equals("(")) {
                indiceLeiaEscreva++;
                localLeiaEscreva = (String) listarPilhaArqTemp.get(indiceLeiaEscreva);

                if (localLeiaEscreva.equals(objeto)) {
                    indiceLeiaEscreva++;
                    localLeiaEscreva = (String) listarPilhaArqTemp.get(indiceLeiaEscreva);

                    if (localLeiaEscreva.equals(")")) {
                        indiceLeiaEscreva++;
                        localLeiaEscreva = (String) listarPilhaArqTemp.get(indiceLeiaEscreva);

                        if (localLeiaEscreva.equals(";")) {
                            return true;
                        }
                    }
                }
            }

        }
        return false;
        //To change body of generated methods, choose Tools | Templates.
    }

    public boolean defSe() {
        String vl = topo.getValor();
        System.out.println("defSe:" + vl);
        Object obejct;
        while (indice < listarPilhaArqTemp.size()) {
            vl = (String) listarPilhaArqTemp.get(indice);

            if (vl.equals("se")) {
                while (indice < listarPilhaArqTemp.size()) {
                    vl = (String) listarPilhaArqTemp.get(indice);

                    if (!vl.equals("}")) {
                        indice++;
                        vl = (String) listarPilhaArqTemp.get(indice);

                        if (vl.equals("(")) {
                            indice++;
                            vl = (String) listarPilhaArqTemp.get(indice);

                            obejct = (Object) vl;
                            if (vl.equals(obejct)) {
                                indice++;
                                vl = (String) listarPilhaArqTemp.get(indice);

                                if (vl.equals("!=") || vl.equals("==") | vl.equals("!=")
                                        || vl.equals("<") || vl.equals("<=")
                                        || vl.equals(">") || vl.equals(">=")
                                        || vl.equals("=")) {
                                    indice++;
                                    vl = (String) listarPilhaArqTemp.get(indice);

                                    if (vl.equals(obejct)) {
                                        indice++;
                                        vl = (String) listarPilhaArqTemp.get(indice);

                                        if (vl.equals(obejct)) {
                                            indice++;
                                            vl = (String) listarPilhaArqTemp.get(indice);

                                            if (vl.equals(")")) {
                                                indice++;
                                                vl = (String) listarPilhaArqTemp.get(indice);

                                                if (vl.equals("entao")) {
                                                    indice++;
                                                    vl = (String) listarPilhaArqTemp.get(indice);

                                                    if (vl.equals("{")) {
                                                        indice++;
                                                        vl = (String) listarPilhaArqTemp.get(indice);

                                                        if (vl.equals("leia")) {
                                                            resultado = defLeiaEScreva(vl, indice);

                                                            return resultado;
                                                        } else if (vl.equals("escreva")) {
                                                            resultado = defLeiaEScreva(vl, indice);
                                                            return resultado;
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
        String vl = topo.getValor();
        System.out.println("defSenao:" + vl);
        while (indice < listarPilhaArqTemp.size()) {
            vl = (String) listarPilhaArqTemp.get(indice);

            if (vl.equals("senao")) {
                while (!vl.equals("}")) {

                    indice++;
                    vl = (String) listarPilhaArqTemp.get(indice);

                    if (vl.equals("{")) {
                        indice++;
                        vl = (String) listarPilhaArqTemp.get(indice);

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
        System.out.println("defExp:" + vl);
        int indiceExp = indice;
        String varExpr = vl;

        if (varExpr.equals(vl)) {
            while (indiceExp < listarPilhaArqTemp.size()) {
                indiceExp++;
                vl = (String) listarPilhaArqTemp.get(indiceExp);

                objeto = (String) vl;

                if (vl.equals("!=") || vl.equals("==") | vl.equals("!=")
                        || vl.equals("<") || vl.equals("<=")
                        || vl.equals(">") || vl.equals(">=")
                        || vl.equals("=")) {
                    indiceExp++;
                    vl = (String) listarPilhaArqTemp.get(indiceExp);

                    objeto = (String) vl;
                    if (vl.equals(objeto)) {
                        indiceExp++;
                        vl = (String) listarPilhaArqTemp.get(indiceExp);

                        indiceExp++;
                        //+ | - | * | / | ++ | --

                        if (vl.equals("+") || vl.equals("-")
                                || vl.equals("*") || vl.equals("/")
                                || vl.equals("++") || vl.equals("--")) {

                            indiceExp++;
                            vl = (String) listarPilhaArqTemp.get(indiceExp);

                            objeto = (String) vl;

                            if (vl.equals(objeto)) {
                                indiceExp++;
                                vl = (String) listarPilhaArqTemp.get(indiceExp);

                                objeto = (String) vl;

                                if (vl.equals(";")) {
                                    return true;
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
