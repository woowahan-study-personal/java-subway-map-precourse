package subway;

import java.util.Scanner;
import subway.domain.InitSystem;
import subway.domain.Manager;

public class Application {

    private static final String quitKey = "Q";
    private static Manager manager = new Manager();

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InitSystem.init();
        manager.mainMode(scanner);
    }
}