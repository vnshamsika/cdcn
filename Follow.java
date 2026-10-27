import java.util.*;

class Follow {
    static Map<Character, String> g = new HashMap<>();
    static Map<Character, Set<Character>> f = new HashMap<>();

    static char first(char c) {                 // CHANGE 1
        if (!Character.isUpperCase(c))
            return c;
        return g.get(c).charAt(0);
    }                                            // CHANGE 1

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char start = 0;

        for (int i = 0; i < n; i++) {
            String x = sc.next();
            char l = x.charAt(0);

            if (i == 0)
                start = l;

            g.put(l, x.substring(3));
            f.put(l, new HashSet<>());
        }

        f.get(start).add('$');

        for (char a : g.keySet()) {
            for (String r : g.get(a).split("\\|")) {
                for (int i = 0; i < r.length(); i++) {
                    char b = r.charAt(i);

                    if (Character.isUpperCase(b)) {
                        if (i + 1 < r.length()) {
                            char c = r.charAt(i + 1);

                            f.get(b).add(first(c));   // CHANGE 2

                        } else {
                            f.get(b).addAll(f.get(a));
                        }
                    }
                }
            }
        }

        for (char c : g.keySet())
            System.out.println("FOLLOW(" + c + ") = " + f.get(c));
    }
}
