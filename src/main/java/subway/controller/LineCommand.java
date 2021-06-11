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

    private final Scanner scanner;
    private final LineView lineView;

    public LineCommand(Scanner scanner) {
        this.scanner = scanner;
        lineView = new LineView(scanner);
    }

    @Override
    public Command execute() {
        String userInput = lineView.getUserMenuChoiceNumber();
        if ("1".equals(userInput)) {
            addLine();
            return this;
        }
        if ("2".equals(userInput)) {
            deleteLine();
            return this;
        }
        if ("3".equals(userInput)) {
            printLines();
            return this;
        }
        if ("B".equals(userInput)) {
            return new Main(scanner);
        }
        DefaultView.badChoiceInput();
        return this;
    }

    private void addLine() {
        String lineName = lineView.getLineName();
        Station upStation = StationRepository.findByName(lineView.getUpStationName());
        Station downStation = StationRepository.findByName(lineView.getDownStationName());

        Line line = new Line(lineName, upStation, downStation);
        LineRepository.addLine(line);
    }

    private void deleteLine() {
        String lineName = lineView.getLineName();
        LineRepository.deleteLineByName(lineName);
    }

    private void printLines() {
        List<LineDto> lineDtos = LineDto.of(LineRepository.lines());
        lineView.printLines(lineDtos);
    }
}
