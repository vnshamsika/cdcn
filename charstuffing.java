
import java.util.Scanner;

public class charstuffing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String FLAG = "FLAG";
        String ESC = "ESC";

        System.out.print("Enter data: ");
        String data = sc.nextLine();

        String stuffed = data.replace(ESC, ESC + ESC);
        stuffed = stuffed.replace(FLAG, ESC + FLAG);
        stuffed = FLAG + stuffed + FLAG;

        System.out.println("Stuffed Data: " + stuffed);

        String received = stuffed.substring(
                FLAG.length(), stuffed.length() - FLAG.length());

        String destuffed = "";
        int i = 0;

        while (i < received.length()) {
            if (received.startsWith(ESC, i)) {
                i += ESC.length();

                if (received.startsWith(FLAG, i)) {
                    destuffed += FLAG;
                    i += FLAG.length();
                } else if (received.startsWith(ESC, i)) {
                    destuffed += ESC;
                    i += ESC.length();
                }
            } else if (received.startsWith(FLAG, i)) {
                destuffed += FLAG;
                i += FLAG.length();
            } else {
                destuffed += received.charAt(i);
                i++;
            }
        }

        System.out.println("Destuffed Data: " + destuffed);

        sc.close();
    }
}
