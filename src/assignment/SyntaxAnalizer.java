/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.Set;
import java.util.Stack;

public class SyntaxAnalizer {

    LexicalAnalizer lx = new LexicalAnalizer();

    public SyntaxAnalizer(String inputString) {
        // TODO Auto-generated constructor stub
        String s = inputString;
        lx.getInputString(s);
        s = s.replaceAll("\\s+", "");
        System.out.println(s);
        String c = "";
        Stack st = new Stack();
        String token = "";

        for (int i = 0; i < s.length(); i++) {
            token = String.valueOf(token + s.charAt(i));
            if (lx.methodDeclSet.contains(token)) {
                System.out.println(token);
                st.push(token);
                token = "";
            } else if (lx.lparantheseSet.contains(token)) {
                System.out.println(token);
                st.push(token);
                token = "";
            } else if (lx.keywordSet.contains(token)) {
                System.out.println(token);
                st.push(token);
                token = "";
            } else if (lx.identifierSet.contains(token)) {
                System.out.println(token);
                st.push(token);
                token = "";
            } else if (lx.biOperatorSet.contains(token)) {
                if (lx.incrementOpSet.contains(token + s.charAt(i + 1))) {
                } else {
                    System.out.println(token);
                    st.push(token);
                    token = "";
                }
            } else if (lx.numericalSet.contains(token)) {
                if (lx.numericalSet.contains(token + s.charAt(i + 1))) {
                } else {
                    System.out.println(token);
                    st.push(token);
                    token = "";
                }
            } else if (lx.sybolSet.contains(token)) {
                System.out.println(token);
                st.push(token);
                token = "";
            } else if (lx.operatorSet.contains(token)) {
                System.out.println(token);
                st.push(token);
                token = "";
            } else if (lx.rparantheseSet.contains(token)) {
                System.out.println(token);
                st.push(token);
                token = "";
            } else if (lx.assignOpSet.contains(token)) {
                System.out.println(token);
                st.push(token);
                token = "";
            } else if (lx.incrementOpSet.contains(token)) {
                System.out.println(token);
                st.push(token);
                token = "";
            }
        }

        while (0 < st.size()) {
            c = st.peek().toString();
            if (lx.rparantheseSet.contains(c)) {
                st.pop();
            } else {
                break;
            }
        }

        while (0 < st.size()) {
            c = st.peek().toString();
            if (lx.sybolSet.contains(c)) {
                st.pop();
            } else {
                break;
            }
        }
        while (0 < st.size()) {
            c = st.peek().toString();
            if (lx.identifierSet.contains(c)) {
                st.pop();
            } else {
                break;
            }
        }
        while (0 < st.size()) {
            c = st.peek().toString();
            if (lx.biOperatorSet.contains(c)) {
                st.pop();
            } else {
                break;
            }
        }
        while (0 < st.size()) {
            c = st.peek().toString();
            if (lx.identifierSet.contains(c)) {
                st.pop();
            } else {
                break;
            }
        }
        while (0 < st.size()) {
            c = st.peek().toString();
            if (lx.biOperatorSet.contains(c)) {
                st.pop();
            } else {
                break;
            }
        }
        while (0 < st.size()) {
            c = st.peek().toString();
            if (lx.identifierSet.contains(c)) {
                st.pop();
            } else {
                break;
            }
        }
        while (0 < st.size()) {
            c = st.peek().toString();
            if (lx.keywordSet.contains(c)) {
                st.pop();
            } else {
                break;
            }
        }
        while (0 < st.size()) {
            c = st.peek().toString();
            if (lx.lparantheseSet.contains(c)) {
                st.pop();
            } else {
                break;
            }
        }
        while (0 < st.size()) {
            c = st.peek().toString();
            if (lx.operatorSet.contains(c)) {
                st.pop();
            } else {
                break;
            }
        }
    }
}
