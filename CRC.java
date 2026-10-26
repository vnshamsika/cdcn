import java.util.*;

public class CRC {

    static String divide(String data, String generator) {

        char[] bits = data.toCharArray();

        for (int i = 0; i <= data.length() - generator.length(); i++) {

            if (bits[i] == '1') {

                for (int j = 0; j < generator.length(); j++) {

                    if (bits[i + j] == generator.charAt(j))
                        bits[i + j] = '0';
                    else
                        bits[i + j] = '1';
                }
            }
        }

        String result = "";

        for (int i = data.length() - generator.length() + 1;
             i < data.length(); i++) {

            result = result + bits[i];
        }

        return result;
    }

    static void crc(String data, String generator) {

        // ---------- SENDER ----------
        String temp = data;

        for (int i = 0; i < generator.length() - 1; i++)
            temp = temp + "0";

        String remainder = divide(temp, generator);

        String transmitted = data + remainder;

        System.out.println("CRC = " + remainder);
        System.out.println("Transmitted data = " + transmitted);

        // ---------- RECEIVER ----------
        String receiverRemainder = divide(transmitted, generator);

        System.out.println("Receiver remainder = " + receiverRemainder);

        if (receiverRemainder.matches("0+"))
            System.out.println("No error detected");
        else
            System.out.println("Error detected");

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter binary data: ");
        String data = sc.next();
       

        System.out.println("\n--- CRC-12 ---");
        crc(data, "1100000001111");

        System.out.println("--- CRC-16 ---");
        crc(data, "11000000000000101");

        System.out.println("--- CRC-CCIP ---");//crc ccip
        crc(data, "10001000000100001");
        sc.close();
    }
}