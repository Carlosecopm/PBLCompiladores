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
    public static void main(String[] args) throws IOException {

        File arq = new File("entrada.txt");
        File arqTemp = new File("temp.txt");
        Pilha pilha = new Pilha();
        // PilhaInvertida pilhaInvertida = new PilhaInvertida();
        Scan scan = new Scan();

        try {

            BufferedReader in = new BufferedReader(new FileReader("entrada.txt"));
            String str;

            FileReader fileReader = new FileReader(arq);

            //criando o arquivo de saída fisicamente
            arqTemp.createNewFile();

            //essa linha abre o fluxo do arquivo , true reescreve no arrquivo sem apagar o conteúdo
            FileWriter fileWriter = new FileWriter(arqTemp, false);

            //passamos  o objeto FileReader em seu construtor, para escrevermos fisicamente no arquivo;
            PrintWriter printWriter = new PrintWriter(fileWriter);

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
                        System.out.println("Fim de arquivo encontrado.");

                        eof = true;
                        break;

                    case StreamTokenizer.TT_EOL:
                        System.out.println(" ");
                        break;

                    case StreamTokenizer.TT_WORD:
                        System.out.println("\ntestando palavra: " + st.sval);
                        String palavra = st.sval;
                        int linha = st.lineno();
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

                    default:

                        if (token == '!') {
                            eof = true;
                        }
                }
            } while (!eof);

            ArrayList<String> listar = new ArrayList<String>();

            try {
                listar = pilha.listar();

            } catch (EmptyStackException e) {
                System.out.println(e.getMessage());
            }

            String listarDesempilha = null;
            int indice = 0;
            while (indice < listar.size()) {
                String vl = (String) listar.get(indice);
                listarDesempilha = pilha.desempilha();
                System.out.println("pilha2: " + vl);
                System.out.println("desempilha 2: " + listarDesempilha);
                printWriter.println(vl);
                System.out.println();
                indice++;
            }

            // fechando o arquivo temp
            printWriter.close();
            System.out.println("Chamou Scan");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
