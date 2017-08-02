/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Samith
 */
public class LexicalAnalizer {

    ArrayList<Token> syntaxList = new ArrayList<Token>();
    ArrayList<Token> paranthesList = new ArrayList<Token>();
    ArrayList<Token> keyWordList = new ArrayList<Token>();
    ArrayList<Token> binaryOperation = new ArrayList<Token>();
    ArrayList<Token> operatorList = new ArrayList<Token>();
    ArrayList<Token> identifierList = new ArrayList<Token>();
    ArrayList<Token> numericals = new ArrayList<Token>();
    ArrayList<Token> methodDeclarationList = new ArrayList<Token>();
//    ArrayList<String> matchedList = new ArrayList<String>();
    private String[] keywords = {"int", "float"};
    private String[] biOperators = {"=", "+", "++", "<", ">"};
    private String[] syntax = {";"};
    private String[] lparantheses = {"(", "{"};
    private String[] rparantheses = {")", "}"};
    private String[] operators = {"for"};
    public Set<String> keywordSet = new HashSet<String>(Arrays.asList(keywords));
    public Set<String> biOperatorSet = new HashSet<String>(Arrays.asList(biOperators));
    public Set<String> sybolSet = new HashSet<String>(Arrays.asList(syntax));
    public Set<String> lparantheseSet = new HashSet<String>(Arrays.asList(lparantheses));
    public Set<String> rparantheseSet = new HashSet<String>(Arrays.asList(rparantheses));
    public Set<String> operatorSet = new HashSet<String>(Arrays.asList(operators));
    public Set<String> identifierSet = new HashSet<String>();
    public Set<String> methodDeclSet = new HashSet<String>();
    public Set<String> numericalSet = new HashSet<String>();
    private Set<String> tokens;

    HashMap<String, ArrayList<Integer>> keywordsTable;

    public ArrayList<Token> getInputString(String inputString) {
        ArrayList<Token> arrList = new ArrayList<Token>();
        tokonizeMethodDeclaration(inputString);
        tokonizePanthesiz(inputString);
        tokonizeSyntax(inputString);
        tokonizeKeyWords(inputString);
        tokonizeBinaryOperation(inputString);
        tokonizeOperator(inputString);
        tokonizeIdentifiers(inputString);

        for (Token t : methodDeclarationList) {
            arrList.add(t);
            System.out.println(t.toString());
        }
        for (Token t : paranthesList) {
            arrList.add(t);
            System.out.println(t.toString());
        }
        for (Token t : keyWordList) {
            arrList.add(t);
            System.out.println(t.toString());
        }
        for (Token t : binaryOperation) {
            arrList.add(t);
            System.out.println(t.toString());
        }
        for (Token t : operatorList) {
            arrList.add(t);
            System.out.println(t.toString());
        }
        for (Token t : identifierList) {
            arrList.add(t);
            System.out.println(t.toString());
        }
        for (Token t : numericals) {
            arrList.add(t);
            System.out.println(t.toString());
        }
        return arrList;
    }

    public ArrayList<Token> tokonizePanthesiz(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            if (lparantheseSet.contains(String.valueOf(inputString.charAt(i)))) {
                paranthesList.add(new Token(Token.Type.LPAREN, inputString.charAt(i) + ""));
            }
            if (rparantheseSet.contains(String.valueOf(inputString.charAt(i)))) {
                paranthesList.add(new Token(Token.Type.RPAREN, inputString.charAt(i) + ""));
            }
        }
        return paranthesList;
    }

    public ArrayList<Token> tokonizeKeyWords(String inputString) {

        String[] str = inputString.split("\\s+");
        for (int i = 0; i < str.length; i++) {
            if (keywordSet.contains(str[i])) {
                keyWordList.add(new Token(Token.Type.KEYWORD, str[i]));
            }
        }
        return keyWordList;
    }

    public ArrayList<Token> tokonizeBinaryOperation(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            if (biOperatorSet.contains(inputString.charAt(i) + "")) {
                if (biOperatorSet.contains(inputString.charAt(i + 1) + "")) {
                    binaryOperation.add(new Token(Token.Type.BINOPERATION, inputString.charAt(i) + "" + inputString.charAt(i + 1) + ""));
                }
                binaryOperation.add(new Token(Token.Type.BINOPERATION, inputString.charAt(i) + ""));
            }
        }
        return binaryOperation;
    }

    public ArrayList<Token> tokonizeSyntax(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            if (sybolSet.contains(inputString.charAt(i) + "")) {
                syntaxList.add(new Token(Token.Type.SYNTAX, inputString.charAt(i) + ""));
            }
        }
        return syntaxList;
    }

    public ArrayList<Token> tokonizeOperator(String inputString) {
        String[] str = inputString.split("\\s+");
        String temp = "";
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[i].length(); j++) {
                temp = temp + str[i].charAt(j) + "";
                if (operatorSet.contains(temp)) {
                    operatorList.add(new Token(Token.Type.OPERATOR, temp));
                    temp = "";
                }
            }
            temp = "";
        }
        return operatorList;
    }

    public ArrayList<Token> tokonizeMethodDeclaration(String inputString) {
        String[] str = inputString.split("\\s+");
        String temp = "";
        String methodDeclaration = "";
        boolean matched = false;

        Pattern p1 = Pattern.compile("[A-Za-z]+");
        Matcher m1 = p1.matcher(str[0]);
        while (m1.find()) {
            methodDeclaration = m1.group();

        }
        methodDeclarationList.add(new Token(Token.Type.METHODDECL, methodDeclaration));
        String[] stringArray = new String[1] ;
        for (int i = 0; i < methodDeclarationList.size(); i++) {
            stringArray[i] = methodDeclarationList.get(i).toString();
        }
        methodDeclSet = new HashSet<String>(Arrays.asList(stringArray));
        return methodDeclarationList;
    }

    public ArrayList<Token> tokonizeIdentifiers(String inputString) {

        String[] str = inputString.split("\\s+");
        String temp = "";
        boolean matched = false;

        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[i].length(); j++) {
                matched = false;
                temp = temp + str[i].charAt(j) + "";

            }
            for (String s : lparantheseSet) {

                if ((temp).contains(String.valueOf(s))) {
                    matched = true;
                }
            }
            for (String s : rparantheseSet) {
                if ((temp).contains(String.valueOf(s))) {
                    matched = true;
                }
            }

            for (String s : keywordSet) {
                if (temp.contains(s)) {
                    matched = true;
                }
            }

            for (String s : biOperatorSet) {

                if (temp.contains(s)) {
                    Pattern p2 = Pattern.compile("[a-zA-Z]+");
                    Matcher m2 = p2.matcher(temp);
                    while (m2.find()) {
                        identifierList.add(new Token(Token.Type.IDENTIFIER, m2.group()));
                    }
                    matched = true;
                }
            }

            for (String s : sybolSet) {
                if (temp.contains(s)) {

                    Pattern p3 = Pattern.compile("\\d+");
                    Matcher m3 = p3.matcher(temp);
                    while (m3.find()) {
                        numericals.add(new Token(Token.Type.NUMERICS, m3.group()));
                    }
                    matched = true;
                }
            }

            for (String s : operatorSet) {
                if (temp.contains(s)) {
                    matched = true;
                }
            }
            if (matched) {
                temp = "";
            }
        }
//        Set<String> set = new HashSet<String>(list);
        String[] stringArray = new String[numericals.size()];
        for (int i = 0; i < numericals.size(); i++) {
            stringArray[i] = numericals.get(i).toString();
        }
        numericalSet = new HashSet<String>(Arrays.asList(stringArray));

        String[] stringArray2 = new String[identifierList.size()];
        for (int i = 0; i < identifierList.size(); i++) {
            stringArray2[i] = identifierList.get(i).toString();
        }

        identifierSet = new HashSet<String>(Arrays.asList(stringArray2));
        return identifierList;
    }

}
