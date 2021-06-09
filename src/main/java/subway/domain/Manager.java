package subway.domain;

import java.util.Scanner;
import subway.view.CommonView;
import subway.view.LineView;
import subway.view.StationView;

public class Manager {

    private static final int NOT_USED = 0;
    private static final String QUIT = "Q";
    private static final String TO_STATION_MANAGE_MODE = "1";
    private static final String TO_ENROLL_STATION = "1";
    private static final String TO_DELETE_STATION = "2";
    private static final String TO_GET_STATION_LIST = "3";
    private static final String BACK_TO_MAIN = "B";
    private static final String TO_PATH_MANAGE_MODE = "2";
    private static final String TO_ENROLL_LINE = "1";
    private static final String TO_DELETE_LINE = "2";
    private static final String TO_GET_LINE_LIST = "3";


    private LineRepository lineRepository = new LineRepository();
    private StationRepository stationRepository = new StationRepository();

    public void addNewLine(String lineName, String start, String end) {
        Line line = new Line(lineName);
        Station startStation = stationRepository.getStation(start);
        Station endStation = stationRepository.getStation(end);
        line.addStation(startStation);
        line.addStation(endStation);
        startStation.plusUsedCount();
        endStation.plusUsedCount();
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
            CommonView.printMain();
            CommonView.printRequireOption();
            String option = scanner.nextLine();
            if (option.equals(TO_STATION_MANAGE_MODE)) {
                stationManageMode(scanner);
            }
            if (option.equals(TO_PATH_MANAGE_MODE)) {
                lineManageMode(scanner);
            }
            if (option.equals(QUIT)) {
                return;
            }
        }
    }

    public void stationManageMode(Scanner scanner) {
        while (true) {
            StationView.printStationManage();
            CommonView.printRequireOption();
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

    public void lineManageMode(Scanner scanner) {
        while (true) {
            LineView.printPathManage();
            CommonView.printRequireOption();
            String option = scanner.nextLine();
            if (option.equals(TO_ENROLL_LINE)) {
                enrollLine(scanner);
            }
            if (option.equals(TO_GET_LINE_LIST)) {
                LineView.printAllPath(LineRepository.lines());
            }
            if (option.equals(TO_DELETE_LINE)) {
                deleteLine(scanner);
            }
            if (option.equals(BACK_TO_MAIN)) {
                return;
            }
        }
    }
    public void enrollLine(Scanner scanner) {
        LineView.printEnrollLine();
        String targetLine = scanner.nextLine();
        LineView.printEnrollStartLine();
        String targetLineStart = scanner.nextLine();
        LineView.printEnrollEndLine();
        String targetLineEnd = scanner.nextLine();
        if (!Line.isValidName(targetLine)) {
            LineView.printNotValidName();
            return;
        }
        if (!Line.isUnique(targetLine)) {
            LineView.printNotUnique();
            return;
        }
        addNewLine(targetLine,targetLineStart, targetLineEnd);
        LineView.printSuccessEnroll();
    }

    public void deleteLine(Scanner scanner) {
        LineView.printDeleteLine();
        String targetLine = scanner.nextLine();
        minusUsedStationInLine(LineRepository.getLine(targetLine));
        LineRepository.deleteLineByName(targetLine);
        LineView.printSuccessDelete();
    }

    public void minusUsedStationInLine(Line line) {
        for (Station station : line.stationsOfLine()) {
            station.minusUsedCount();
        }
    }

}
