package subway.view.screen.menu.line;

import java.util.Scanner;
import subway.SubwayManager;
import subway.domain.Subway;
import subway.view.message.ErrorMessage;
import subway.view.message.InputMessage;
import subway.view.message.MenuMessage;
import subway.view.screen.MenuUI;
import subway.view.tools.InputTool;
import subway.view.tools.OutputTool;

public class LineMenu implements MenuUI {

    @Override
    public void show() {
        System.out.println(MenuMessage.lineManagementPageMessage());
        OutputTool.printStringList(MenuMessage.lineManagementCommandsMessageList());
    }

    @Override
    public MenuUI commands(Scanner sc, Subway subway) {
        MenuUI targetUI = this;
        String command = InputTool.inputString(sc, InputMessage.askFunctionInputMessage(),
            ErrorMessage.failedRequestErrorMessage());

        if (command.equals("1")) {
            return this;
        }

        if (command.equals("2")) {
            return this;
        }

        if (command.equals("3")) {
            return this;
        }

        if (command.equals("B")) {
            return SubwayManager.mainMenu;
        }

        return this;
    }
}
