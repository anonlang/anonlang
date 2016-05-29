package com.anonsage.anonlang;

/**
 * 2016-05-28: Created by Danial Goodwin
 */
public class AnonlangAstToHtml {

    public static String convert(AnonlangAst ast) {
        return visit(ast, 0);
    }

    private static String visit(AnonlangAst ast, int indentLevel) {
        if (ast instanceof AnonlangAst.ProgNode) {
            return visitProgNode((AnonlangAst.ProgNode) ast, indentLevel);
        } else if (ast instanceof AnonlangAst.GroupNode) {
            return visitGroupNode((AnonlangAst.GroupNode) ast, indentLevel);
        } else if (ast instanceof AnonlangAst.AttributeNode) {
            return visitAttributeNode((AnonlangAst.AttributeNode) ast, indentLevel);
        } else if (ast instanceof AnonlangAst.BlockNode) {
            return visitBlockNode((AnonlangAst.BlockNode) ast, indentLevel);
        } else if (ast instanceof AnonlangAst.TextNode) {
            return visitTextNode((AnonlangAst.TextNode) ast);
        } else if (ast instanceof AnonlangAst.NumberNode) {
            return visitNumberNode((AnonlangAst.NumberNode) ast);
        }
        throw new RuntimeException("Unexpected node: " + ast);
    }

    private static String visitProgNode(AnonlangAst.ProgNode ast, int indentLevel) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>\n");
        if (ast.groups == null) { return ""; }
        for (AnonlangAst.GroupNode group : ast.groups) {
            sb.append(visitGroupNode(group, indentLevel));
        }
        return sb.append("</html>").toString();
    }

    private static String visitGroupNode(AnonlangAst.GroupNode ast, int indentLevel) {
        StringBuilder sb = new StringBuilder();
        if (ast == null || ast.attributes == null) { return ""; }
        for (AnonlangAst.AttributeNode attribute : ast.attributes) {
            sb.append(visitAttributeNode(attribute, indentLevel + 1)).append("\n");
        }
        return sb.toString();
    }

    private static String visitAttributeNode(AnonlangAst.AttributeNode ast, int indentLevel) {
        StringBuilder sb = new StringBuilder();
        addSpaces(sb, indentLevel);
        sb.append("<").append(visitTextNode(ast.textNode)).append(">\n");
        sb.append(visitBlockNode(ast.blockNode, indentLevel));
        addSpaces(sb, indentLevel);
        sb.append("</").append(visitTextNode(ast.textNode)).append(">");
        return sb.toString();
    }

    private static String visitBlockNode(AnonlangAst.BlockNode ast, int indentLevel) {
        StringBuilder sb = new StringBuilder();
        if (ast.ast instanceof AnonlangAst.NumberNode) {
            addSpaces(sb, indentLevel + 1);
            sb.append(visitNumberNode((AnonlangAst.NumberNode) ast.ast)).append("\n");
        } else if (ast.ast instanceof AnonlangAst.TextNode) {
            addSpaces(sb, indentLevel + 1);
            sb.append(visitTextNode((AnonlangAst.TextNode) ast.ast)).append("\n");
        } else if (ast.ast instanceof AnonlangAst.GroupNode) {
            sb.append(visitGroupNode((AnonlangAst.GroupNode) ast.ast, indentLevel)).append("");
        } else {
            throw new RuntimeException("Unexpected ast: " + ast);
        }
        return sb.toString();
    }

    private static String visitTextNode(AnonlangAst.TextNode ast) {
        return ast.token.value;
    }

    private static String visitNumberNode(AnonlangAst.NumberNode ast) {
        return ast.token.value;
    }

    private static StringBuilder addSpaces(StringBuilder sb, int indentLevel) {
        int countSpaces = indentLevel * 2;
        for (int i = 0; i < countSpaces; i++) {
            sb.append(" ");
        }
        return sb;
    }

}
