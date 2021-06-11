package subway.controller;

import java.util.List;
import java.util.Scanner;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.dto.StationDto;
import subway.exception.SubwayException;
import subway.view.DefaultView;
import subway.view.StationView;

public class StationCommand extends AbstractCommand {

    private final Scanner scanner;
    private final StationView stationView;

    public StationCommand(Scanner scanner) {
        this.scanner = scanner;
        stationView = new StationView(scanner);
    }

    @Override
    public Command execute() {
        String userInput = stationView.getUserMenuChoiceNumber();
        if ("1".equals(userInput)) {
            addStation();
            return this;
        }
        if ("2".equals(userInput)) {
            deleteStation();
            return this;
        }
        if ("3".equals(userInput)) {
            printStations();
            return this;
        }
        if ("B".equals(userInput)) {
            return new Main(scanner);
        }
        DefaultView.badChoiceInput();
        return this;
    }

    private void addStation() {
        String name = stationView.getAddStationName();
        try {
            StationRepository.addStation(new Station(name));
        } catch (SubwayException e) {
            DefaultView.printError(e.getMessage());
        }
    }

    private void deleteStation() {
        String name = stationView.getDeleteStationName();
        try {
            StationRepository.deleteStation(name);
        } catch (SubwayException e) {
            DefaultView.printError(e.getMessage());
        }
    }

    private void printStations() {
        List<StationDto> stationDtos = StationDto.of(StationRepository.stations());
        stationView.printStations(stationDtos);
    }
}
