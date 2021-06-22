package lesson_2;

import java.util.*;

public class HomeWork2 {

    private List<Long> longSum = new ArrayList<>();
    private long sum;

    public static void main(String[] args) {
        HomeWork2 homeWork2 = new HomeWork2();
        homeWork2.go();
    }

    public void go() {
        String s = GetInput.getUserInputString("Введите целые числа через пробел, сумму которых вы хотите узнать: ");
        splitLine(s);
        Collections.sort(longSum);
        System.out.println("Отсортированный список :" + longSum);
        System.out.println(compareSum(longSum));
        long d = GetInput.getUserInputLong("Введите целое число: ");
        compareNumbers(d);
        d = GetInput.getUserInputLong("Введите целое число: ");
        System.out.println("Возвращается: " + compareNumbersBoolean(d));
        String s1 = GetInput.getUserInputString("Введите строку, которую будем повторять: ");
        int i = (int) GetInput.getUserInputLong("Сколько раз повторим?");// Явное приведение,будем считать что пользователь не введет слишком большое число
        printLineInt(s1, i);
        d = GetInput.getUserInputYear("Введите год, високосность которого будем проверять");
        System.out.println("Год високосный: " + checkYear(d));
    }

    public void splitLine(String s) {
        longSum.clear();
        String[] st;
        st = s.split(" ");
        for (String line : st) {
            if (!(isNumeric(line))) {
                longSum.clear();
                splitLine(GetInput.getUserInputString("Некорректный ввод, повторите целые числа через пробел: "));
                return;
            }
        }
    }

    private boolean isNumeric(String line) {
        try {
            long d = Long.parseLong(line);
            longSum.add(d);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public boolean compareSum(List<Long> longSum) {
        for (Long d1 : longSum) {
            sum += d1;
        }
        if (sum > 10 && sum <= 20) {
            System.out.println("Сумма введеных чисел: " + sum + "\nСумма больше десяти и меньше 20 (включительно)");
            return true;
        } else {
            System.out.println("Сумма введеных чисел: " + sum + "\nНе попадает в промежуток от 10 до 20 (включительно)");
            return false;
        }
    }

    public void compareNumbers(long d) {
        if (d < 0) {
            System.out.println("Введеное число отрицательное " + d);
        } else {
            System.out.println("Введеное число положительное " + d);
        }
    }

    public boolean compareNumbersBoolean(long d) {
        return d < 0;
    }

    public void printLineInt(String s, int i) {
        for (int j = 0; j < i; j++) {
            System.out.println(s);
        }
    }

    public boolean checkYear(long year) {
        return ((year % 4) == 0 && (year % 100) != 0) || (year % 400) == 0;
    }

}
