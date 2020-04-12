package converter;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        int radix = scanner.nextInt();
        String result = "";
        switch (radix) {
            case 2:
                result = "0b" + Integer.toBinaryString(value);
                break;
            case 8:
                result = "0" + Integer.toOctalString(value);
                break;
            case 16:
                result = "0x" + Integer.toHexString(value);
                break;
        }
        System.out.println(result);
    }
}
