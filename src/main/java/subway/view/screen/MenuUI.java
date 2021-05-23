package subway.view.screen;

import java.util.Scanner;
import subway.domain.Subway;

public interface MenuUI {
    public void show();
    public MenuUI commands(Scanner sc, Subway subway);
}
