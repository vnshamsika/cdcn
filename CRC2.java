 import java.util.*;

public class CRC2 {

    static String divide(String data, String poly) {
        char[] a = data.toCharArray();

        for (int i = 0; i <= a.length - poly.length(); i++) {
            if (a[i] == '1') {
                for (int j = 0; j < poly.length(); j++) {
                    a[i + j] = (a[i + j] == poly.charAt(j)) ? '0' : '1';
                }
            }
        }

        return new String(a).substring(a.length - poly.length() + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter binary data: ");
        String data = sc.next();

        String[] poly = {
            "1100000001111",
            "11000000000000101",
            "10001000000100001"
        };

        String[] names = {"CRC-12", "CRC-16", "CRC-CCITT"};

        for (int k = 0; k < 3; k++) {
            String padded = data + "0".repeat(poly[k].length() - 1);
            System.out.println(names[k] + ": " + divide(padded, poly[k]));
        }
        sc.close();
    }
}