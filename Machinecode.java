
import java.util.Scanner;

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

        System.out.println("Expression: a + b * c");

        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");

        Node multiply = new Node("*", b, c);
        Node root = new Node("+", a, multiply);

        System.out.println("Generated Machine Instructions:");
        generate(root);

        sc.close();
    }
}
