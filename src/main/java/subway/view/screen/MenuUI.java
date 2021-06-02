package subway.view.screen;

import java.util.Scanner;
import subway.domain.Subway;

public interface MenuUI {

    void show();

    MenuUI commands(Scanner sc, Subway subway);
}
