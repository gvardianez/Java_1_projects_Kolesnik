package lesson_1;

public class HomeWorkApp {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printThreeWords() {
        System.out.println("Orange \n" + "Banana \n" + "Apple");
    }

    public static void checkSumSign() {
        int a = 10;
        int b = -100;
        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = 777;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else if (value > 100) {           //Или просто: else System.out.println("Зеленый");
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 666;
        int b = 777;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }


}