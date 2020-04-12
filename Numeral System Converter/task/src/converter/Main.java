package converter;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sourceRadix = scanner.nextInt();
        String sourceNumber = scanner.next();
        int targetRadix = scanner.nextInt();

        Converter converter = new Converter(sourceRadix, sourceNumber, targetRadix);
        converter.calc();
    }
}
