package lesson_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GetInput {

    private static long inputNumber;

    public static String getUserInputString(String text) {
        String inputLine = null;
        System.out.print(text + " ");
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            inputLine = in.readLine();
            if (inputLine.length() == 0) {
                System.out.println("Некорректный ввод, повторите ");
                getUserInputString("");
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine;
    }

    public static long getUserInputLong(String text) {
        System.out.print(text + " ");
        Scanner in = new Scanner(System.in);
        try {
            inputNumber = in.nextLong();
        } catch (Exception e) {
            getUserInputLong("Некорректный ввод, повторите");
        }
        return inputNumber;
    }

    public static int getUserInputPositive(String text) {
        System.out.print(text + " ");
        Scanner in = new Scanner(System.in);
        try {
            inputNumber = in.nextInt();
        } catch (Exception e) {
            getUserInputPositive("Некорректный ввод, повторите");
        }
        if (inputNumber < 0) {
            getUserInputPositive("Некорректный ввод, повторите");
        }
        return (int) inputNumber;
    }

}
