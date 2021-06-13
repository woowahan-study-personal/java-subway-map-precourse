package subway.controller;

import java.util.Scanner;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.DefaultView;
import subway.view.SectionView;

public class SectionCommand extends AbstractCommand {

    private static final String ADD_SECTION = "1";
    private static final String DELETE_SECTION = "2";
    private static final String BACK = "B";

    private final Scanner scanner;
    private final SectionView sectionView;

    public SectionCommand(Scanner scanner) {
        this.scanner = scanner;
        sectionView = new SectionView(scanner);
    }

    @Override
    public Command execute() {
        String userInput = sectionView.getUserMenuChoiceNumber();
        if (ADD_SECTION.equals(userInput)) {
            addSection();
            return this;
        }
        if (DELETE_SECTION.equals(userInput)) {
            deleteSection();
            return this;
        }
        if (BACK.equalsIgnoreCase(userInput)) {
            return new Main(scanner);
        }
        DefaultView.badChoiceInput();
        return this;
    }

    private void addSection() {
        String lineName = sectionView.getLineName();
        String stationName = sectionView.getStationName();
        Station station = StationRepository.findByName(stationName);
        String index = sectionView.getIndex();

        try {
            LineRepository.addSection(lineName, station, Integer.parseInt(index));
            sectionView.printAddSectionOk();
        } catch (Exception e) {
            DefaultView.printError(e.getMessage());
        }
    }

    private void deleteSection() {
        String lineName = sectionView.getLineName();
        String stationName = sectionView.getStationName();
        Station station = StationRepository.findByName(stationName);

        try {
            LineRepository.deleteSection(lineName, station);
            sectionView.printDeleteSectionOk();
        } catch (Exception e) {
            DefaultView.printError(e.getMessage());
        }
    }
}
