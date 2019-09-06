/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pblcompiladores;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author carlos
 */
public class AnalisadorSintaticoPBL {

    /**
     * @param args the command line arguments
     *
     *
     */
    String c = null;

    public static void main(String[] args) throws IOException {

        File arq = new File("entrada.txt");
        Pilha pilha = new Pilha();
        PilhaInvertida pilhaInvertida = new PilhaInvertida();
        Scan scan = null;

        try {

            BufferedReader in = new BufferedReader(new FileReader("entrada.txt"));
            String str;

            FileReader fileReader = new FileReader(arq);

            // cria um novo tokenizer
            Reader r = new BufferedReader(fileReader);
            StreamTokenizer st = new StreamTokenizer(r);

            // especifica que os números devem ser analisados
            st.parseNumbers();
            st.eolIsSignificant(true);

            //int token = st.nextToken();
            int t;
            // imprime os tokens de fluxo
            boolean eof = false;

            do {
                int token = st.nextToken();

                switch (token) {
                    case StreamTokenizer.TT_EOF:
                        System.out.println("End of File encountered.");
                        eof = true;
                        break;

                    case StreamTokenizer.TT_EOL:
                        System.out.println(" ");
                        break;

                    case StreamTokenizer.TT_WORD:
                        System.out.println("\ntestando palavra: " + st.sval);
                        String palavra = st.sval;
                        int linha = st.lineno();
                        //String valor = d;
                        //System.out.println("d: " + d);
                        //System.out.println("valor: " + valor);
                        pilha.empilha(palavra, linha);

                        System.out.println("testando linha: " + st.lineno());
                        break;

                    case StreamTokenizer.TT_NUMBER:
                        double num = st.nval;
                        String numero = Double.toString(num);
                        int linha1 = st.lineno();
                        pilha.empilha(numero, linha1);

                        System.out.println("Numero:: " + st.nval);
                        System.out.println("linha: " + st.lineno());
                        break;

                    default:
                        System.out.println((char) token + " encontrado.");
                        System.out.println("linha: " + st.lineno());
                        char outros = (char) token;
                        int linha2 = st.lineno();
                        System.out.println("outros: " + outros);

                        pilha.empilhaCaracter(outros, linha2);

                        if (token == '!') {
                            eof = true;
                        }
                }

                // pushback the last token
                st.pushBack();

                token = st.nextToken();

                switch (token) {
                    case StreamTokenizer.TT_EOF:
                        System.out.println(" ");
                        eof = true;
                        break;

                    case StreamTokenizer.TT_EOL:
                        System.out.println(" ");
                        break;
                    /*
                    case StreamTokenizer.TT_WORD:
                        System.out.println("palavra2: " + st.sval);
                        break;
                     
                    case StreamTokenizer.TT_NUMBER:
                        System.out.println("Numero2: " + st.nval);
                        break;
                     */
                    default:
                        //System.out.println((char) token + "CARLOS.");

                        if (token == '!') {
                            eof = true;
                        }
                }
            } while (!eof);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //imprime pilha
        ArrayList<String> listar = new ArrayList<String>();
        try {
            listar = pilha.listar();
        } catch (EmptyStackException e) {
            System.out.println(e.getMessage());
        }

        for (String vl : listar) {
            pilhaInvertida.empilha(vl);
            System.out.println(vl);
        }

        ArrayList<String> listarInvertida = new ArrayList<String>();

        try {
            listarInvertida = pilhaInvertida.listar();

        } catch (EmptyStackException e) {
            System.out.println(e.getMessage());
        }
        String listarInvertidadesempilha = null;
        int indice = 0;
        boolean resultado;

        while (indice < listarInvertida.size()) {
            String vl = (String) listarInvertida.get(indice);
            listarInvertidadesempilha = pilhaInvertida.desempilha();

            if (listarInvertidadesempilha.equals("programa")) {
                System.out.println("if: " + vl);

            } else if (!listarInvertidadesempilha.equals("programa")) {
                System.out.println("else if: " + vl);
                if (listarInvertidadesempilha.equals("constantes")) {

                    scan.defGlobal(vl);
                }

                if (listarInvertidadesempilha.equals("metodo")) {
                    resultado = scan.defMetodo();
                }

                if (listarInvertidadesempilha.equals("enquanto")) {

                    resultado = scan.defEnquanto(vl);
                }

            } else {
                //erro
            }

            indice++;

            System.out.println("pilha invertida teste: " + vl);
            System.out.println("desempilha invertida teste: " + listarInvertidadesempilha);
        }

    }

}
