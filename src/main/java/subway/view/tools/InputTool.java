package subway.view.tools;

import java.util.Scanner;

public class InputTool {

    public static String inputString(Scanner sc, String message, String errorMessage) {
        System.out.println(message);

        try {
            return sc.nextLine();
        } catch (Exception e) {
            System.out.println(errorMessage);
            return null;
        }
    }

    public static int inputInt(Scanner sc, String message, String errorMessage) {
        System.out.println(message);

        try {
            return sc.nextInt();
        } catch (Exception e) {
            System.out.println(errorMessage);
            return -1;
        }
    }
}

