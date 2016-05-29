package com.danialgoodwin;

import com.anonsage.anonlang.AnonlangAst;
import com.anonsage.anonlang.AnonlangAstToHtml;
import com.anonsage.anonlang.AnonlangAstToJson;
import com.anonsage.artlang.ArtlangLexer;
import com.anonsage.artlang.ArtlangParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final boolean IS_READ_FROM_FILE = true;

    public static void main(String[] args) {
        log("main()");
        ArtlangLexer lexer = new ArtlangLexer();
        if (IS_READ_FROM_FILE) {
            try (BufferedReader br = new BufferedReader(new FileReader("sample.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.isEmpty()) { break; }
                    lexer.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String line = scanner.nextLine();
                if (line.isEmpty()) { break; }
                lexer.add(line);
            }
        }
        ArrayList<AnonlangAst.Token> tokens = lexer.getTokens();
        log("tokens=" + tokens);

        ArtlangParser parser = new ArtlangParser();
        parser.add(tokens);
        AnonlangAst ast = parser.getAst();
        log("ast=" + ast);

        String html = AnonlangAstToHtml.convert(ast);
        log("html=\n" + html);

        String json = AnonlangAstToJson.convert(ast);
        log("json=\n" + json);
    }

    public static void log(String message) {
        System.out.println(message);
    }

}
