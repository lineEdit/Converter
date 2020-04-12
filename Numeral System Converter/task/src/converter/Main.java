package converter;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        String octal = Integer.toOctalString(value);
        System.out.println(octal.substring(octal.length() - 1));
    }
}
