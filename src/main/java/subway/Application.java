package subway;

import java.util.Scanner;
import subway.domain.Subway;

public class Application {

    private static void runApplication(Scanner scanner) {
        Subway subway = AppInitializer.appInitializer();
        SubwayManager subwayManager = new SubwayManager(scanner, subway);
        subwayManager.run();
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        runApplication(scanner);
    }
}
