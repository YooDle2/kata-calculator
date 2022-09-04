import java.util.HashMap;

class Convertations {
    static HashMap<Character, Integer> romanNumbers = new HashMap<>();

    /**
     * Констуктор, в котором заполняется HashMap с Римскими числами
     */
    Convertations(){
            romanNumbers.put('I', 1);
            romanNumbers.put('V', 5);
            romanNumbers.put('X', 10);
            romanNumbers.put('L', 50);
            romanNumbers.put('C', 100);
    }

    /**
     * Перевод из Риских в Арабские
     */
    static int romanToInteger(String s) {
        int result = 0;
        int temp = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int current = romanNumbers.get(s.charAt(i));
            if (current < temp) {
                result -= current;
            } else {
                result += current;
            }
            temp = current;
        }
        return result;
    }

    /**
     * Первый метод перевода из Арабских в Римские (не используется)
     */
    String integerToRoman(int arabicNum) {
        if(arabicNum<0){
            throw new NumberFormatException();
        }
        String[] dozens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
        String[] units = {"", "I", "II", "III", "IV", "v", "VI", "VII", "VIII", "IX", "X"};
        return dozens[arabicNum / 10] + units[arabicNum % 10];
    }

    /**
     * Второй метод перевода из Арабских в Римские
     */
    String intToRoman(int arabicNum){
        if (arabicNum<1){
            throw new IllegalArgumentException("Результат вычисления выражения с римскими числами должен быть положительным");
        }
        int[] arabicValues = {1, 4, 5, 9, 10, 40, 50, 90, 100};
        String[] romanValues = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};
        StringBuilder sb = new StringBuilder();
        for (int i = arabicValues.length - 1; i >= 0 && arabicNum > 0; i--) {
            while (arabicNum >= arabicValues[i]) {
                arabicNum -= arabicValues[i];
                sb.append(romanValues[i]);
            }
        }
        return sb.toString();
    }
}