import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Converting converting = new Converting();
        String[] sign = {"+", "-", "/", "*"};
        String[] regexSing = {"\\+", "-", "/", "\\*"};
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите выражение -> ");
        String exp = scn.nextLine();

        int signIndex = -1;
        for (int i = 0; i < sign.length; i++) {
            if(exp.contains(sign[i])) {
                signIndex = i;
                break;
            }
        }

        if (signIndex == -1) {
            System.out.println("Некоректное выражение");
            return;
        }

        String[] data = exp.split(regexSing[signIndex]);
        if (converting.isRoman(data[0]) == converting.isRoman(data[1])) {
            int num1, num2;
            boolean isRoman = converting.isRoman(data[0]);
            if(isRoman){
                num1 = converting.romanToInt(data[0]);
                num2 = converting.romanToInt(data[1]);
            }else {
                num1 = Integer.parseInt(data[0]);
                num2 = Integer.parseInt(data[1]);
            }
            boolean inRange = converting.inRange(num1, num2);
            int result = 0;
            if(inRange) {
                switch (sign[signIndex]) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;
                }
            } else {
                System.out.println("Вводимые числа вне допустимого диапазона");
                return;
            }

            if(isRoman) {
                System.out.println(converting.intToRoman(result));
            } else {
                System.out.println(result);
            }
        }else {
            System.out.println("Числа в разных форматах");
        }
    }
}