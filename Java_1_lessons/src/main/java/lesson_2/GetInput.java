package lesson_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GetInput {

    private static long l;

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
            l = in.nextLong();
        } catch (Exception e) {
            getUserInputLong("Некорректный ввод, повторите");
        }
        return l;
    }

    public static long getUserInputYear(String text) {
        System.out.print(text + " ");
        Scanner in = new Scanner(System.in);
        try {
            l = in.nextLong();
        } catch (Exception e) {
            getUserInputLong("Некорректный ввод, повторите");
        }
        if (l < 0) {
            getUserInputLong("Некорректный ввод, повторите");
        }
        return l;
    }

}
