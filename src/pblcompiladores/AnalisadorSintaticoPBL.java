/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pblcompiladores;

import java.io.*;
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
    public static void main(String[] args) {

        File arq = new File("entrada.txt");

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

            int token = st.nextToken();
            int t;
            // imprime os tokens de fluxo
            boolean eof = false;

            while ((t = st.nextToken()) != StreamTokenizer.TT_EOF) {

                // pega o último token
                st.pushBack();

                token = st.nextToken();

                switch (token) {
                    case StreamTokenizer.TT_EOF:
                        System.out.println("");
                        System.out.println("Linha No. " + st.lineno());
                        eof = true;
                        break;

                    case StreamTokenizer.TT_EOL:
                        System.out.println("");
                        System.out.println("Linha No. " + st.lineno());
                        break;

                    case StreamTokenizer.TT_WORD:
                        System.out.println("palavra: " + st.sval);
                        System.out.println("Linha No. " + st.lineno());
                        break;

                    case StreamTokenizer.TT_NUMBER:
                        System.out.println("Numero: " + st.nval);
                        System.out.println("Linha No. " + st.lineno());
                        break;

                    default:
                        System.out.println((char) token + " \n");

                        if (token == '!') {
                            eof = true;
                        }
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
