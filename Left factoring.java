import java.util.*;

class LeftFactoring {
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

        String prefix = p[0];

        for (int i = 1; i < n; i++) {
            int j = 0;

            while (j < prefix.length() &&
                   j < p[i].length() &&
                   prefix.charAt(j) == p[i].charAt(j))
                j++;

            prefix = prefix.substring(0, j);
        }

        if (prefix.length() == 0) {
            System.out.println("No Left Factoring Required");
        } else {
            System.out.println("\nLeft Factored Grammar:");
            System.out.println(A + " -> " + prefix + A + "'");
            System.out.print(A + "' -> ");

            for (int i = 0; i < n; i++) {
                String r = p[i].substring(prefix.length());

                if (r.length() == 0)
                    r = "epsilon";

                System.out.print(r);

                if (i < n - 1)
                    System.out.print(" | ");
            }

            System.out.println();
        }

        sc.close();
    }
}
