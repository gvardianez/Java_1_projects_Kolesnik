package lesson_3;

import lesson_2.GetInput;
import lesson_2.HomeWork2;

import java.util.Arrays;
import java.util.List;

public class HomeWork3 {

    public static void main(String[] args) {
        new HomeWork3().go();
    }

    private void go() {
        int value = GetInput.getUserInputPositive("Введите сколько числе (нулей и единиц) должно быть в вашем массиве: ");
        replace(value);
        int step = GetInput.getUserInputPositive("С каким шагом будем заполнять массив от 1 до 100");
        System.out.println("Ваш массив от 1 до 100 с шагом " + step + " " + Arrays.toString(filling(step)));
        value = GetInput.getUserInputPositive("Введите сколько чисел (числа будут заданы рэндомно от 0 до 10) должно быть в массиве");
        multiplication(value);
        value = GetInput.getUserInputPositive("Введите сколько строк и столбцов будет в вашем случайном массиве (будет создан квадратный двумерный массив с числами от 0 до 9): ");
        replaceToOne(value);
        int arrayNumbers = GetInput.getUserInputPositive("Введите сколько чисел будет в вашем массиве :");
        int numbers = GetInput.getUserInputPositive("Введите какие это будут числа :");
        createArray(arrayNumbers,numbers);
        value = GetInput.getUserInputPositive("Введите сколько случайных чисел будет в вашем массиве :");
        minMaxNumber(value);
        String input = GetInput.getUserInputString("Введите массив чисел (числа через пробел) для проверки равенства сумм в правой и левой частях :");
        HomeWork2 homeWork2 = new HomeWork2();
        homeWork2.splitLine(input);
        List<Long> arrayList = homeWork2.getLongList();
        long[] array = listToArray(arrayList);
        System.out.println(sumPartsArray(array));
        arrayNumbers = GetInput.getUserInputPositive("Введите сколько случайных чисел будет в вашем массиве :");
        int count = (int) GetInput.getUserInputLong("Введите сколько раз будем смещать(если вправо, то положительное значение, если влево, то отрицательное :");
        System.out.println(Arrays.toString(moveArray(arrayNumbers, count)));
    }

    private void replace(int value) {
        int[] zeroAndOne = new int[value];
        for (int i = 0; i < value; i++) {
            zeroAndOne[i] = (int) (Math.random() * 2);
        }
        System.out.println("Случайный массив до замены:   " + Arrays.toString(zeroAndOne));
        for (int i = 0; i < value; i++) {
            if (zeroAndOne[i] == 0) {
                zeroAndOne[i] = 1;
            } else {
                zeroAndOne[i] = 0;
            }
        }
        System.out.println("Случайный массив после замены:" + Arrays.toString(zeroAndOne));
    }

    private int[] filling(int step) {
        int quantity = (int) Math.ceil(100 / (double) step);
        int value = 1;
        int[] array = new int[quantity];
        for (int i = 0; i < quantity; i++) {
            array[i] = value;
            value += step;
        }
        return array;
    }

    public void multiplication(int value) {
        int[] numbers = new int[value];
        for (int i = 0; i < value; i++) {
            numbers[i] = (int) (Math.random() * 11);
        }
        System.out.println("Ваш массив до умножения:                          " + Arrays.toString(numbers));

        for (int i = 0; i < value; i++) {
            if (numbers[i] < 6) {
                numbers[i] = numbers[i] * 2;
            }
        }
        System.out.println("Ваш массив после умножения чисел меньше 6 на два: " + Arrays.toString(numbers));
    }

    public void replaceToOne(int value) {
        int[][] numbers = new int[value][value];
        for (int i = 0; i < value; i++) {
            for (int j = 0; j < value; j++) {
                numbers[i][j] = (int) (Math.random() * 10);
            }
        }

        System.out.println("Ваш рэндомный двумерный массив до замены значений:");
        printArray(numbers);

        for (int i = 0; i < value; i++) {
            for (int j = 0; j < value; j++) {
                if ((i == j) || (i + j == value - 1)) {
                    numbers[i][j] = 1;
                }
            }
        }

        System.out.println("Ваш рэндомный двумерный массив после замены значений:");
        printArray(numbers);
    }

    public void createArray(int value, int numbers) {
        int[] array = new int[value];
        for (int i = 0; i < value; i++) {
            array[i] = numbers;
        }
        System.out.println("Ваш массив с заданными прараметрами: " + Arrays.toString(array));
    }

    public void minMaxNumber(int value) {
        int max, min;
        int[] numbers = new int[value];
        for (int i = 0; i < value; i++) {
            numbers[i] = (int) (Math.random() * 101);
        }
        System.out.println("Случайный массив: " + Arrays.toString(numbers));
        max = numbers[0];
        min = numbers[0];
        for (int i = 0; i < value; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            } else if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        System.out.println("Минимальное значение в массиве: " + min + "\nМаксимальное значение в массиве : " + max);
    }

    public long[] listToArray(List<Long> list) {
        long[] array = new long[list.size()];
        int count = 0;
        for (Long l : list) {
            array[count] = l;
            count++;
        }
        return array;
    }

    public boolean sumPartsArray(long[] array) {  // Вспомогательные массивы для наглядного вывода
        long[] left, right;
        long sumLeft, sumRight;
        boolean sum = false;
        for (int i = 1; i < array.length; i++) {
            sumLeft = 0;
            sumRight = 0;
            left = new long[i];
            right = new long[array.length - i];
            for (int j = 0; j < i; j++) {
                left[j] = array[j];
                sumLeft += array[j];
            }
            for (int k = 0; k < array.length - i; k++) {
                right[k] = array[k + i];
                sumRight += array[k];
            }
            if (sumLeft == sumRight) {
                System.out.println(Arrays.toString(left) + "  " + Arrays.toString(right));
                sum = true;
            }
        }
        return sum;
    }

    public int[] moveArray(int value, int count) {
        int[] numbers = new int[value];
        int temp;
        for (int i = 0; i < value; i++) {     // Создание случайного массива от 0 до 100
            numbers[i] = (int) (Math.random() * 101);
        }

        System.out.println("Массивы до и после смещения:\n" + Arrays.toString(numbers));

        if (count > 0) {
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < numbers.length - 1; j++) {
                    temp = numbers[0];
                    numbers[0] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        } else {
            count *= -1;
            for (int i = 0; i < count; i++) {
                for (int j = numbers.length - 2; j >= 0; j--) {
                    temp = numbers[0];
                    numbers[0] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        return numbers;
    }

    public void printArray(int[][] array) {
        int length = array.length;
        for (int[] ints : array) {
            for (int j = 0; j < length; j++) {
                System.out.print(ints[j] + "  ");
            }
            System.out.println();
        }
    }

}


