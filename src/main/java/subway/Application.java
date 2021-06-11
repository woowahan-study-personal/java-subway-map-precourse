package subway;

import java.util.Scanner;
import subway.controller.Command;
import subway.controller.Main;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        new DataLoader().init();

        Command command = new Main(scanner);
        while (!command.isEnd()) {
            command = command.execute();
        }
    }
}
