import java.util.*;
import javax.lang.model.SourceVersion;

public class LexicalAnalyzer {

    public static void main(String[] args) {

        String code = """
                int sum = a + 10; // Single-line comment
                float x = 3.14;

                /*
                   Multi-line comment
                */

                if (sum > 5) {
                    return;
                }
                """;

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