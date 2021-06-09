package subway.domain;

import java.util.Scanner;
import subway.view.Common;
import subway.view.StationView;

public class Manager {

    private static final int NOT_USED = 0;
    private static final String QUIT = "Q";
    private static final String TO_STATION_MANAGE_MODE = "1";
    private static final String TO_ENROLL_STATION = "1";
    private static final String TO_DELETE_STATION = "2";
    private static final String TO_GET_STATION_LIST = "3";
    private static final String BACK_TO_MAIN = "B";

    private LineRepository lineRepository = new LineRepository();
    private StationRepository stationRepository = new StationRepository();

    public void addNewLine(String lineName, String start, String end) {
        Line line = new Line(lineName);
        line.addStation(stationRepository.getStation(start));
        line.addStation(stationRepository.getStation(end));
        lineRepository.addLine(line);
    }

    public void addStation(String stationName) {
        stationRepository.addStation(new Station(stationName));
    }

    public void addStationToLine(String lineName, String stationName, int index) {
        Line line = LineRepository.getLine(lineName);
        Station station = StationRepository.getStation(stationName);
        station.plusUsedCount();
        line.addStation(station, index);
    }

    public void mainMode(Scanner scanner) {
        while (true) {
            Common.printMain();
            String option = scanner.nextLine();
            if (option.equals(TO_STATION_MANAGE_MODE)) {
                stationManageMode(scanner);
            }
            if (option.equals(QUIT)) {
                return;
            }
        }
    }

    public void stationManageMode(Scanner scanner) {
        while (true) {
            StationView.printStationManage();
            Common.printRequireOption();
            String option = scanner.nextLine();
            if (option.equals(TO_ENROLL_STATION)) {
                enrollStation(scanner);
            }
            if (option.equals(TO_DELETE_STATION)) {
                deleteStation(scanner);
            }
            if (option.equals(TO_GET_STATION_LIST)) {
                StationView.printAllStations(StationRepository.stations());
            }
            if (option.equals(BACK_TO_MAIN)) {
                return;
            }
        }
    }

    public void enrollStation(Scanner scanner) {
        StationView.printEnrollStation();
        String stationName = scanner.nextLine();
        if (!Station.isValidName(stationName)) {
            StationView.printNotValidStationName();
            return;
        }
        if (!Station.isUnique(stationName)) {
            StationView.printNotUniqueStationName();
            return;
        }
        StationRepository.addStation(new Station(stationName));
        StationView.printSuccessEnroll();

    }

    public void deleteStation(Scanner scanner) {
        StationView.printDeleteStation();
        String stationName = scanner.nextLine();
        if (StationRepository.getStation(stationName).getUsedCount() == NOT_USED) {
            StationRepository.deleteStation(stationName);
            StationView.printSucessDelete();
            return;
        }
        StationView.printStationUsedInPath();
    }

}
