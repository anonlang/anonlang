package com.anonsage.artlang;

import com.anonsage.anonlang.AnonlangAst;

import java.util.ArrayList;

/**
 * 2016-05-28: Created by Danial Goodwin
 */
public class ArtlangParser {

    private ArrayList<AnonlangAst.Token> tokens;
    private AnonlangAst ast;
    private int currentPosition;
    private AnonlangAst.Token currentToken;

    public void add(ArrayList<AnonlangAst.Token> tokens) {
        if (tokens == null || tokens.isEmpty()) { throw new RuntimeException("Input must be non-empty");}
        this.tokens = tokens;
        currentPosition = 0;
        currentToken = tokens.get(currentPosition);
        ast = prog();
    }

    public AnonlangAst getAst() {
        return ast;
    }

    private void moveToNextTokenIfMatch(int tokenType) {
        if (currentToken.type == tokenType) {
            currentPosition++;
            if (currentPosition >= tokens.size()) {
                currentToken = new AnonlangAst.Token(AnonlangAst.Token.END_OF_FILE, "");
            } else {
                currentToken = tokens.get(currentPosition);
            }
        } else {
            throw new RuntimeException("Unexpected type: " + tokenType);
        }
    }

    private AnonlangAst.ProgNode prog() {
        ArrayList<AnonlangAst.GroupNode> groups = new ArrayList<>();
        AnonlangAst.GroupNode group = group();
        groups.add(group);
        while (currentToken.type != AnonlangAst.Token.END_OF_FILE && (group = group()) != null) {
            groups.add(group);
        }
        return new AnonlangAst.ProgNode(groups);
    }

    private AnonlangAst.GroupNode group() {
        ArrayList<AnonlangAst.AttributeNode> attributes = new ArrayList<>();
        AnonlangAst.AttributeNode attribute = attribute();
        attributes.add(attribute);
        while (currentToken.type != AnonlangAst.Token.END_OF_FILE && currentToken.type != AnonlangAst.Token.BRACKET_STOP && (attribute = attribute()) != null) {
            attributes.add(attribute);
        }
        return new AnonlangAst.GroupNode(attributes);
    }

    private AnonlangAst.AttributeNode attribute() {
//        if (currentToken.type != AnonlangAst.Token.TEXT) { return null; }
        AnonlangAst.Token token = currentToken;
        moveToNextTokenIfMatch(AnonlangAst.Token.TEXT);
        moveToNextTokenIfMatch(AnonlangAst.Token.COLON);
        AnonlangAst.BlockNode block = block();
        return new AnonlangAst.AttributeNode(new AnonlangAst.TextNode(token), block);
    }

    private AnonlangAst.BlockNode block() {
        AnonlangAst.Token token = currentToken;
        switch (token.type) {
            case AnonlangAst.Token.NUMBER: moveToNextTokenIfMatch(AnonlangAst.Token.NUMBER); return new AnonlangAst.BlockNode(new AnonlangAst.NumberNode(token));
            case AnonlangAst.Token.TEXT: moveToNextTokenIfMatch(AnonlangAst.Token.TEXT); return new AnonlangAst.BlockNode(new AnonlangAst.TextNode(token));
            case AnonlangAst.Token.BRACKET_START:
                moveToNextTokenIfMatch(AnonlangAst.Token.BRACKET_START);
                AnonlangAst group = group();
                moveToNextTokenIfMatch(AnonlangAst.Token.BRACKET_STOP);
                return new AnonlangAst.BlockNode(group);
            default:
                throw new RuntimeException("Unexpected token for block: " + token);
        }
    }

}
