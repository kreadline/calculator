import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        System.out.println(calc(in));

    }

    public static String calc(String input) {
        String[] spl = input.split(" ");
        if (spl.length < 3)
            throw new RuntimeException("Не является математической операцией");
        if (spl.length > 3)
            throw new RuntimeException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        String first = spl[0], second = spl[2];
        String operator = spl[1];
        int num1, num2, count1 = -1, count2 = -1, resultRoman = 0;
        boolean is_first = true, is_second = true;
        String result = "";
        String [] roman = new String[] {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        if (Character.isDigit(first.charAt(0)) && Character.isDigit(second.charAt(0))) {
            num1 = Integer.parseInt(first);
            num2 = Integer.parseInt(second);
            if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10)
                throw new RuntimeException("Калькулятор принимает на вход числа от 1 до 10 включительно");
            else {
                switch (operator) {
                    case "+":
                        result = Integer.toString(num1 + num2);
                        break;
                    case "-":
                        result = Integer.toString(num1 - num2);
                        break;
                    case "/":
                        result = Integer.toString(num1 / num2);
                        break;
                    case "*":
                        result = Integer.toString(num1 * num2);
                        break;
                    default:
                        throw new RuntimeException("Калькулятор умеет только складывать, вычитать, умножать и делить");
                }
            }
        } else if ((Character.isDigit(first.charAt(0)) && Character.isLetter(second.charAt(0))) || (Character.isLetter(first.charAt(0)) && Character.isDigit(second.charAt(0))))
            throw new RuntimeException ("Используются одновременно разные системы счисления");
        else {
            for (int i = 0; i<roman.length; i++) {
                if (first.equals(roman[i])) {
                    count1 = i + 1;
                    is_first = false;
                }
                if (second.equals(roman[i])) {
                    count2 = i + 1;
                    is_second = false;
                }
            }
            if(count1>10 ||count2>10 || is_first || is_second)
                throw new RuntimeException("Калькулятор принимает на вход числа от I до X включительно");
            else {
                switch (operator) {
                    case "+":
                        resultRoman = count1 + count2;
                        break;
                    case "-":
                        resultRoman = count1 - count2;
                        break;
                    case "/":
                        resultRoman = count1 / count2;
                        break;
                    case "*":
                        resultRoman = count1 * count2;
                        break;
                    default:
                        throw new RuntimeException("Калькулятор умеет только складывать, вычитать, умножать и делить");
                }
            }
            if (resultRoman<=0)
                throw new RuntimeException("Ответ меньше либо равен нулю, а в римской системе нет нуля отрицательных чисел");
            else
                result = roman[resultRoman-1];
        }
        return result;
    }
}
