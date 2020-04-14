package converter;

public class Converter {
    private int sourceRadix;
    private String sourceNumber;
    private int targetRadix;

    public Converter(int sourceRadix, String sourceNumber, int targetRadix) {
        this.sourceRadix = sourceRadix;
        this.sourceNumber = sourceNumber;
        this.targetRadix = targetRadix;
    }

    public void calc() {
        if (sourceNumber.matches(".*\\..*")) {
            if (targetRadix == 1) {
                System.out.println(anyToOne());
                return;
            }
            if (sourceRadix != 10) {
                sourceNumber = anyFractionsToDecimal();
            }
            System.out.println(decimalFractionsToAny());
        } else {
            System.out.println(anyIntegerToTarget());
        }
    }

    private String anyToOne() {
        String localSource = "";
        if (sourceNumber.matches(".*\\..*")) {
            localSource = sourceNumber.substring(0, sourceNumber.indexOf("."));
        }
        StringBuilder stringBuilder = new StringBuilder();
        int size = Integer.parseInt(localSource);
        while (size > 0) {
            stringBuilder.append("1");
            --size;
        }
        return stringBuilder.toString();
    }

    private String anyIntegerToTarget() {
        if (sourceRadix == 1) {
            return Integer.toString(sourceNumber.length(), targetRadix);
        }
        if (targetRadix == 1) {
            StringBuilder stringBuilder = new StringBuilder();
            int size = Integer.parseInt(sourceNumber);
            while (size > 0) {
                stringBuilder.append("1");
                --size;
            }
            return stringBuilder.toString();
        }
        return Integer.toString(Integer.parseInt(sourceNumber, sourceRadix), targetRadix);
    }

    private int charToInt(char symbol) {
        return Character.getNumericValue(symbol);
    }

    private char intToChar(int number) {
        return Character.forDigit(number, 10);
    }

    private double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    private String anyFractionsToDecimal() {
        double decimalValue = 0.0;
        int left = Integer.parseInt(sourceNumber.split("\\.")[0], sourceRadix);
        String right = sourceNumber.split("\\.")[1];
        int size = right.length();
        for (int i = 0; i < size; i++) {
//            decimalValue += Integer.parseInt(String.valueOf(right.charAt(i)), 10)
            int x = charToInt(right.charAt(i));
            double y = Math.pow(sourceRadix, i + 1);
            decimalValue += x/y;
        }
        return String.valueOf(Integer.parseInt(String.valueOf(left), 10) + round(decimalValue, 10));
    }

    private String decimalFractionsToAny() {
        int left = Integer.parseInt(sourceNumber.split("\\.")[0]);
        String right = "0." + sourceNumber.split("\\.")[1];
        int size = right.length();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toString(left, targetRadix));
        stringBuilder.append(".");
        double value;
        for (int i = 0; i < size; i++) {
            value = Double.parseDouble(right) * targetRadix;
            int decimal = (int) value;
            double fractions = value - decimal;
            stringBuilder.append(Integer.toString(decimal, targetRadix));
            right = String.valueOf(fractions);
        }
//        Bad solution
        String string = stringBuilder.toString();
        String[] strings = string.split("\\.");
        if (strings.length == 2) {
            if (strings[1].length() > 5) {
                return strings[0] + "." + strings[1].substring(0, 5);
            }
        }
//        Bad solution
        return string;
    }
}
