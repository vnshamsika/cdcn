
import java.util.*;
import java.nio.file.*;
import javax.lang.model.SourceVersion;
import java.io.IOException;

public class LexicalAnalyzer2 {

    public static void main(String[] args) throws IOException {

        // Read source code from a file
        String code = Files.readString(
                Path.of("input.txt"));

        // Remove multi-line comments
        code = code.replaceAll("(?s)/\\*.*?\\*/", "");

        // Remove single-line comments
        code = code.replaceAll("//.*", "");

        // Split code into tokens
        StringTokenizer st = new StringTokenizer(
                code, " \t\n+-*/=(){};,<>", true);

        while (st.hasMoreTokens()) {

            String token = st.nextToken().trim();

            if (token.isEmpty())
                continue;

            if (SourceVersion.isKeyword(token)) {
                System.out.println(token + " --> Keyword");
            }
            else if (SourceVersion.isIdentifier(token)) {
                System.out.println(token + " --> Identifier");
            }
            else if (token.matches("\\d+(\\.\\d+)?")) {
                System.out.println(token + " --> Number");
            }
            else if (token.matches("[+*/=<>-]")) {
                System.out.println(token + " --> Operator");
            }
            else if (token.matches("[(){};,]")) {
                System.out.println(token + " --> Delimiter");
            }
            else {
                System.out.println(token + " --> Invalid Token");
            }
        }
    }
}
