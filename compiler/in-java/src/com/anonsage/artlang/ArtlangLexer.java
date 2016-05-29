/**
 * 2016-05-28: Created by Danial Goodwin
 */
package com.anonsage.artlang;

import com.anonsage.anonlang.AnonlangAst;

import java.util.ArrayList;

/**
 *
 * grammar: [
 *   prog: group (group)*
 *   group: attribute (attribute)*
 *   attribute: TEXT COLON block
 *   block: NUMBER | TEXT | (BRACKET_START group BRACKET_STOP)
 * ]
 */
public class ArtlangLexer {

    private String currentLine;
    private int currentPosition;
    private char currentChar;

    private ArrayList<AnonlangAst.Token> tokens = new ArrayList<>();

    public void add(String currentLine) {
        this.currentLine = currentLine;
        currentPosition = 0;
        currentChar = currentLine.charAt(currentPosition);
        while (currentPosition < currentLine.length()) {
            AnonlangAst.Token token = getNextToken();
            tokens.add(token);
        }
    }

    public ArrayList<AnonlangAst.Token> getTokens() {
        return tokens;
    }

    private boolean moveToNextChar() {
        currentPosition++;
        if (currentPosition >= currentLine.length()) {
            return false;
        } else {
            currentChar = currentLine.charAt(currentPosition);
            return true;
        }
    }

    private AnonlangAst.Token getNextToken() {
        //noinspection StatementWithEmptyBody
        while (Character.isWhitespace(currentChar) && moveToNextChar()) {}
        if (currentPosition >= currentLine.length()) { return new AnonlangAst.Token(AnonlangAst.Token.END_OF_LINE, ""); }
        if (currentChar == ':') { moveToNextChar(); return new AnonlangAst.Token(AnonlangAst.Token.COLON, ":"); }
        if (currentChar == '[') { moveToNextChar(); return new AnonlangAst.Token(AnonlangAst.Token.BRACKET_START, "["); }
        if (currentChar == ']') { moveToNextChar(); return new AnonlangAst.Token(AnonlangAst.Token.BRACKET_STOP, "]"); }
        if (currentChar == '\'') { moveToNextChar(); return new AnonlangAst.Token(AnonlangAst.Token.SINGLE_QUOTE, "'"); }
        if (Character.isDigit(currentChar)) { return new AnonlangAst.Token(AnonlangAst.Token.NUMBER, number()); }
        if (Character.isLetterOrDigit(currentChar)) { return new AnonlangAst.Token(AnonlangAst.Token.TEXT, text()); }
        throw new RuntimeException("Unexpected character: " + currentChar);
    }

    private String number() {
        StringBuilder sb = new StringBuilder();
        while (Character.isDigit(currentChar)) {
            sb.append(currentChar);
            if (!moveToNextChar()) { break; }
        }
        return sb.toString();
    }

    private String text() {
        StringBuilder sb = new StringBuilder();
        while (Character.isLetterOrDigit(currentChar)) {
            sb.append(currentChar);
            if (!moveToNextChar()) { break; }
        }
        return sb.toString();
    }

}
