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

    public boolean analizerSyntax(String inputString) {
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
        System.out.println("SEMENTICS STARTS" + st.size());
        status = program(st);
        System.out.println("SEMENTICS STOPPED" + st.size());
        // status = syntaxParse(st);
        return status;
    }

    private boolean program(Stack st) {

        boolean rparanthesis = false;
        boolean statList = false;
        boolean lparanthesis = false;
        boolean methodDeclare = false;

        while (0 < st.size()) {
            if (!rparanthesis && rparanthesis(st)) {
                rparanthesis = true;
            } else if (!statList && statList(st)) {
                statList = true;
            } else if (!lparanthesis && lparanthesis(st)) {
                lparanthesis = true;
            } else if (!methodDeclare && methodDeclare(st)) {
                methodDeclare = true;
            } else {
                break;
            }
        }
//        status = methodDeclare && lparanthesis && statList && rparanthesis;
        status = methodDeclare && lparanthesis && statList && rparanthesis;
        return status;
    }

    private boolean statList(Stack expression) {
        boolean statement = false;
        boolean variableDeclaration = false;

        while (0 < expression.size()) {
            if (!statement && statement(expression)) {
                statement = true;
//                st.pop();
            } else if (!variableDeclaration && variableDeclaration(expression)) {
                variableDeclaration = true;
//                st.pop();
            } else {
                break;
            }
        }
        status = variableDeclaration || statement;
        return status;
    }

    private boolean variableDeclaration(Stack exp) {
        boolean expression = false;
        boolean variableType = false;

        while (0 < exp.size()) {
            if (!expression && expression(exp)) {
                expression = true;
//                st.pop();
            } else if (!variableType && variableType(exp)) {
                variableType = true;
//                st.pop();
            } else {
                break;
            }
        }
        status = variableType && expression;
        return status;
    }

    private boolean statement(Stack statement) {
        boolean operator = false;
        boolean lparanthesis = false;
        boolean variableDeclaration = false;
        boolean expression = false;
        boolean increment = false;
        boolean rparanthesis = false;
        boolean block = false;

        while (0 < statement.size()) {
            if (!block && block(statement)) {
                block = true;
            } else if (!rparanthesis && rparanthesis(statement)) {
                rparanthesis = true;
            } else if (!increment && increment(statement)) {
                increment = true;
            } else if (!expression && expression(statement)) {
                expression = true;
            } else if (!variableDeclaration && variableDeclaration(statement)) {
                variableDeclaration = true;
            } else if (!lparanthesis && lparanthesis(statement)) {
                lparanthesis = true;
            } else if (!operator && operator(statement)) {
                operator = true;
            } else {
                break;
            }
        }
        status = operator && lparanthesis && variableDeclaration
                && expression && increment && rparanthesis && block;
        return status;
    }

    private boolean expression(Stack exp) {
        boolean symbols = false;
        boolean literal = false;
        boolean binaryOp = false;
        boolean intLit = false;
        boolean assignopera = false;
        boolean expression = false;

        while (0 < exp.size()) {
            if (!symbols && symbols(exp)) {
                symbols = true;
                while (0 < exp.size()) {
                    if ((!literal && literal(exp)) || (!intLit && intLit(exp)) || !expression && expression(exp)) {
                        expression = true;
                        while (0 < exp.size()) {
                            if ((!binaryOp && binaryOp(exp)) || (!assignopera && assignopera(exp))) {
                                if ((!intLit && intLit(exp)) || (!literal && literal(exp))) {
                                    intLit = true;
                                    binaryOp = true;
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    } else {
                        break;
                    }
                }
            } else {
                break;
            }
        }
        status = intLit && binaryOp && literal && symbols
                || intLit && assignopera && intLit && symbols
                || literal && assignopera && expression && symbols;
        return status;
    }

    private boolean increment(Stack expres) {
        boolean incrementOp = false;
        boolean literal = false;

        while (0 < expres.size()) {
            if (!incrementOp && incrementOp(expres)) {
                incrementOp = true;
            } else if (!literal && literal(expres)) {
                literal = true;
            } else {
                break;
            }
        }
        status = literal && incrementOp;
        return status;
    }

    private boolean block(Stack block) {
        String c = "";
        boolean st1 = false;
        boolean st2 = false;
        boolean st3 = false;

        while (0 < block.size()) {
            c = block.peek().toString();
            if (!st1 && lx.rparantheseSet.contains(c)) {
                st1 = true;
                block.pop();
            } else if (!st2 && lx.keywordSet.contains(c)) {
                st2 = true;
                block.pop();
            } else if (!st3 && lx.lparantheseSet.contains(c)) {
                st3 = true;
                block.pop();
            } else {
                break;
            }
        }
        //status = lx.lparantheseSet.contains(block) && lx.keywordSet.contains(block) && lx.rparantheseSet.contains(block);
        status = st2 && st2 && st1;
        return status;
    }

    private boolean variableType(Stack variableType) {
        String c = "";
        boolean st1 = false;
        while (0 < variableType.size()) {
            c = variableType.peek().toString();
            if (!st1 && lx.keywordSet.contains(c)) {
                st1 = true;
                variableType.pop();
            } else {
                break;
            }
        }
//        status = lx.keywordSet.contains(variableType);
        status = st1;
        return status;
    }

    private boolean assignopera(Stack assignop) {
        String c = "";
        boolean st1 = false;
        while (0 < assignop.size()) {
            c = assignop.peek().toString();
            if (!st1 && lx.assignOpSet.contains(c)) {
                st1 = true;
                assignop.pop();
            } else {
                break;
            }
        }
//        status = lx.assignOpSet.contains(assignop);
        status = st1;
        return status;
    }

    private boolean binaryOp(Stack binoperator) {
        String c = "";
        boolean st1 = false;
        while (0 < binoperator.size()) {
            c = binoperator.peek().toString();
            if (!st1 && lx.biOperatorSet.contains(c)) {
                st1 = true;
                binoperator.pop();
            } else {
                break;
            }
        }
//        status = lx.biOperatorSet.contains(binoperator);
        status = st1;
        return status;
    }

    private boolean operator(Stack operator) {
        String c = "";
        boolean st1 = false;
        while (0 < operator.size()) {
            c = operator.peek().toString();
            if (!st1 && lx.operatorSet.contains(c)) {
                st1 = true;
                operator.pop();
            } else {
                break;
            }
        }
//        status = lx.operatorSet.contains(operator);
        status = st1;
        return status;
    }

    private boolean methodDeclare(Stack methdDecl) {
        String c = "";
        boolean st1 = false;
        while (0 < methdDecl.size()) {
            c = methdDecl.peek().toString();
            if (!st1 && lx.methodDeclSet.contains(c)) {
                st1 = true;
                methdDecl.pop();
            } else {
                break;
            }
        }
//        status = lx.methodDeclSet.contains(methdDecl);
        status = st1;
        return status;
    }

    private boolean incrementOp(Stack incremntOp) {
        String c = "";
        boolean st1 = false;
        while (0 < incremntOp.size()) {
            c = incremntOp.peek().toString();
            if (!st1 && lx.incrementOpSet.contains(c)) {
                st1 = true;
                incremntOp.pop();
            } else {
                break;
            }
        }
//        status = lx.incrementOpSet.contains(incremntOp);
        status = st1;
        return status;
    }

    private boolean literal(Stack literals) {
        String c = "";
        boolean st1 = false;
        while (0 < literals.size()) {
            c = literals.peek().toString();
            if (!st1 && lx.identifierSet.contains(c)) {
                st1 = true;
                literals.pop();
            } else {
                break;
            }
        }
//        status = lx.identifierSet.contains(literals);
        status = st1;
        return status;
    }

    private boolean intLit(Stack intLit) {
        String c = "";
        boolean st1 = false;
        while (0 < intLit.size()) {
            c = intLit.peek().toString();
            if (!st1 && lx.numericalSet.contains(c)) {
                st1 = true;
                intLit.pop();
            } else {
                break;
            }
        }
//        status = lx.numericalSet.contains(intLit);
        status = st1;
        return status;
    }

    private boolean lparanthesis(Stack parant) {
        String c = "";
        boolean st1 = false;
        while (0 < parant.size()) {
            c = parant.peek().toString();
            if (!st1 && lx.lparantheseSet.contains(c)) {
                st1 = true;
                parant.pop();
            } else {
                break;
            }
        }
//        status = lx.lparantheseSet.contains(parant);
        status = st1;
        return status;
    }

    private boolean rparanthesis(Stack parant) {
        String c = "";
        boolean st1 = false;
        while (0 < parant.size()) {
            c = parant.peek().toString();
            if (!st1 && lx.rparantheseSet.contains(c)) {
                st1 = true;
                parant.pop();
            } else {
                break;
            }
        }
//        status = lx.rparantheseSet.contains(parant);
        status = st1;
        return status;
    }

    private boolean symbols(Stack symbol) {
        String c = "";
        boolean st1 = false;
        while (0 < symbol.size()) {
            c = symbol.peek().toString();
            if (!st1 && lx.sybolSet.contains(c)) {
                st1 = true;
                symbol.pop();
            } else {
                break;
            }
        }
//        status = lx.sybolSet.contains(symbol);
        status = st1;
        return status;
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

}
