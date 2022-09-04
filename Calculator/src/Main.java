import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("KATA-КАЛЬКУЛЯТОР" +
                "\n! Выражение может состоять только из двух операндов и знака операции между ними" +
                "\n! Операндами могут быть римские или арабские числа в интервале от 1 до 10 включительно" +
                "\n! Одновременно ввести можно только римские или только арабские числа" +
                "\n! Вычисляемые операции: +, -, *, /" +
                "\n  Примеры выражений: \"10 + 9\", \"8 - 7\", \"VI * V\", \"IV / III\"" +
                "\n\nВведите выражение: ");
        String expression = scanner.nextLine();
//        String expression = "X - X";
        System.out.println("Результат вычисления выражения \"" + expression + "\" равен: " + calc(expression));
    }

    public static String calc(String input) {
        FormatCheck fc = new FormatCheck();
        String[] splitted = input.split(" ");
        fc.formatCheck(input, splitted);
        Operations operation = new Operations();
        try {
            return String.valueOf(operation.operation(splitted[1].charAt(0), Integer.parseInt(splitted[0]), Integer.parseInt(splitted[2])));
        } catch (NumberFormatException e) {
            Convertations con = new Convertations();
            int preResult = operation.operation(splitted[1].charAt(0), con.romanToInteger(splitted[0]), con.romanToInteger(splitted[2]));
            return con.intToRoman(preResult);
        }
    }
}
