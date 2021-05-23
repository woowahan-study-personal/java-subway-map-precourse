package subway;

import java.util.Scanner;
import subway.domain.Subway;
import subway.view.screen.MenuUI;
import subway.view.screen.menu.*;

public class SubwayManager {

    private Scanner sc = null;
    private Subway subway = null;
    private MenuUI currentMenu = null;

    private MainMenu mainMenu = new MainMenu();
    private StationMenu stationMenu = new StationMenu();
    private LineMenu lineMenu = new LineMenu();
    private PathMenu pathMenu = new PathMenu();

    private SubwayManager() {
    }

    public SubwayManager(Scanner scanner, Subway subway) {
        this.sc = scanner;
        this.subway = subway;
        currentMenu = mainMenu;
    }

    public void run() {
        currentMenu.show();
    }
}
