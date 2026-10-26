import java.util.Scanner;

public class TAC {
    static int temp = 1;

    static String generate(String expr) {
        while (expr.contains("*") || expr.contains("/")) {
            int i = -1;

            for (int j = 0; j < expr.length(); j++) {
                if (expr.charAt(j) == '*' || expr.charAt(j) == '/') {
                    i = j;
                    break;
                }
            }

            if (i == -1) break;

            int l = i - 1, r = i + 1;

            while (l >= 0 && Character.isLetterOrDigit(expr.charAt(l))) l--;
            while (r < expr.length() && Character.isLetterOrDigit(expr.charAt(r))) r++;

            String left = expr.substring(l + 1, i);
            String right = expr.substring(i + 1, r);
            String t = "t" + temp++;

            System.out.println(t + " = " + left + " " + expr.charAt(i) + " " + right);

            expr = expr.substring(0, l + 1) + t + expr.substring(r);
        }

        while (expr.contains("+") || expr.contains("-")) {
            int i = -1;

            for (int j = 0; j < expr.length(); j++) {
                if (expr.charAt(j) == '+' || expr.charAt(j) == '-') {
                    i = j;
                    break;
                }
            }

            if (i == -1) break;

            String left = expr.substring(0, i);
            String right = expr.substring(i + 1);
            String t = "t" + temp++;

            System.out.println(t + " = " + left + " " + expr.charAt(i) + " " + right);
            expr = t;
        }

        return expr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter expression: ");
        String expr = sc.nextLine().replaceAll("\\s+", "");

        String result = generate(expr);

        System.out.println("Final result stored in: " + result);
        sc.close();
    }
}
