public class Operations {
    int operation(char sign, int a, int b) {
        try {
            return switch (sign) {
                case '+' -> a + b;
                case '-' -> a - b;
                case '*' -> a * b;
                case '/' -> a / b;
                default -> -1;
            };
        }catch (ArithmeticException e){
            throw new IllegalArgumentException("Деление на 0 невозможно");
        }
    }
}