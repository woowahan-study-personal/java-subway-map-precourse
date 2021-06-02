package subway.view.screen.menu.line;

import java.util.Scanner;
import subway.domain.Subway;
import subway.view.message.ErrorMessage;
import subway.view.message.InputMessage;
import subway.view.message.MenuMessage;
import subway.view.screen.MenuUI;
import subway.view.screen.info.line.ViewLine;
import subway.view.screen.manage.line.AddLine;
import subway.view.screen.manage.line.DeleteLine;
import subway.view.tools.InputTool;
import subway.view.tools.OutputTool;

public class LineMenu implements MenuUI {

    private static final String ROUTE_TO_ADD_LINE = "1";
    private static final String ROUTE_TO_DELETE_LINE = "2";
    private static final String ROUTE_TO_VIEW_LINE = "3";
    private static final String ROUTE_TO_NEXT_MENU = "B";

    private AddLine addLine;
    private DeleteLine deleteLine;
    private ViewLine viewLine;
    private MenuUI nextMenu;

    public LineMenu(MenuUI mainMenu) {
        addLine = new AddLine();
        deleteLine = new DeleteLine();
        viewLine = new ViewLine();
        nextMenu = mainMenu;
    }

    @Override
    public void show() {
        System.out.println(MenuMessage.lineManagementPageMessage());
        OutputTool.printStringList(MenuMessage.lineManagementCommandsMessageList());
    }

    @Override
    public MenuUI commands(Scanner sc, Subway subway) {
        MenuUI nextUI = this;
        String command = InputTool.inputString(sc, InputMessage.askFunctionInputMessage(),
            ErrorMessage.failedRequestErrorMessage());

        if (command.equals(ROUTE_TO_ADD_LINE)) {
            addLine.commands(sc, subway);
            nextUI = nextMenu;
        }

        if (command.equals(ROUTE_TO_DELETE_LINE)) {
            deleteLine.commands(sc, subway);
            nextUI = nextMenu;
        }

        if (command.equals(ROUTE_TO_VIEW_LINE)) {
            viewLine.commands(subway);
            nextUI = nextMenu;
        }

        if (command.equals(ROUTE_TO_NEXT_MENU)) {
            nextUI = nextMenu;
        }

        return nextUI;
    }
}
