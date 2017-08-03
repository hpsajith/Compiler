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

    boolean checkParanthesis = false;
    boolean checkSyntax = false;
    boolean checkOperator = false;
    boolean checkAssign = false;
    boolean checkBooleanOperator = false;

    boolean status = false;

    private boolean program(Token methoDeclr, Token statList) {
        String c = null;
        Token literal = new Token(Token.Type.IDENTIFIER, c);
        Token assignOp = new Token(Token.Type.ASSIGNOP, c);
        Token numaral = new Token(Token.Type.NUMERICS, c);
        
                status = statList(statList) || statList(literal,assignOp,numaral);
        return false;
    }

    private boolean statList(Token expression) {
        return false;
    }
    private boolean statList(Token literal,Token assignOp,Token numeric) {
        status = expression(literal) || expression(literal,assignOp,numeric);
        return false;
    }
    private boolean expression(Token expression) {
        return false;
    }
    private boolean expression(Token literal,Token assignOp,Token numeric) {
        status = numeric(literal) && assignopera(assignOp) && literal(numeric) ;
        return false;
    }
    private boolean numeric(Token numeric) {
        return false;
    }
    private boolean literal(Token numeric) {
        return false;
    }
    private boolean assignopera(Token assignop) {
        return false;
    }

    public boolean syntaxParse(Stack st) {

        String c = "";
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
            if (lx.assignOpSet.contains(c)) {
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
            if (lx.lparantheseSet.contains(c)) {
                st.pop();
            } else {
                break;
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
            if (lx.incrementOpSet.contains(c)) {
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
            if (lx.sybolSet.contains(c)) {
                st.pop();
            } else {
                break;
            }
        }
        while (0 < st.size()) {
            c = st.peek().toString();
            if (lx.numericalSet.contains(c)) {
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
            if (lx.sybolSet.contains(c)) {
                st.pop();
            } else {
                break;
            }
        }////////////////////
        while (0 < st.size()) {
            c = st.peek().toString();
            if (lx.numericalSet.contains(c)) {
                st.pop();
            } else {
                break;
            }
        }
        while (0 < st.size()) {
            c = st.peek().toString();
            if (lx.assignOpSet.contains(c)) {
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
            if (lx.numericalSet.contains(c)) {
                st.pop();
            } else {
                break;
            }
        }
        while (0 < st.size()) {
            c = st.peek().toString();
            if (lx.assignOpSet.contains(c)) {
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
            if (lx.sybolSet.contains(c)) {
                st.pop();
            } else {
                break;
            }
        }
        while (0 < st.size()) {
            c = st.peek().toString();
            if (lx.numericalSet.contains(c)) {
                st.pop();
            } else {
                break;
            }
        }//00000000000
        while (0 < st.size()) {
            c = st.peek().toString();
            if (lx.assignOpSet.contains(c)) {
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
            if (lx.methodDeclSet.contains(c)) {
                st.pop();
            } else {
                break;
            }
        }

        return false;
    }

    public void analizerSyntax(String inputString) {
        // TODO Auto-generated constructor stub
        String s = inputString;
        lx.getInputString(s);
        s = s.replaceAll("\\s+", "");
        System.out.println(s);
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
        boolean status = syntaxParse(st);
    }
}
