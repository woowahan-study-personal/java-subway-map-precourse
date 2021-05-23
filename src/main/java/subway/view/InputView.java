package subway.view;

import java.util.Scanner;

public class InputView {

    public String inputString(Scanner sc, String message) {
        System.out.println(message);

        try {
            return sc.nextLine();
        } catch (Exception e) {
            System.out.println("[ERROR]: 에러 메시지 출력 방법은 작업 중입니다.");
            return null;
        }
    }

    public int inputInt(Scanner sc, String message) {
        System.out.println(message);

        try {
            return sc.nextInt();
        } catch (Exception e) {
            System.out.println("[ERROR]: 에러 메시지 출력 방법은 작업 중입니다.");
            return -1;
        }
    }
}

