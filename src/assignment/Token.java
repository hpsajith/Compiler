/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author Samith
 */
    public class Token {
           public static enum Type {
        // This Scheme-like language has three token types:
        // open parens, close parens, and an "atom" type
// This Scheme-like language has three token types:
        // open parens, close parens, and an "atom" type
        METHODDECL,OPERATOR,SYNTAX,BINOPERATION,KEYWORD,LPAREN, RPAREN, IDENTIFIER,NUMERICS;
    }
        public final Type t;
        public final String c; // contents mainly for atom tokens
        // could have column and line number fields too, for reporting errors later
        public Token(Type t, String c) {
            this.t = t;
            this.c = c;
        }
        public String toString() {
            if(t == Type.IDENTIFIER) {
                return "IDENTIFIER  <" + c + ">";
            }
            if(t == Type.BINOPERATION) {
                return "BINOPERATION  <" + c + ">";
            }
            if(t == Type.KEYWORD) {
                return "KEYWORD  <" + c + ">";
            }
            if(t == Type.LPAREN) {
                return "LPAREN  <" + c + ">";
            }
            if(t == Type.RPAREN) {
                return "RPAREN  <" + c + ">";
            }
            if(t == Type.SYNTAX) {
                return "SYMBOL  <" + c + ">";
            }
            if(t == Type.OPERATOR) {
                return "OPERATOR  <" + c + ">";
            }
            if(t == Type.NUMERICS) {
                return "NUMERICS  <" + c + ">";
            }
            if(t == Type.METHODDECL) {
                return "METHODDECL  <" + c + ">";
            }
            return t.toString();
        }
    }
