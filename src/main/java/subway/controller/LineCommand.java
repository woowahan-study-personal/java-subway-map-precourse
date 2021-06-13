package subway.controller;

import java.util.List;
import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.dto.LineDto;
import subway.view.DefaultView;
import subway.view.LineView;

public class LineCommand extends AbstractCommand {

    private static final String ADD_LINE = "1";
    private static final String DELETE_LINE = "2";
    private static final String PRINT_LINE = "3";
    private static final String BACK = "B";

    private final Scanner scanner;
    private final LineView lineView;

    public LineCommand(Scanner scanner) {
        this.scanner = scanner;
        lineView = new LineView(scanner);
    }

    @Override
    public Command execute() {
        String userInput = lineView.getUserMenuChoiceNumber();
        if (ADD_LINE.equals(userInput)) {
            addLine();
            return this;
        }
        if (DELETE_LINE.equals(userInput)) {
            deleteLine();
            return this;
        }
        if (PRINT_LINE.equals(userInput)) {
            printLines();
            return this;
        }
        if (BACK.equalsIgnoreCase(userInput)) {
            return new Main(scanner);
        }
        DefaultView.badChoiceInput();
        return this;
    }

    private void addLine() {
        String lineName = lineView.getLineName();

        try {
            Station upStation = StationRepository.findByName(lineView.getUpStationName());
            Station downStation = StationRepository.findByName(lineView.getDownStationName());

            Line line = new Line(lineName, upStation, downStation);
            LineRepository.addLine(line);
            lineView.printAddLineOk();
        } catch (Exception e) {
            DefaultView.printError(e.getMessage());
        }
    }

    private void deleteLine() {
        String lineName = lineView.getLineName();
        try {
            LineRepository.deleteLineByName(lineName);
            lineView.printDeleteLineOk();
        } catch (Exception e) {
            DefaultView.printError(e.getMessage());
        }
    }

    private void printLines() {
        List<LineDto> lineDtos = LineDto.of(LineRepository.lines());
        lineView.printLines(lineDtos);
    }
}
