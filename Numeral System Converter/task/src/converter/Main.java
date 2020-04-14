package converter;

import java.util.*;

public class Main {
    private static final int SOURCE_RADIX = 0;
    private static final int SOURCE_NUMBER = 1;
    private static final int TARGET_RADIX = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }

        if (list.size() != 3) {
            System.out.println("Error input count values");
            return;
        }
        if (list.get(SOURCE_RADIX).matches("\\d+")
                && list.get(TARGET_RADIX).matches("\\d+")) {
            int sourceRadix = Integer.parseInt(list.get(SOURCE_RADIX));
            int targetRadix = Integer.parseInt(list.get(TARGET_RADIX));
            if (sourceRadix > 0 && targetRadix > 0
                    && sourceRadix < 37 && targetRadix < 37) {
                Converter converter = new Converter(sourceRadix
                        , list.get(SOURCE_NUMBER)
                        , targetRadix);
                converter.calc();
            } else {
                System.out.println("Error input (sourceRadix or targetRadix) < 1 " +
                        "or (sourceRadix < 37 && targetRadix < 37)");
            }
        } else {
            System.out.println("Error input (sourceRadix or targetRadix) != integer");
        }
    }
}
