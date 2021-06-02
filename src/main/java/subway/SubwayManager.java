package subway;

import java.util.Scanner;
import subway.domain.Subway;
import subway.view.screen.MenuUI;
import subway.view.screen.menu.MainMenu;

public class SubwayManager {

    public static MainMenu mainMenu;

    private final Scanner sc;
    private final Subway subway;
    private MenuUI currentMenu;

    public SubwayManager(Scanner scanner, Subway subway) {
        this.sc = scanner;
        this.subway = subway;
        mainMenu = new MainMenu(this.subway);
        currentMenu = mainMenu;
    }

    public void run() {
        while (currentMenu != null) {
            currentMenu.show();
            currentMenu = currentMenu.commands(sc, this.subway);
        }
    }
}
