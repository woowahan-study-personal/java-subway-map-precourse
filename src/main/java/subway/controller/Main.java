package subway.controller;

import java.util.List;
import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.dto.LineDto;
import subway.view.DefaultView;
import subway.view.MainView;

public class Main extends AbstractCommand {

    private static final String QUIT = "Q";
    private static final String STATION_MENU = "1";
    private static final String LINE_MENU = "2";
    private static final String SECTION_MENU = "3";
    private static final String PRINT_SUBWAY = "4";

    private final MainView mainView;
    private final Scanner scanner;

    public Main(Scanner scanner) {
        this.scanner = scanner;
        mainView = new MainView(scanner);
    }

    @Override
    public Command execute() {
        String userInput = mainView.getUserMenuChoiceNumber();
        if (STATION_MENU.equals(userInput)) {
            return new StationCommand(scanner);
        }
        if (LINE_MENU.equals(userInput)) {
            return new LineCommand(scanner);
        }
        if (SECTION_MENU.equals(userInput)) {
            return new SectionCommand(scanner);
        }
        if (PRINT_SUBWAY.equals(userInput)) {
            printSubway();
            return this;
        }
        if (QUIT.equals(userInput)) {
            return new Finish();
        }
        DefaultView.badChoiceInput();
        return this;
    }

    private void printSubway() {
        List<Line> lines = LineRepository.lines();
        List<LineDto> lineDtos = LineDto.of(lines);

        mainView.printSubway(lineDtos);
    }
}
