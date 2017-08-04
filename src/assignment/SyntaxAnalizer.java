/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.ArrayList;
import java.util.List;
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

    /*	<program> = <method_declaration> ‘{‘<stmt_list>’}’
	<stmt_list> = <var_decl>* | <stmt>  |  <stmt_list>*
	<var_decl> = <vType> <expr>
	<stmt> = for ‘(’<var_decl> <expr> <increment>’)’ <block>
	<expr> =  <literal><bin_op><literal> ‘;’ |<literal><assign_op><int_lit>‘;’ 
      <literal><assign_op><expr> ‘;’
	<increment> = <literal>< incr_op >
	<block> =  ‘{’ <expr> ‘}’
	<vType> = int | float
	<assign_op> =  ‘=’
	<bin_op> = ‘+’ | ‘<’ | ‘>’
	<incr_op> = ‘++’
	<literal> = CHAR
	<int_lit> = DEC | FLOAT
     */

    private boolean program(String statList) {   
        status = methodDeclare(statList) && lparanthesis(statList) && statList(statList) && rparanthesis(statList);
        return status;
    }

    private boolean statList(String expression) {
        status = variableDeclaration(expression) || statement(expression);
        return status;
    }

    private boolean variableDeclaration(String expression) {
        status = variableType(expression) && expression(expression);
        return status;
    }

    private boolean statement(String statement) {
        status = operator(statement) && lparanthesis(statement) && variableDeclaration(statement)
                && expression(statement, statement, statement)
                && increment(statement) && rparanthesis(statement) && block(statement);
        return status;
    }

    private boolean expression(String literal, String assignOp, String numeric) {
        status = intLit(literal) && binaryOp(assignOp) && literal(numeric) && symbols(numeric)
        || intLit(literal) && assignopera(assignOp) && intLit(numeric) && symbols(numeric)
        || literal(literal) && assignopera(assignOp) && expression(numeric) && symbols(numeric);
        return status;
    }

    private boolean expression(String litera) {
        status = expression(litera, litera, litera);
        return status;
    }

    private boolean increment(String expression) {
        status = literal(expression) && incrementOp(expression);
        return status;
    }

    private boolean block(String block) {
        status = lx.lparantheseSet.contains(block) && lx.keywordSet.contains(block) && lx.rparantheseSet.contains(block);
        return status;
    }

    private boolean variableType(String variableType) {
        status = lx.keywordSet.contains(variableType);
        return status;
    }

    private boolean assignopera(String assignop) {
        status = lx.assignOpSet.contains(assignop);
        return status;
    }

    private boolean binaryOp(String binoperator) {
        status = lx.biOperatorSet.contains(binoperator);
        return status;
    }

    private boolean operator(String operator) {
        status = lx.operatorSet.contains(operator);
        return status;
    }

    private boolean methodDeclare(String methdDecl) {
        status = lx.methodDeclSet.contains(methdDecl);
        return status;
    }

    private boolean incrementOp(String incremntOp) {
        status = lx.incrementOpSet.contains(incremntOp);
        return status;
    }

    private boolean literal(String literals) {
        status = lx.identifierSet.contains(literals);
        return status;
    }

    private boolean intLit(String intLit) {
        status = lx.numericalSet.contains(intLit);
        return status;
    }

    private boolean lparanthesis(String parant) {
        status = lx.lparantheseSet.contains(parant);
        return status;
    }

    private boolean rparanthesis(String parant) {
        status = lx.rparantheseSet.contains(parant);
        return status;
    }
    private boolean symbols(String symbol){
        status = lx.sybolSet.contains(symbol);
        return status;
    }

    /*  public Set<String> keywordSet = new HashSet<String>(Arrays.asList(keywords));
    public Set<String> biOperatorSet = new HashSet<String>(Arrays.asList(biOperators));
    public Set<String> sybolSet = new HashSet<String>(Arrays.asList(syntax));
    public Set<String> lparantheseSet = new HashSet<String>(Arrays.asList(lparantheses));
    public Set<String> rparantheseSet = new HashSet<String>(Arrays.asList(rparantheses));
    public Set<String> operatorSet = new HashSet<String>(Arrays.asList(operators));
    public Set<String> incrementOpSet = new HashSet<String>(Arrays.asList(incrementOp));
    public Set<String> assignOpSet = new HashSet<String>(Arrays.asList(assignOp));
    public Set<String> identifierSet = new HashSet<String>();
    public Set<String> methodDeclSet = new HashSet<String>();
    public Set<String> numericalSet = new HashSet<String>();*/
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
        List<String> tokenList = new ArrayList<String>();
        String token = "";
        Stack st = new Stack();

        for (int i = 0; i < s.length(); i++) {
            token = String.valueOf(token + s.charAt(i));
            if (lx.methodDeclSet.contains(token)) {
                System.out.println(token);
                tokenList.add(token);
                st.push(token);
                token = "";
            } else if (lx.lparantheseSet.contains(token)) {
                System.out.println(token);
                tokenList.add(token);
                st.push(token);
                token = "";
            } else if (lx.keywordSet.contains(token)) {
                System.out.println(token);
                tokenList.add(token);
                st.push(token);
                token = "";
            } else if (lx.identifierSet.contains(token)) {
                System.out.println(token);
                tokenList.add(token);
                st.push(token);
                token = "";
            } else if (lx.biOperatorSet.contains(token)) {
                if (lx.incrementOpSet.contains(token + s.charAt(i + 1))) {
                } else {
                    System.out.println(token);
                    tokenList.add(token);
                    st.push(token);
                    token = "";
                }
            } else if (lx.numericalSet.contains(token)) {
                if (lx.numericalSet.contains(token + s.charAt(i + 1))) {
                } else {
                    System.out.println(token);
                    tokenList.add(token);
                    st.push(token);
                    token = "";
                }
            } else if (lx.sybolSet.contains(token)) {
                System.out.println(token);
                tokenList.add(token);
                st.push(token);
                token = "";
            } else if (lx.operatorSet.contains(token)) {
                System.out.println(token);
                tokenList.add(token);
                st.push(token);
                token = "";
            } else if (lx.rparantheseSet.contains(token)) {
                System.out.println(token);
                tokenList.add(token);
                st.push(token);
                token = "";
            } else if (lx.assignOpSet.contains(token)) {
                System.out.println(token);
                tokenList.add(token);
                st.push(token);
                token = "";
            } else if (lx.incrementOpSet.contains(token)) {
                System.out.println(token);
                tokenList.add(token);
                st.push(token);
                token = "";
            }
        }
        
        //Sysntax parser
        boolean status = syntaxParse(st);
        

        String str = "";
        //Sementic analizer
        for (String tokennn :  tokenList) {
            status =false;
            if (program(tokennn)) {
                status = true;
            } else {
                break;
            }
        }
        System.out.println("Syntax done.."+status);
        System.out.println("");


    }
}
