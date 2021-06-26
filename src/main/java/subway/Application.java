package subway;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class Application {

    private static final String FIRST = "1";
    private static final String SECOND = "2";
    private static final String THIRD = "3";
    private static final String FOURTH = "4";
    private static final String QUIT = "Q";
    private static final String BACK = "B";
    private static final String MAIN_INFO_MSG = "## 원하는 기능을 선택하세요.";
    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 5;
    private static String newLine = System.lineSeparator();

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Line line_a = new Line("2호선");
        initLineStation(line_a, "교대역");
        initLineStation(line_a, "강남역");
        initLineStation(line_a, "역삼역");
        LineRepository.addLine(line_a);
        Line line_b = new Line("3호선");
        initLineStation(line_b, "교대역");
        initLineStation(line_b, "남부터미널역");
        initLineStation(line_b, "양재역");
        initLineStation(line_b, "매봉역");
        LineRepository.addLine(line_b);
        Line line_c = new Line("신분당선");
        initLineStation(line_c, "강남역");
        initLineStation(line_c, "양재역");
        initLineStation(line_c, "양재시민의숲역");
        LineRepository.addLine(line_c);

        boolean flag = true;
        while (flag) {
            View.mainView();
            String main_func = View.getScanMsg(scanner, MAIN_INFO_MSG);
            if (FIRST.equals(main_func)) {
                stationManagement(scanner);
            }
            if (SECOND.equals(main_func)) {
                lineManagement(scanner);
            }
            if (THIRD.equals(main_func)) {
                lineSectionManagement(scanner);
            }
            if (FOURTH.equals(main_func)) {
                View.printAllSubwayMap();
            }
            if (QUIT.equalsIgnoreCase(main_func)) {
                flag = false;
            }
        }
    }

    private static Optional<Station> findByStation(String stationName) {
        List<Station> stations = StationRepository.stations();
        for (int i = 0; i < stations.size(); i++) {
            if (stations.get(i).getName().equals(stationName)) {
                return Optional.of(stations.get(i));
            }
        }
        return Optional.empty();
    }

    private static Optional<Line> findByLine(String lineName) {
        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            if (line.getName().equals(lineName)) {
                return Optional.of(line);
            }
        }
        return Optional.empty();
    }

    private static boolean validNameStr(String validName) {
        return validName.length() >= MIN_NAME_LENGTH && validName.length() <= MAX_NAME_LENGTH;
    }

    private static void initLineStation(Line line, String inputStation) {
        Optional<Station> station = findByStation(inputStation);
        if (station.isPresent()) {
            line.addLineStation(station.get());
            return;
        }
        Station newStation = new Station(inputStation);
        StationRepository.addStation(newStation);
        line.addLineStation(newStation);
    }

    private static void stationManagement(Scanner scanner) {
        View.stationManagementView();
        String func = View.getScanMsg(scanner, MAIN_INFO_MSG);
        if (FIRST.equals(func)) {
            addStation(scanner);
        }
        if (SECOND.equals(func)) {
            deleteStation(scanner);
        }
        if (THIRD.equals(func)) {
            View.printAllStation();
        }
        if (BACK.equalsIgnoreCase(func)) {
            return;
        }
    }

    private static void addStation(Scanner scanner) {
        String inputStation = View.getScanMsg(scanner, "## 등록할 역 이름을 입력하세요.");
        if (!validNameStr(inputStation)) {
            return;
        }
        Optional<Station> station = findByStation(inputStation);
        if (station.isPresent()) {
            View.errMsg("이미 등록된 역 이름입니다. ");
            return;
        }
        StationRepository.addStation(new Station(inputStation));
        View.infoMsg("지하철 역이 등록되었습니다.");
    }

    private static void deleteStation(Scanner scanner) {
        String inputStation = View.getScanMsg(scanner, "## 삭제할 역 이름을 입력하세요.");
        // todo : 노선에 등록된 역은 삭제할 수 없다
        StationRepository.deleteStation(inputStation);
        View.infoMsg("지하철 역이 삭제되었습니다.");
    }

    private static void lineManagement(Scanner scanner) {
        View.lineManagementView();
        String func = View.getScanMsg(scanner, MAIN_INFO_MSG);
        if (FIRST.equals(func)) {
            addCheckLineAndInitStation(scanner);
        }
        if (SECOND.equals(func)) {
            deleteLine(scanner);
        }
        if (THIRD.equals(func)) {
            printAllLine();
        }
        if (BACK.equalsIgnoreCase(func)) {
            return;
        }
    }

    private static void addCheckLineAndInitStation(Scanner scanner) {
        String inputLineName = View.getScanMsg(scanner, newLine + "## 등록할 노선 이름을 입력하세요.");
        Optional<Line> byLine = findByLine(inputLineName);
        if (byLine.isPresent()) {
            View.errMsg("이미 등록된 노선 이름입니다.");
            return;
        }
        String inputFirstStationName = View
            .getScanMsg(scanner, newLine + "## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        Optional<Station> firstStation = findByStation(inputFirstStationName);
        String inputLastStationName = View
            .getScanMsg(scanner, newLine + "## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        Optional<Station> lastStation = findByStation(inputLastStationName);
        if (firstStation.isEmpty() || lastStation.isEmpty()) {
            View.errMsg("등록된 역만 노선의 구간에 넣을 수 있습니다.");
            return;
        }
        addLine(inputLineName, firstStation.get(), lastStation.get());
        View.infoMsg("지하철 노선이 등록되었습니다.");
    }

    private static void addLine(String inputLineName,
        Station firstStation, Station lastStation) {
        Line line = new Line(inputLineName);
        line.addLineStation(firstStation);
        line.addLineStation(lastStation);
        LineRepository.addLine(line);
    }

    private static void deleteLine(Scanner scanner) {
        String inputLineName = View.getScanMsg(scanner, newLine + "## 삭제할 노선 이름을 입력하세요.");
        LineRepository.deleteLineByName(inputLineName);
        // todo : 삭제할 노선이 일치하지 않거나 없으면 err
        View.infoMsg("지하철 노선이 삭제되었습니다.");
        return;
    }

    private static void printAllLine() {
        View.printMessage(newLine + "## 노선 목록");
        List<Line> lines = LineRepository.lines();
        for (int i = 0; i < lines.size(); i++) {
            View.infoMsg(lines.get(i).getName());
        }
        return;
    }

    private static void lineSectionManagement(Scanner scanner) {
        List<Line> lines = LineRepository.lines();
        View.lineSectionManagementView();
        String func = View.getScanMsg(scanner, MAIN_INFO_MSG);
        if (FIRST.equals(func)) {
            addLineSection(scanner, lines);
        }
        if (SECOND.equals(func)) {
            deleteLineSection(scanner, lines);
        }
        if (BACK.equalsIgnoreCase(func)) {
            return;
        }
    }

    private static void addLineSection(Scanner scanner, List<Line> lines) {
        String inputLineName = View.getScanMsg(scanner, "## 노선을 입력하세요.");
        String inputStationName = View.getScanMsg(scanner, "## 역이름을 입력하세요.");
        int inputIndex = View.getIndex(scanner, "## 순서를 입력하세요.");
        for (Line line : lines) {
            if (line.getName().equals(inputLineName)) {
                line.addLineStation(inputIndex - 1, new Station(inputStationName)); // Temp
            }
        }
        View.infoMsg("구간이 등록되었습니다.");
    }

    private static void deleteLineSection(Scanner scanner, List<Line> lines) {
        String deleteLineName = View.getScanMsg(scanner, "## 삭제할 구간의 노선을 입력하세요.");
        String deleteStationName = View.getScanMsg(scanner, "## 삭제할 구간의 역을 입력하세요.");
        for (Line line : lines) {
            if (line.getName().equals(deleteLineName)) {
                line.deleteLineStation(deleteStationName);
            }
        }
        View.infoMsg("구간이 삭제되었습니다.");
    }

}
