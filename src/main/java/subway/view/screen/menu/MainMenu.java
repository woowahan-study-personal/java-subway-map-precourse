package subway.view.screen.menu;

import subway.view.message.MenuMessage;
import subway.view.screen.MenuUI;

public class MainMenu implements MenuUI {

    @Override
    public void show() {
        System.out.println(MenuMessage.mainMenuPageMessage());
    }

    @Override
    public void commandInput() {

    }
}
