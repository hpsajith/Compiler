/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.Set;
import java.util.Stack;

public class ParseTree {

    LexicalAnalizer lx = new LexicalAnalizer();
    int k = 0;

    public ParseTree() {
        // TODO Auto-generated constructor stub
        System.out.println("Please Enter the Simple Assignment");
        String s = "Start{\n"
                + "int a = 10;\n"
                + "float c = 1;\n"
                + "for(int b = 0; b < 5; b++)\n"
                + "{\n"
                + "a = a + c;\n"
                + "}\n"
                + "}";
        lx.getInputString(s);
        //Start{inta=10;floatc=1;for(intb=0;b<5;b++){a=a+c;}}
        s = s.replaceAll("\\s+", "");
        System.out.println(s);
        String c = "";
        Stack st = new Stack();
        String token = "";

        for (int i = 0; i < s.length(); i++) {
            token = String.valueOf(token + s.charAt(i));
            if (lx.methodDeclSet.contains(token)) {
                System.out.println(token);
                st.push(s.charAt(i));
                token = "";
            } else if (lx.lparantheseSet.contains(token)) {
                System.out.println(token);
                st.push(s.charAt(i));
                token = "";
            } else if (lx.keywordSet.contains(token)) {
                System.out.println(token);
                st.push(s.charAt(i));
                token = "";
            } else if (lx.identifierSet.contains(token)) {
                System.out.println(token);
                st.push(s.charAt(i));
                token = "";
            } else if (lx.biOperatorSet.contains(token)) {
                System.out.println(token);
                st.push(s.charAt(i));
                token = "";
            } else if (lx.numericalSet.contains(token)) {
                System.out.println(token);
                st.push(s.charAt(i));
                token = "";
            } else if (lx.sybolSet.contains(token)) {
                System.out.println(token);
                st.push(s.charAt(i));
                token = "";
            } else if (lx.operatorSet.contains(token)) {
                System.out.println(token);
                st.push(s.charAt(i));
                token = "";
            } else if (lx.rparantheseSet.contains(token)) {
                System.out.println(token);
                st.push(s.charAt(i));
                token = "";
            }
        }

        while (0 < st.size()) {
            c = st.peek().toString();
            if (lx.rparantheseSet.contains(c)) {
                k++;
                st.pop();
            } else {
                break;
            }
        }

        while (0 < st.size()) {
            c = st.peek().toString();
            if (lx.sybolSet.contains(c)) {
                k++;
                st.pop();
            } else {
                break;
            }
        }
        while (0 < st.size()) {
            c = st.peek().toString();
            if (lx.identifierSet.contains(c)) {
                k++;
                st.pop();
            } else {
                break;
            }
        }
        while (0 < st.size()) {
            c = st.peek().toString();
            if (lx.biOperatorSet.contains(c)) {
                k++;
                st.pop();
            } else {
                break;
            }
        }
        while (0 < st.size()) {
            c = st.peek().toString();
            if (lx.identifierSet.contains(c)) {
                k++;
                st.pop();
            } else {
                break;
            }
        }
        while (0 < st.size()) {
            c = st.peek().toString();
            if (lx.biOperatorSet.contains(c)) {
                k++;
                st.pop();
            } else {
                break;
            }
        }
        while (0 < st.size()) {
            c = st.peek().toString();
            if (lx.identifierSet.contains(c)) {
                k++;
                st.pop();
            } else {
                break;
            }
        }
        while (0 < st.size()) {
            c = st.peek().toString();
            if (lx.keywordSet.contains(c)) {
                k++;
                st.pop();
            } else {
                break;
            }
        }
        while (0 < st.size()) {
            c = st.peek().toString();
            if (lx.lparantheseSet.contains(c)) {
                k++;
                st.pop();
            } else {
                break;
            }
        }
        while (0 < st.size()) {
            c = st.peek().toString();
            if (lx.operatorSet.contains(c)) {
                k++;
                st.pop();
            } else {
                break;
            }
        }
        if (k == s.length()) {
            System.out.println(" You Entered " + s + "  which is" + " Syntactically TRUE");
        } else {
            System.out.println(" You Entered " + s + "  which is" + " Syntactically FALSE");
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new ParseTree();
    }
}
