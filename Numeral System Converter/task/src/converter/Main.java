package converter;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sourceRadix = scanner.nextInt();
        String sourceNumber = scanner.next();
        int targetRadix = scanner.nextInt();

        int targetNumder;
        if (sourceRadix == 1) {
            targetNumder = sourceNumber.length();
        } else {
            targetNumder = Integer.parseInt(sourceNumber, sourceRadix);
        }

        String result;
        if (targetRadix == 1) {
            StringBuilder stringBuilder = new StringBuilder();
            int size = Integer.parseInt(sourceNumber);
            while (size > 0) {
                stringBuilder.append("1");
                --size;
            }
            result = stringBuilder.toString();
        } else {
            result = Integer.toString(targetNumder, targetRadix);
        }
        System.out.println(result);
    }
}
