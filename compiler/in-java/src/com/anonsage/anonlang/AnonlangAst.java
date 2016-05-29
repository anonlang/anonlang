package com.anonsage.anonlang;

import java.util.List;

/**
 * 2016-05-28: Created by Danial Goodwin
 */
public class AnonlangAst {

    public static class ProgNode extends AnonlangAst {
        List<GroupNode> groups;
        public ProgNode(List<GroupNode> groups) {
            this.groups = groups;
        }
        @Override
        public String toString() {
            return "ProgNode{" +
                    "groups=" + groups +
                    '}';
        }
    }

    public static class GroupNode extends AnonlangAst {
        List<AttributeNode> attributes;
        public GroupNode(List<AttributeNode> attributes) {
            this.attributes = attributes;
        }
        @Override
        public String toString() {
            return "GroupNode{" +
                    "attributes=" + attributes +
                    '}';
        }
    }

    public static class AttributeNode extends AnonlangAst {
        final TextNode textNode;
        final BlockNode blockNode;
        public AttributeNode(TextNode textNode, BlockNode blockNode) {
            this.textNode = textNode;
            this.blockNode = blockNode;
        }
        @Override
        public String toString() {
            return "AttributeNode{" +
                    "textNode=" + textNode +
                    ", blockNode=" + blockNode +
                    '}';
        }
    }

    public static class BlockNode extends AnonlangAst {
        final AnonlangAst ast;
        public BlockNode(AnonlangAst ast) {
            this.ast = ast;
        }
        @Override
        public String toString() {
            return "BlockNode{" +
                    "ast=" + ast +
                    '}';
        }
    }

    public static class NumberNode extends AnonlangAst {
        final Token token;
        public NumberNode(Token token) {
            this.token = token;
        }
        @Override
        public String toString() {
            return "NumberNode{" +
                    "token=" + token +
                    '}';
        }
    }

    public static class TextNode extends AnonlangAst {
        final Token token;
        public TextNode(Token token) {
            this.token = token;
        }
        @Override
        public String toString() {
            return "TextNode{" +
                    "token=" + token +
                    '}';
        }
    }

    public static class Token {
//        public static final int WHITESPACE = 0;
        public static final int NUMBER = 1;
//        public static final int PLUS = 2;
//        public static final int DASH = 3;
//        public static final int ASTERISK = 4;
//        public static final int SLASH_FORWARD = 5;
//        public static final int SLASH_BACK = 6;
        public static final int TEXT = 7;
        public static final int BRACKET_START = 8;
        public static final int BRACKET_STOP = 9;
//        public static final int EQUALS = 10;
        public static final int COLON = 11;
        public static final int SINGLE_QUOTE = 12;
        public static final int COMMA = 13;
        public static final int PERIOD = 14;
        public static final int END_OF_LINE = 15;
        public static final int END_OF_FILE = 16;
        public final int type;
        public final String value;
        public Token(int type, String value) {
            this.type = type;
            this.value = value;
        }
        @Override
        public String toString() {
            return "Token{" +
                    "type=" + type +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

}
