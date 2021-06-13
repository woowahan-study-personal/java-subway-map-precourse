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

    private static final String ADD_STATION = "1";
    private static final String DELETE_STATION = "2";
    private static final String PRINT_STATION = "3";
    private static final String BACK = "B";

    private final Scanner scanner;
    private final StationView stationView;

    public StationCommand(Scanner scanner) {
        this.scanner = scanner;
        stationView = new StationView(scanner);
    }

    @Override
    public Command execute() {
        String userInput = stationView.getUserMenuChoiceNumber();
        if (ADD_STATION.equals(userInput)) {
            addStation();
            return this;
        }
        if (DELETE_STATION.equals(userInput)) {
            deleteStation();
            return this;
        }
        if (PRINT_STATION.equals(userInput)) {
            printStations();
            return this;
        }
        if (BACK.equalsIgnoreCase(userInput)) {
            return new Main(scanner);
        }
        DefaultView.badChoiceInput();
        return this;
    }

    private void addStation() {
        String name = stationView.getAddStationName();
        try {
            StationRepository.addStation(new Station(name));
            stationView.printAddStationOk();
        } catch (SubwayException e) {
            DefaultView.printError(e.getMessage());
        }
    }

    private void deleteStation() {
        String name = stationView.getDeleteStationName();
        try {
            StationRepository.deleteStation(name);
            stationView.printDeleteStationOk();
        } catch (SubwayException e) {
            DefaultView.printError(e.getMessage());
        }
    }

    private void printStations() {
        List<StationDto> stationDtos = StationDto.of(StationRepository.stations());
        stationView.printStations(stationDtos);
    }
}
