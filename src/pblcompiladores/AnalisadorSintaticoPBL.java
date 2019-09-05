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

    Character c = null;
    Scan scan = null;
    String d = null;
    int token;
    StreamTokenizer st;

    /**
     * @param args the command line arguments
     *
     *
     */
    public static void main(String[] args) throws IOException {

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
                        String d = st.sval;
                        //System.out.println("d: " + d);
                        System.out.println("testando linha: " + st.lineno());

                        if (d.equals("programa")) {
                            token = st.nextToken();
                            d = st.sval;
                            if (d.equals("{")) {
                                token = st.nextToken();
                            }

                        }
                        if (d.equals("constantes")) {
                            token = st.nextToken();
                            d = st.sval;

                            if (d.equals("{")) {
                                token = st.nextToken();
                                d = st.sval;

                                if (d.equals("inteiro")) {
                                    token = st.nextToken();
                                    d = st.sval;

                                    if (d.equals("max1")) {
                                        token = st.nextToken();
                                        d = st.sval;

                                        if (d.equals('=')) {
                                            token = st.nextToken();
                                            d = st.sval;

                                            if (d.equals("10")) {
                                                token = st.nextToken();
                                                d = st.sval;

                                                if (d.equals(',')) {
                                                    token = st.nextToken();
                                                    d = st.sval;

                                                    if (d.equals("max2")) {
                                                        token = st.nextToken();
                                                        d = st.sval;

                                                        if (d.equals("=")) {
                                                            token = st.nextToken();
                                                            d = st.sval;

                                                            if (d.equals("20")) {
                                                                token = st.nextToken();
                                                                d = st.sval;
                                                                if (d.equals(";")) {
                                                                    token = st.nextToken();
                                                                    d = st.sval;

                                                                    if (d.equals("metodo")) {
                                                                        token = st.nextToken();
                                                                        d = st.sval;

                                                                        if (d.equals("principal")) {
                                                                            token = st.nextToken();
                                                                            d = st.sval;

                                                                            if (d.equals("(")) {
                                                                                token = st.nextToken();
                                                                                d = st.sval;

                                                                                if (d.equals("texto")) {
                                                                                    token = st.nextToken();
                                                                                    d = st.sval;

                                                                                    if (d.equals("x")) {
                                                                                        token = st.nextToken();
                                                                                        d = st.sval;

                                                                                        if (d.equals(")")) {
                                                                                            token = st.nextToken();
                                                                                            d = st.sval;

                                                                                            if (d.equals(":")) {
                                                                                                token = st.nextToken();
                                                                                                d = st.sval;

                                                                                                if (d.equals("vazio")) {
                                                                                                    token = st.nextToken();
                                                                                                    d = st.sval;

                                                                                                    if (d.equals("{")) {
                                                                                                        token = st.nextToken();
                                                                                                        d = st.sval;

                                                                                                        if (d.equals("variaveis")) {
                                                                                                            token = st.nextToken();
                                                                                                            d = st.sval;

                                                                                                            if (d.equals("{")) {
                                                                                                                token = st.nextToken();
                                                                                                                d = st.sval;

                                                                                                                if (d.equals("inteiro")) {
                                                                                                                    token = st.nextToken();
                                                                                                                    d = st.sval;

                                                                                                                    if (d.equals("i")) {
                                                                                                                        token = st.nextToken();
                                                                                                                        d = st.sval;

                                                                                                                        if (d.equals("}")) {
                                                                                                                            token = st.nextToken();
                                                                                                                            d = st.sval;

                                                                                                                            if (d.equals("enquanto")) {
                                                                                                                                token = st.nextToken();
                                                                                                                                d = st.sval;

                                                                                                                                if (d.equals("(")) {
                                                                                                                                    token = st.nextToken();
                                                                                                                                    d = st.sval;

                                                                                                                                    if (d.equals("i")) {
                                                                                                                                        token = st.nextToken();
                                                                                                                                        d = st.sval;

                                                                                                                                        if (d.equals(">=")) {
                                                                                                                                            token = st.nextToken();
                                                                                                                                            d = st.sval;

                                                                                                                                            if (d.equals("b")) {
                                                                                                                                                token = st.nextToken();
                                                                                                                                                d = st.sval;

                                                                                                                                                if (d.equals(")")) {
                                                                                                                                                    token = st.nextToken();
                                                                                                                                                    d = st.sval;

                                                                                                                                                    if (d.equals("{")) {
                                                                                                                                                        token = st.nextToken();
                                                                                                                                                        d = st.sval;

                                                                                                                                                        if (d.equals("escreva")) {
                                                                                                                                                            token = st.nextToken();
                                                                                                                                                            d = st.sval;

                                                                                                                                                            if (d.equals("(")) {
                                                                                                                                                                token = st.nextToken();
                                                                                                                                                                d = st.sval;

                                                                                                                                                                if (d.equals("i")) {
                                                                                                                                                                    token = st.nextToken();
                                                                                                                                                                    d = st.sval;

                                                                                                                                                                    if (d.equals(")")) {
                                                                                                                                                                        token = st.nextToken();
                                                                                                                                                                        d = st.sval;

                                                                                                                                                                        if (d.equals(";")) {
                                                                                                                                                                            token = st.nextToken();
                                                                                                                                                                            d = st.sval;

                                                                                                                                                                            if (d.equals("leia")) {
                                                                                                                                                                                token = st.nextToken();
                                                                                                                                                                                d = st.sval;

                                                                                                                                                                                if (d.equals("(")) {
                                                                                                                                                                                    token = st.nextToken();
                                                                                                                                                                                    d = st.sval;

                                                                                                                                                                                    if (d.equals("i")) {
                                                                                                                                                                                        token = st.nextToken();
                                                                                                                                                                                        d = st.sval;

                                                                                                                                                                                        if (d.equals(")")) {
                                                                                                                                                                                            token = st.nextToken();
                                                                                                                                                                                            d = st.sval;

                                                                                                                                                                                            if (d.equals(";")) {
                                                                                                                                                                                                token = st.nextToken();
                                                                                                                                                                                                d = st.sval;

                                                                                                                                                                                                if (d.equals("i")) {
                                                                                                                                                                                                    token = st.nextToken();
                                                                                                                                                                                                    d = st.sval;

                                                                                                                                                                                                    if (d.equals("=")) {
                                                                                                                                                                                                        token = st.nextToken();
                                                                                                                                                                                                        d = st.sval;

                                                                                                                                                                                                        if (d.equals("a")) {
                                                                                                                                                                                                            token = st.nextToken();
                                                                                                                                                                                                            d = st.sval;

                                                                                                                                                                                                            if (d.equals("-")) {
                                                                                                                                                                                                                token = st.nextToken();
                                                                                                                                                                                                                d = st.sval;

                                                                                                                                                                                                                if (d.equals("b")) {
                                                                                                                                                                                                                    token = st.nextToken();
                                                                                                                                                                                                                    d = st.sval;

                                                                                                                                                                                                                    if (d.equals(";")) {
                                                                                                                                                                                                                        token = st.nextToken();
                                                                                                                                                                                                                        d = st.sval;

                                                                                                                                                                                                                        if (d.equals("}")) {
                                                                                                                                                                                                                            token = st.nextToken();
                                                                                                                                                                                                                            d = st.sval;

                                                                                                                                                                                                                            if (d.equals("se")) {
                                                                                                                                                                                                                                token = st.nextToken();
                                                                                                                                                                                                                                d = st.sval;

                                                                                                                                                                                                                                if (d.equals("(")) {
                                                                                                                                                                                                                                    token = st.nextToken();
                                                                                                                                                                                                                                    d = st.sval;

                                                                                                                                                                                                                                    if (d.equals("i")) {
                                                                                                                                                                                                                                        token = st.nextToken();
                                                                                                                                                                                                                                        d = st.sval;

                                                                                                                                                                                                                                        if (d.equals(">")) {
                                                                                                                                                                                                                                            token = st.nextToken();
                                                                                                                                                                                                                                            d = st.sval;

                                                                                                                                                                                                                                            if (d.equals("b")) {
                                                                                                                                                                                                                                                token = st.nextToken();
                                                                                                                                                                                                                                                d = st.sval;

                                                                                                                                                                                                                                                if (d.equals(")")) {
                                                                                                                                                                                                                                                    token = st.nextToken();
                                                                                                                                                                                                                                                    d = st.sval;

                                                                                                                                                                                                                                                    if (d.equals("entao")) {
                                                                                                                                                                                                                                                        token = st.nextToken();
                                                                                                                                                                                                                                                        d = st.sval;

                                                                                                                                                                                                                                                        if (d.equals("{")) {
                                                                                                                                                                                                                                                            token = st.nextToken();
                                                                                                                                                                                                                                                            d = st.sval;

                                                                                                                                                                                                                                                            if (d.equals("{")) {
                                                                                                                                                                                                                                                                token = st.nextToken();
                                                                                                                                                                                                                                                                d = st.sval;

                                                                                                                                                                                                                                                                if (d.equals("escreva")) {
                                                                                                                                                                                                                                                                    token = st.nextToken();
                                                                                                                                                                                                                                                                    d = st.sval;

                                                                                                                                                                                                                                                                    if (d.equals("(")) {
                                                                                                                                                                                                                                                                        token = st.nextToken();
                                                                                                                                                                                                                                                                        d = st.sval;

                                                                                                                                                                                                                                                                        if (d.equals("i")) {
                                                                                                                                                                                                                                                                            token = st.nextToken();
                                                                                                                                                                                                                                                                            d = st.sval;

                                                                                                                                                                                                                                                                            if (d.equals(")")) {
                                                                                                                                                                                                                                                                                token = st.nextToken();
                                                                                                                                                                                                                                                                                d = st.sval;

                                                                                                                                                                                                                                                                                if (d.equals(";")) {
                                                                                                                                                                                                                                                                                    token = st.nextToken();
                                                                                                                                                                                                                                                                                    d = st.sval;

                                                                                                                                                                                                                                                                                    if (d.equals("leia")) {
                                                                                                                                                                                                                                                                                        token = st.nextToken();
                                                                                                                                                                                                                                                                                        d = st.sval;

                                                                                                                                                                                                                                                                                        if (d.equals("(")) {
                                                                                                                                                                                                                                                                                            token = st.nextToken();
                                                                                                                                                                                                                                                                                            d = st.sval;

                                                                                                                                                                                                                                                                                            if (d.equals("i")) {
                                                                                                                                                                                                                                                                                                token = st.nextToken();
                                                                                                                                                                                                                                                                                                d = st.sval;

                                                                                                                                                                                                                                                                                                if (d.equals(")")) {
                                                                                                                                                                                                                                                                                                    token = st.nextToken();
                                                                                                                                                                                                                                                                                                    d = st.sval;

                                                                                                                                                                                                                                                                                                    if (d.equals(";")) {
                                                                                                                                                                                                                                                                                                        token = st.nextToken();
                                                                                                                                                                                                                                                                                                        d = st.sval;

                                                                                                                                                                                                                                                                                                        if (d.equals("i")) {
                                                                                                                                                                                                                                                                                                            token = st.nextToken();
                                                                                                                                                                                                                                                                                                            d = st.sval;

                                                                                                                                                                                                                                                                                                            if (d.equals("=")) {
                                                                                                                                                                                                                                                                                                                token = st.nextToken();
                                                                                                                                                                                                                                                                                                                d = st.sval;

                                                                                                                                                                                                                                                                                                                if (d.equals("a")) {
                                                                                                                                                                                                                                                                                                                    token = st.nextToken();
                                                                                                                                                                                                                                                                                                                    d = st.sval;

                                                                                                                                                                                                                                                                                                                    if (d.equals("+")) {
                                                                                                                                                                                                                                                                                                                        token = st.nextToken();
                                                                                                                                                                                                                                                                                                                        d = st.sval;

                                                                                                                                                                                                                                                                                                                        if (d.equals("b")) {
                                                                                                                                                                                                                                                                                                                            token = st.nextToken();
                                                                                                                                                                                                                                                                                                                            d = st.sval;

                                                                                                                                                                                                                                                                                                                            if (d.equals(";")) {
                                                                                                                                                                                                                                                                                                                                token = st.nextToken();
                                                                                                                                                                                                                                                                                                                                d = st.sval;

                                                                                                                                                                                                                                                                                                                                if (d.equals("}")) {
                                                                                                                                                                                                                                                                                                                                    token = st.nextToken();
                                                                                                                                                                                                                                                                                                                                    d = st.sval;

                                                                                                                                                                                                                                                                                                                                    if (d.equals("senao")) {
                                                                                                                                                                                                                                                                                                                                        token = st.nextToken();
                                                                                                                                                                                                                                                                                                                                        d = st.sval;

                                                                                                                                                                                                                                                                                                                                        if (d.equals("{")) {
                                                                                                                                                                                                                                                                                                                                            token = st.nextToken();
                                                                                                                                                                                                                                                                                                                                            d = st.sval;

                                                                                                                                                                                                                                                                                                                                            if (d.equals("i")) {
                                                                                                                                                                                                                                                                                                                                                token = st.nextToken();
                                                                                                                                                                                                                                                                                                                                                d = st.sval;

                                                                                                                                                                                                                                                                                                                                                if (d.equals("=")) {
                                                                                                                                                                                                                                                                                                                                                    token = st.nextToken();
                                                                                                                                                                                                                                                                                                                                                    d = st.sval;

                                                                                                                                                                                                                                                                                                                                                    if (d.equals("i")) {
                                                                                                                                                                                                                                                                                                                                                        token = st.nextToken();
                                                                                                                                                                                                                                                                                                                                                        d = st.sval;

                                                                                                                                                                                                                                                                                                                                                        if (d.equals("-")) {
                                                                                                                                                                                                                                                                                                                                                            token = st.nextToken();
                                                                                                                                                                                                                                                                                                                                                            d = st.sval;

                                                                                                                                                                                                                                                                                                                                                            if (d.equals("b")) {
                                                                                                                                                                                                                                                                                                                                                                token = st.nextToken();
                                                                                                                                                                                                                                                                                                                                                                d = st.sval;

                                                                                                                                                                                                                                                                                                                                                                if (d.equals("b")) {
                                                                                                                                                                                                                                                                                                                                                                    token = st.nextToken();
                                                                                                                                                                                                                                                                                                                                                                    d = st.sval;

                                                                                                                                                                                                                                                                                                                                                                    if (d.equals("}")) {
                                                                                                                                                                                                                                                                                                                                                                        token = st.nextToken();
                                                                                                                                                                                                                                                                                                                                                                        d = st.sval;

                                                                                                                                                                                                                                                                                                                                                                        if (d.equals("resultado")) {
                                                                                                                                                                                                                                                                                                                                                                            token = st.nextToken();
                                                                                                                                                                                                                                                                                                                                                                            d = st.sval;

                                                                                                                                                                                                                                                                                                                                                                            if (d.equals("i")) {
                                                                                                                                                                                                                                                                                                                                                                                token = st.nextToken();
                                                                                                                                                                                                                                                                                                                                                                                d = st.sval;

                                                                                                                                                                                                                                                                                                                                                                                if (d.equals(";")) {
                                                                                                                                                                                                                                                                                                                                                                                    token = st.nextToken();
                                                                                                                                                                                                                                                                                                                                                                                    d = st.sval;

                                                                                                                                                                                                                                                                                                                                                                                    if (d.equals("}")) {
                                                                                                                                                                                                                                                                                                                                                                                        token = st.nextToken();
                                                                                                                                                                                                                                                                                                                                                                                        d = st.sval;

                                                                                                                                                                                                                                                                                                                                                                                        if (d.equals("}")) {
                                                                                                                                                                                                                                                                                                                                                                                            token = st.nextToken();
                                                                                                                                                                                                                                                                                                                                                                                            d = st.sval;

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

                        }
                        break;

                    case StreamTokenizer.TT_NUMBER:
                        System.out.println("Numero:: " + st.nval);
                        System.out.println("linha: " + st.lineno());
                        break;

                    default:
                        System.out.println((char) token + " encountered.");
                        System.out.println("linha: " + st.lineno());

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
                     */
                    case StreamTokenizer.TT_NUMBER:
                        System.out.println("Numero2: " + st.nval);
                        break;

                    default:
                        System.out.println((char) token + " \n");

                        if (token == '!') {
                            eof = true;
                        }
                }
            } while (!eof);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void constantes(String d) throws IOException {
        //To change body of generated methods, choose Tools | Templates.
        String constante = d;
        if (constante.equals("inteiro")) {
        }
    }

}
