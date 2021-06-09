package subway;

import java.util.Scanner;
import subway.domain.InitSystem;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InitSystem.init();
    }
}