package subway;

import java.util.Scanner;
import subway.domain.InitSystem;
import subway.domain.Manager;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager();
        InitSystem.init(manager);
        manager.mainMode(scanner);
    }
}