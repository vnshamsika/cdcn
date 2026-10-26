import java.util.*;
import java.util.regex.*;

public class PatternMatching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        String pattern = "ab*";

        if (Pattern.matches(pattern, s)) {
            System.out.println("String matches the pattern.");
        } else {
            System.out.println("String does not match the pattern.");
        }

        sc.close();
    }
}