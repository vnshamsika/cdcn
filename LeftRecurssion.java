import java.util.*;

class LeftRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Non-Terminal: ");
        String A = sc.nextLine();

        System.out.print("Enter number of productions: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] p = new String[n];

        System.out.println("Enter productions:");
        for (int i = 0; i < n; i++)
            p[i] = sc.nextLine();

        ArrayList<String> alpha = new ArrayList<>();
        ArrayList<String> beta = new ArrayList<>();

        for (String x : p) {
            if (x.startsWith(A))
                alpha.add(x.substring(A.length()));
            else
                beta.add(x);
        }

        if (alpha.isEmpty()) {
            System.out.println("No Left Recursion");
        } else {
            System.out.println("\nLeft Recursion Removed:");

            System.out.print(A + " -> ");
            for (int i = 0; i < beta.size(); i++) {
                System.out.print(beta.get(i) + A + "'");
                if (i < beta.size() - 1)
                    System.out.print(" | ");
            }

            System.out.print("\n" + A + "' -> ");
            for (int i = 0; i < alpha.size(); i++) {
                System.out.print(alpha.get(i) + A + "' | ");
            }

            System.out.println("epsilon");
        }

        sc.close();
    }
}
