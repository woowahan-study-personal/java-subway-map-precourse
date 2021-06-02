package subway.view.screen.menu;

import java.util.Scanner;
import subway.domain.Subway;
import subway.view.message.ErrorMessage;
import subway.view.message.InputMessage;
import subway.view.message.MenuMessage;
import subway.view.screen.MenuUI;
import subway.view.screen.info.ViewSubway;
import subway.view.screen.menu.line.LineMenu;
import subway.view.screen.menu.path.PathMenu;
import subway.view.screen.menu.station.StationMenu;
import subway.view.tools.InputTool;
import subway.view.tools.OutputTool;

public class MainMenu implements MenuUI {

    private static final String ROUTE_TO_STATION_MENU = "1";
    private static final String ROUTE_TO_LINE_MENU = "2";
    private static final String ROUTE_TO_PATH_MENU = "3";
    private static final String ROUTE_TO_VIEW_SUBWAY = "4";
    private static final String ROUTE_TO_QUIT = "Q";

    private StationMenu stationMenu;
    private LineMenu lineMenu;
    private PathMenu pathMenu;
    private ViewSubway viewSubway;

    private MainMenu() {
    }

    public MainMenu(Subway subway) {
        super();
        stationMenu = new StationMenu(this);
        lineMenu = new LineMenu(this);
        pathMenu = new PathMenu(this);
        viewSubway = new ViewSubway();
    }

    @Override
    public void show() {
        System.out.println(MenuMessage.mainMenuPageMessage());
        OutputTool.printStringList(MenuMessage.mainMenuCommandsMessageList());
    }

    @Override
    public MenuUI commands(Scanner sc, Subway subway) {
        String command = InputTool.inputString(sc, InputMessage.askFunctionInputMessage(),
            ErrorMessage.failedRequestErrorMessage());

        if (command.equals(ROUTE_TO_STATION_MENU)) {
            return stationMenu;
        }

        if (command.equals(ROUTE_TO_LINE_MENU)) {
            return lineMenu;
        }

        if (command.equals(ROUTE_TO_PATH_MENU)) {
            return pathMenu;
        }

        if (command.equals(ROUTE_TO_VIEW_SUBWAY)) {
            viewSubway.commands(subway);
            return this;
        }

        if (command.equals(ROUTE_TO_QUIT)) {
            return null;
        }

        return this;
    }
}
