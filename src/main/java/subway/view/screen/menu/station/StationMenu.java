package subway.view.screen.menu.station;

import java.util.Scanner;
import subway.domain.Subway;
import subway.view.message.ErrorMessage;
import subway.view.message.InputMessage;
import subway.view.message.MenuMessage;
import subway.view.screen.MenuUI;
import subway.view.screen.info.station.ViewStation;
import subway.view.screen.manage.station.AddStation;
import subway.view.screen.manage.station.DeleteStation;
import subway.view.tools.InputTool;
import subway.view.tools.OutputTool;

public class StationMenu implements MenuUI {

    private AddStation addStation;
    private DeleteStation deleteStation;
    private ViewStation viewStation;
    private MenuUI nextMenu;

    public StationMenu(MenuUI mainMenu) {
        addStation = new AddStation();
        deleteStation = new DeleteStation();
        viewStation = new ViewStation();
        nextMenu = mainMenu;
    }

    @Override
    public void show() {
        System.out.println(MenuMessage.stationManagementPageMessage());
        OutputTool.printStringList(MenuMessage.stationManagementCommandsMessageList());
    }

    @Override
    public MenuUI commands(Scanner sc, Subway subway) {
        MenuUI nextUI = this;
        String command = InputTool.inputString(sc, InputMessage.askFunctionInputMessage(),
            ErrorMessage.failedRequestErrorMessage());

        if (command.equals("1")) {
            addStation.commands(sc, subway);
            nextUI = nextMenu;
        }

        if (command.equals("2")) {
            deleteStation.commands(sc, subway);
            nextUI = nextMenu;
        }

        if (command.equals("3")) {
            viewStation.commands(subway);
            nextUI = nextMenu;
        }

        if (command.equals("B")) {
            nextUI = nextMenu;
        }

        return nextUI;
    }
}