import java.util.*;

public class First {

    static Map<String, List<String>> g = new LinkedHashMap<>();
    static Map<String, Set<String>> f = new LinkedHashMap<>();

    static Set<String> first(String symbol) {

        // Already calculated
        if (f.containsKey(symbol))
            return f.get(symbol);

        Set<String> result = new LinkedHashSet<>();
        f.put(symbol, result);

        // Terminal
        if (!g.containsKey(symbol)) {
            result.add(symbol);
            return result;
        }

        // Non-terminal
        for (String production : g.get(symbol)) {

            String[] symbols = production.trim().split("\\s+");

            boolean allEpsilon = true;

            for (String x : symbols) {

                Set<String> temp = first(x);

                // Add FIRST(x), except epsilon
                for (String a : temp) {
                    if (!a.equals("#") && !a.equals("ε"))
                        result.add(a);
                }

                // If x cannot produce epsilon, stop
                if (!temp.contains("#") && !temp.contains("ε")) {
                    allEpsilon = false;
                    break;
                }
            }

            // If all symbols can produce epsilon
            if (allEpsilon)
                result.add("#");
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of productions: ");
        int n = sc.nextInt();
        sc.nextLine();

        // Read grammar
        for (int i = 0; i < n; i++) {

            String s = sc.nextLine();

            String[] parts = s.split("->", 2);

            String lhs = parts[0].trim();
            String rhs = parts[1].trim();

            g.put(lhs, Arrays.asList(rhs.split("\\|")));
        }

        // Calculate FIRST
        for (String symbol : g.keySet()) {
            first(symbol);
        }

        // Print FIRST
        System.out.println("\nFIRST:");

        for (String symbol : g.keySet()) {
            System.out.println(
                "FIRST(" + symbol + ") = " + f.get(symbol)
            );
        }
    }
}
