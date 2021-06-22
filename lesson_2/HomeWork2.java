package lesson_2;

import java.util.*;

public class HomeWork2 {

    private final List<Long> longList = new ArrayList<>();
    private long sum;

    public List<Long> getLongList() {
        return longList;
    }

    public static void main(String[] args) {
        HomeWork2 homeWork2 = new HomeWork2();
        homeWork2.go();
    }

    public void go() {
        String inputString = GetInput.getUserInputString("Введите целые числа через пробел, сумму которых вы хотите узнать: ");
        splitLine(inputString);
        Collections.sort(longList);
        System.out.println("Отсортированный список :" + longList);
        System.out.println(compareSum(longList));
        long userInputLong = GetInput.getUserInputLong("Введите целое число: ");
        compareNumbers(userInputLong);
        userInputLong = GetInput.getUserInputLong("Введите целое число: ");
        System.out.println("Возвращается: " + compareNumbersBoolean(userInputLong));
        String userInputString = GetInput.getUserInputString("Введите строку, которую будем повторять: ");
        int userInputLong1 = (int) GetInput.getUserInputLong("Сколько раз повторим?");// Явное приведение,будем считать что пользователь не введет слишком большое число
        printLineInt(userInputString, userInputLong1);
        userInputLong = GetInput.getUserInputPositive("Введите год, високосность которого будем проверять");
        System.out.println("Год високосный: " + checkYear(userInputLong));

    }

    public void splitLine(String s) {
        longList.clear();
        String[] st;
        st = s.split(" ");
        for (String line : st) {
            if (isNumeric(line)) {
                longList.clear();
                splitLine(GetInput.getUserInputString("Некорректный ввод, повторите целые числа через пробел: "));
                return;
            }
        }
    }

    private boolean isNumeric(String line) {
        try {
            long d = Long.parseLong(line);
            longList.add(d);
            return false;
        } catch (Exception exception) {
            return true;
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
