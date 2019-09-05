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

    private FileInputStream fis;
    private InputStreamReader isr;
    private PushbackReader pbr;
    public List<Character> letra = new ArrayList<Character>();
    public List<Integer> digito = new ArrayList<Integer>();
    Token token = null;
    Character c;

    public Scan(String path) throws FileNotFoundException {

        this.fis = new FileInputStream(path);
        this.isr = new InputStreamReader(this.fis);
        this.pbr = new PushbackReader(isr);

    }

    public Character obterCharacter() throws IOException {

        Character c = null;
        int i = this.pbr.read();

        if (i != -1) {
            c = (char) i;
        }

        return c;
    }

    public void devolverCharacter(Character c) throws IOException {

        this.pbr.unread(c);
    }

    public Token getToken() throws IOException, EOFException {

        /*do while recebe os lexemas do arquivo e verificam se fazem parte da
          estrutura léxica da linguagem ou não
         */
        do {
            String lexema = new String();
            c = this.obterCharacter();

            if (c == null) {
                throw new EOFException();
            }

            if (Character.isLetter(c) || c.equals('_')) {
                lexema = lexema + c;
                c = this.obterCharacter();

                while (Character.isLetter(c) || Character.isDigit(c) || c.equals('_')) {
                    lexema = lexema + c;
                    c = this.obterCharacter();

                }
                this.devolverCharacter(c);
                token = new Token(lexema);
                ScanUtil.lookUp(token);
                break;
            }
            if (Character.isDigit(c)) {
                lexema = lexema + c;
                c = this.obterCharacter();

                while (Character.isDigit(c)) {
                    lexema = lexema + c;
                    this.obterCharacter();
                }
                this.devolverCharacter(c);
                token = new Token(ScanUtil.PALAVRA_RESERVADA, lexema);
                break;
            }

            if (c.equals("programa")) {
                token.equals(getToken());

                if (c.equals('{')) {
                    defGlobal(c.equals(getToken()));
                } else {
                    //ERRO
                }

                //  token = new Token(ScanUtil.OPERADOR_ARITMETICO, c.toString());
                break;
            } else if (!c.equals("programa")) {
                if(c.equals('{')){
                    c.equals(getToken());
                    if(c.equals("constantes")){
                        
                        defConstante(c.equals(getToken()));
                    }
                }
            } else if (c.equals("inteiro") || c.equals("real") || c.equals("texto") || c.equals("booleano")) {
                tipo();
                c.equals(getToken());
                // token = new Token(ScanUtil.DELIMITADOR, c.toString());
                break;
            }
            /* Operadores Relacionais != | == | < | <= | > | >= | =
            if (c.equals("!=") || c.equals("==") || c.equals("<") || c.equals("<=") || c.equals(">")
                    || c.equals(">=") || c.equals("=")) {
                token = new Token(ScanUtil.OPERADOR_RELACIONAL, c.toString());
                break;
            }
            //Operadores Lógico ! | && | || 
            if (c.equals('!') || c.equals("&&") || c.equals("||")) {
                token = new Token(ScanUtil.OPERADOR_LÓGICO, c.toString());
                break;
            }
            Verifica Identificadores
            */

        } while (Character.isSpace(c));

        return token;
    }

    public FileInputStream getFis() {
        return fis;
    }

    public void defGlobal(boolean equals) throws IOException {
        c.equals(getToken());
        if (c.equals("constantes")) {
           // defConstante(c.equals(getToken()));
            c.equals(getToken());

            if (c.equals("principal")) {
                defPrincipal(c.equals("principal"));
                c.equals(getToken());

                if (c.equals("global")) {
                    defGlobal2();
                    c.equals(getToken());
                } else {
                    //ERRO
                }
            } else {
                //ERRO
            }

        }
    }

    public void defConstante(boolean equals) throws IOException {
        if (c.equals("constates")) {
            if (c.equals('{')) {
                listaConstate();
                c.equals(getToken());

            }
        }
        return;
    }

    public void defPrincipal(boolean equals) throws IOException {
        if (c.equals("metodo")) {
            if (c.equals("principal")) {
                if (c.equals('(')) {
                    listaParametro();
                    if (c.equals(')')) {
                        if (c.equals(';')) {
                            tipo();
                            if (c.equals('{')) {
                                declaracao();
                            }
                        }
                    }
                }
            }
        }
        return;
    }

    private void defGlobal2() throws IOException {
        if (c.equals("global")) {
            c.equals(getToken());
            if (c.equals("metodo")) {
                defMetodo();
                c.equals(getToken());
                if (c.equals("global")) {
                    defGlobal2();
                    c.equals(getToken());
                } else {
                    //ERRO
                }
            } else {
                //ERRO
            }

        } else {
            //ERRO
        }
        return;
    }

    private void defMetodo() {
        //To change body of generated methods, choose Tools | Templates.
        return;
    }

    public void tipo() throws IOException {
        //To change body of generated methods, choose Tools | Templates.
        if(c.equals("tipo")){
            tipoId(c.equals("tipo"));
            c.equals(getToken());
        }
        return;
    }

    public String tipoId(boolean equals) throws IOException {
        c.equals(getToken());
        if (c.equals("inteiro")) {
            c.equals(getToken());
        } else if (c.equals("real")) {
            c.equals(getToken());
        } else if (c.equals("texto")) {
            c.equals(getToken());
        } else if (c.equals("boleano")) {

        } else {
            //erro
        }
        return null;
    }

    public void valor() {
        for (char a = 'a'; a <= 'z'; a++) {
            letra.add(Character.valueOf(a));  // sem autoboxing
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
        String tipoId;
        String identificador;

        tipoId = tipoId(c.equals("tipo"));
        //concatenar com identificador

        listaParametro2();
        return;
    }

    public void listaParametro2() throws IOException {
        if (c.equals(',')) {
            String tipoId;
            tipoId = tipoId(c.equals("tipo"));
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

    private void atribuicao() {
        //To change body of generated methods, choose Tools | Templates.
        return;
    }

    private void listaArgumentos2() throws IOException {
        if (c.equals(',')) {
            String tipoId;
            tipoId = tipoId(c.equals("tipo"));
            //concatenar com identificador
            listaArgumentos2();

        }
        return;
    }

    //Constantes
    private void listaConstate() throws IOException {
        constante();
        return;
    }

    private void constante() throws IOException {
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
        listaATribuicaoConstante();
        if (c.equals("identificador")) {
            String c = " = ";
            valor();
        }
        return;
    }

    public void listaATribuicaoConstante() {
        if (c.equals(';')) {
            atribuicaoConstate();
        }
        return;
    }

    private void declaracao() {
        //To change body of generated methods, choose Tools | Templates.
        return;
    }

}
