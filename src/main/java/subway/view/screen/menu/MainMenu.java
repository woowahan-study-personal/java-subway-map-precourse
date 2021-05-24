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

        if (command.equals("1")) {
            return stationMenu;
        }

        if (command.equals("2")) {
            return lineMenu;
        }

        if (command.equals("3")) {
            return pathMenu;
        }

        if (command.equals("4")) {
            viewSubway.commands(subway);
            return this;
        }

        if (command.equals("Q")) {
            return null;
        }

        return this;
    }
}
