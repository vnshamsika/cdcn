import java.util.Scanner;

public class BitStuffing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter binary data: ");
        String data = sc.nextLine();

        if (!data.matches("[01]+")) {
            System.out.println("Invalid input! Enter only 0 and 1.");
            sc.close();
            return;
        }

        String stuffed = "";
        int count = 0;

        for (int i = 0; i < data.length(); i++) {
            char bit = data.charAt(i);
            stuffed += bit;

            if (bit == '1') {
                count++;

                if (count == 5) {
                    stuffed += '0';
                    count = 0;
                }
            } else {
                count = 0;
            }
        }

        System.out.println("Stuffed Data: " + stuffed);

        String destuffed = "";
        count = 0;

        for (int i = 0; i < stuffed.length(); i++) {
            char bit = stuffed.charAt(i);
            destuffed += bit;

            if (bit == '1') {
                count++;

                if (count == 5) {
                    i++;
                    count = 0;
                }
            } else {
                count = 0;
            }
        }

        System.out.println("Destuffed Data: " + destuffed);

        sc.close();
    }
}
