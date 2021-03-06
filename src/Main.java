import java.util.Scanner;
class Main {
    public static void main(String[] args){
        System.out.println("Введите арифметическое выражение");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        System.out.println(Main.calc(userInput));
    }
    static char operation;
    static int operationCount;
    public static String calc(String input) {
        operationCount = 0;
        char[] charArray = input.toCharArray();
        for (char element : charArray) {
            switch (element) {
                case '+', '-', '/', '*' -> {
                    operation = element;
                    operationCount++;
                }
            }
        }
        String valueOf = String.valueOf(charArray);
        String[] strings = valueOf.split("[+-/*]");
        if (operationCount == 1 && isNumeric(strings[0]) && isNumeric(strings[1])) {
            int split1 = Integer.parseInt(strings[0].trim());
            int split2 = Integer.parseInt(strings[1].trim());
            return String.valueOf(calculated(split1, split2, operation));
        } else if (operationCount == 1 && isEnum(strings[0]) && isEnum(strings[1])) {
            Roman roman1 = Roman.valueOf(strings[0].trim());
            Roman roman2 = Roman.valueOf(strings[1].trim());
            int split1 = roman1.getNumber();
            int split2 = roman2.getNumber();
            int resultRoman = calculated(split1, split2, operation);
            return String.valueOf(Roman.getRomanByInt(resultRoman));
        }
        throw new IllegalArgumentException("Не верный формат выражения");
    }
    public static boolean isNumeric(String string) {
        try {
            int intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
        }
        return false;
    }
    public static boolean isEnum(String string) {
        try {
            Roman roman = Roman.valueOf(string);
            return true;
        } catch (IllegalArgumentException e) {
        }
        return false;
    }
    static int calculated(int operand1, int operand2, char operator) {
        int result = 0;
        if(operand1 > 0 && operand1 < 11 && operand2 > 0 && operand2 < 11){
            switch (operator) {
                case '+' -> result = operand1 + operand2;
                case '-' -> result = operand1 - operand2;
                case '*' -> result = operand1 * operand2;
                case '/' -> result = operand1 / operand2;
            }
            return result;
        }
        throw new IllegalArgumentException("Не верный формат выражения");
    }
}