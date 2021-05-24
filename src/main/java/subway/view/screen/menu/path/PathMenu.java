package subway.view.screen.menu.path;

import java.util.Scanner;
import subway.SubwayManager;
import subway.domain.Subway;
import subway.view.message.ErrorMessage;
import subway.view.message.InputMessage;
import subway.view.message.MenuMessage;
import subway.view.screen.MenuUI;
import subway.view.screen.manage.path.AddPath;
import subway.view.screen.manage.path.DeletePath;
import subway.view.tools.InputTool;
import subway.view.tools.OutputTool;

public class PathMenu implements MenuUI {

    private AddPath addPath;
    private DeletePath deletePath;
    private MenuUI nextMenu;

    public PathMenu(MenuUI mainMenu) {
        addPath = new AddPath();
        deletePath = new DeletePath();
        nextMenu = mainMenu;
    }

    @Override
    public void show() {
        System.out.println(MenuMessage.pathManagementPageMessage());
        OutputTool.printStringList(MenuMessage.pathManagementCommandsMessageList());
    }

    @Override
    public MenuUI commands(Scanner sc, Subway subway) {
        MenuUI nextUI = this;
        String command = InputTool.inputString(sc, InputMessage.askFunctionInputMessage(),
            ErrorMessage.failedRequestErrorMessage());

        if (command.equals("1")) {
            addPath.commands(sc, subway);
            nextUI = nextMenu;
        }

        if (command.equals("2")) {
            deletePath.commands(sc, subway);
            nextUI = nextMenu;
        }

        if (command.equals("B")) {
            nextUI = nextMenu;
        }

        return nextUI;
    }
}
