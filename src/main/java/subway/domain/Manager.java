package subway.domain;

import java.util.Scanner;
import subway.view.CommonView;
import subway.view.LineView;
import subway.view.PathView;
import subway.view.StationView;

public class Manager {

    private static final int NOT_USED = 0;
    private static final String QUIT = "Q";
    private static final String TO_STATION_MANAGE_MODE = "1";
    private static final String TO_ENROLL_STATION = "1";
    private static final String TO_DELETE_STATION = "2";
    private static final String TO_GET_STATION_LIST = "3";
    private static final String BACK_TO_MAIN = "B";
    private static final String TO_LINE_MANAGE_MODE = "2";
    private static final String TO_PATH_MANAGE_MODE = "3";
    private static final String TO_ENROLL_LINE = "1";
    private static final String TO_DELETE_LINE = "2";
    private static final String TO_GET_LINE_LIST = "3";
    private static final String TO_ENROLL_PATH = "1";
    private static final String TO_DELETE_PATH = "2";
    private static final String TO_GET_PATH = "4";

    public void addNewLine(String lineName, String start, String end) {
        Line line = new Line(lineName);
        try {
            Station startStation = StationRepository.getStation(start);
            Station endStation = StationRepository.getStation(end);
            line.addStation(startStation);
            line.addStation(endStation);
            startStation.plusUsedCount();
            endStation.plusUsedCount();
            LineRepository.addLine(line);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void addStation(String stationName) {
        StationRepository.addStation(new Station(stationName));
    }

    public void addStationToLine(String lineName, String stationName, int index) {
        try {
            Line line = LineRepository.getLine(lineName);
            Station station = StationRepository.getStation(stationName);
            station.plusUsedCount();
            line.addStation(station, index);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void mainMode(Scanner scanner) {
        while (true) {
            CommonView.printMain();
            CommonView.printRequireOption();
            String option = scanner.nextLine();
            if (option.equals(TO_STATION_MANAGE_MODE)) {
                stationManageMode(scanner);
            }
            if (option.equals(TO_LINE_MANAGE_MODE)) {
                lineManageMode(scanner);
            }
            if (option.equals(TO_PATH_MANAGE_MODE)) {
                pathManageMode(scanner);
            }
            if (option.equals(TO_GET_PATH)) {
                getAllPaths();
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
        try {
            if (StationRepository.getStation(stationName).getUsedCount() == NOT_USED) {
                StationRepository.deleteStation(stationName);
                StationView.printSuccessDelete();
                return;
            }
            StationView.printStationUsedInPath();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void lineManageMode(Scanner scanner) {
        while (true) {
            LineView.printLineManage();
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
        addNewLine(targetLine, targetLineStart, targetLineEnd);
        LineView.printSuccessEnroll();
    }

    public void deleteLine(Scanner scanner) {
        try {
            LineView.printDeleteLine();
            String targetLine = scanner.nextLine();
            minusUsedStationInLine(LineRepository.getLine(targetLine));
            LineRepository.deleteLineByName(targetLine);
            LineView.printSuccessDelete();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void minusUsedStationInLine(Line line) {
        for (Station station : line.stationsOfLine()) {
            station.minusUsedCount();
        }
    }

    public void pathManageMode(Scanner scanner) {
        while (true) {
            PathView.printPathManage();
            CommonView.printRequireOption();
            String option = scanner.nextLine();
            if (option.equals(TO_ENROLL_PATH)) {
                enrollPath(scanner);
            }
            if (option.equals(TO_DELETE_PATH)) {
                deletePath(scanner);
            }
            if (option.equals(BACK_TO_MAIN)) {
                return;
            }
        }
    }

    public void enrollPath(Scanner scanner) {
        PathView.printEnrollPath();
        String targetLine = scanner.nextLine();
        PathView.printEnrollPathStation();
        String enrollStation = scanner.nextLine();
        PathView.printEnrollPathStationIndex();
        int enrollStationIndex = scanner.nextInt();
        try {
            Station targetStation = StationRepository.getStation(enrollStation);
            LineRepository.getLine(targetLine)
                .addStation(StationRepository.getStation(enrollStation), enrollStationIndex);
            targetStation.plusUsedCount();
            PathView.printSuccessEnrollPath();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deletePath(Scanner scanner) {
        try {
            PathView.printDeletePathLine();
            String targetLineName = scanner.nextLine();
            PathView.printDeletePathStation();
            String targetStationName = scanner.nextLine();
            Station targetStation = StationRepository.getStation(targetStationName);
            Line targetLine = LineRepository.getLine(targetLineName);
            if (targetLine.stationsOfLine().size() <= 2) {
                PathView.printFailDeletePath();
                return;
            }
            targetLine.deletePathByName(targetStationName);
            targetStation.minusUsedCount();
            PathView.printSuccessDeletePath();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void getAllPaths() {
        for (Line line : LineRepository.lines()) {
            PathView.printAllPaths(line);
        }
    }

}
