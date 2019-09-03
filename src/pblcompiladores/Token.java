/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pblcompiladores;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;

/**
 *
 * @author carlos
 */
public class Token {

    private Integer codigo;
    private String lexema;

    public Token() {

    }

    public Token(String lexema) {
        this.lexema = lexema;
    }

    public Token(Integer codigo, String lexema) {
        this.codigo = codigo;
        this.lexema = lexema;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer();

        sb.append("=-=-=-=-=-=-\n");
        //sb.append("CodigoLexema: ");
        //sb.append(this.getCodigo());
        sb.append("\n");
        sb.append("Token: ");
        sb.append(this.getLexema());
        sb.append("\n=-=-=-=-=-=-\n");

        return sb.toString();
    }

}
