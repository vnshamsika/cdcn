import java.util.*;

class First {
    static Map<Character, String> g = new HashMap<>();

    static Set<Character> first(char c) {
        Set<Character> s = new HashSet<>();

        if (!Character.isUpperCase(c)) {
            s.add(c);
            return s;
        }

        for (char x : g.get(c).toCharArray()) {
            if (!Character.isUpperCase(x)) {
                s.add(x);
                break;
            } else {
                s.addAll(first(x));
                break;
            }
        }

        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String x = sc.next();
            g.put(x.charAt(0), x.substring(3));
        }

        for (char c : g.keySet())
            System.out.println("FIRST(" + c + ") = " + first(c));
    }
}
