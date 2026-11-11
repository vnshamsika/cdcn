
import java.util.*;

public class Machinecode {

    static class Node {
        String value;
        Node left, right;

        Node(String value) {
            this.value = value;
        }

        Node(String value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    static String exp;
    static int pos = 0;

    // Parse expression: + and -
    static Node expression() {
        Node node = term();

        while (pos < exp.length()) {
            char op = exp.charAt(pos);

            if (op == '+' || op == '-') {
                pos++;
                Node right = term();
                node = new Node(String.valueOf(op), node, right);
            } else {
                break;
            }
        }
        return node;
    }

    // Parse term: * and /
    static Node term() {
        Node node = factor();

        while (pos < exp.length()) {
            char op = exp.charAt(pos);

            if (op == '*' || op == '/') {
                pos++;
                Node right = factor();
                node = new Node(String.valueOf(op), node, right);
            } else {
                break;
            }
        }
        return node;
    }

    // Parse operands and brackets
    static Node factor() {

        if (pos < exp.length() && exp.charAt(pos) == '(') {
            pos++;
            Node node = expression();

            if (pos >= exp.length() || exp.charAt(pos) != ')')
                throw new RuntimeException("Missing closing bracket");

            pos++;
            return node;
        }

        int start = pos;

        while (pos < exp.length() &&
              (Character.isLetterOrDigit(exp.charAt(pos)) ||
               exp.charAt(pos) == '_')) {
            pos++;
        }

        if (start == pos)
            throw new RuntimeException("Invalid expression");

        return new Node(exp.substring(start, pos));
    }

    // Generate machine instructions
    static void generate(Node root) {

        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            System.out.println("LOAD " + root.value);
            return;
        }

        generate(root.left);
        generate(root.right);

        switch (root.value) {
            case "+":
                System.out.println("ADD");
                break;

            case "-":
                System.out.println("SUB");
                break;

            case "*":
                System.out.println("MUL");
                break;

            case "/":
                System.out.println("DIV");
                break;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter expression: ");
        exp = sc.nextLine().replaceAll("\\s+", "");

        try {
            pos = 0;

            Node root = expression();

            if (pos != exp.length())
                throw new RuntimeException("Invalid expression");

            System.out.println("Generated Machine Instructions:");
            generate(root);

        } catch (RuntimeException e) {
            System.out.println("Invalid expression!");
        }

        sc.close();
    }
}
