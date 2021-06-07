package subway;

import java.util.List;
import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class Application {

    public static String newLine = System.lineSeparator();

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        /**
         * 초기 데이터 입력
         */
        StationRepository stationRepository = new StationRepository();
        LineRepository lineRepository = new LineRepository();
        // 노선과 해당 노선의 역을 추가하기
        Line line_a = new Line("2호선");
        initLineStation(stationRepository, line_a, "교대역");
        initLineStation(stationRepository, line_a, "강남역");
        initLineStation(stationRepository, line_a, "역삼역");
        lineRepository.addLine(line_a);
        Line line_b = new Line("3호선");
        initLineStation(stationRepository, line_b, "교대역");
        initLineStation(stationRepository, line_b, "남부터미널역");
        initLineStation(stationRepository, line_b, "양재역");
        initLineStation(stationRepository, line_b, "매봉역");
        lineRepository.addLine(line_b);
        Line line_c = new Line("신분당선");
        initLineStation(stationRepository, line_c, "강남역");
        initLineStation(stationRepository, line_c, "양재역");
        initLineStation(stationRepository, line_c, "양재시민의숲역");
        lineRepository.addLine(line_c);

        /**
         * 메인 화면
         */
        boolean flag = true;
        while (flag) {
            // A 메인화면
            System.out.println(newLine + "## 메인 화면" + newLine
                + "1. 역 관리" + newLine
                + "2. 노선 관리" + newLine
                + "3. 구간 관리" + newLine
                + "4. 지하철 노선도 출력" + newLine
                + "Q. 종료" + newLine);
            System.out.println("## 원하는 기능을 선택하세요.");
            String main_func = scanner.nextLine();
            // B -1. 역관리
            if (main_func.equals("1")) {
                stationManagement(stationRepository, scanner);
            }
            // B -2. 노선 관리
            if (main_func.equals("2")) {
                lineManagement(stationRepository, lineRepository, scanner);
            }
            // B -3. 구간 관리
            if (main_func.equals("3")) {
                lineSectionManagement(lineRepository, scanner);
            }
            // B -4. 지하철 노선도 출력
            if (main_func.equals("4")) {
                printAllSubwayMap(lineRepository);
            }
            if (main_func.equalsIgnoreCase("Q")) {
                flag = false;
            }
        }
    }

    /**
     * StationRepository 에서 역 찾기
     *
     * @param stationRepository 역저장소
     * @param stationName       역이름
     * @return 찾은 역 or null
     */
    private static Station findByStation(StationRepository stationRepository, String stationName) {
        List<Station> stations = stationRepository.stations();
        for (int i = 0; i < stations.size(); i++) {
            if (stations.get(i).getName().equals(stationName)) {
                System.out.println("[찾았다] " + stations.get(i).getName());
                return stations.get(i);
            }
        }
        return null;
    }

    /**
     * LineRepository 에서 노선 찾기
     *
     * @param lineRepository 노선저장소
     * @param lineName       노선이름
     * @return 찾는 노선 or null
     */
    private static Line findByLine(LineRepository lineRepository, String lineName) {
        List<Line> lines = lineRepository.lines();
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).getName().equals(lineName)) {
                return lines.get(i);
            }
        }
        return null;

    }

    /**
     * 초기 값으로 노선 구간에 역 추가하기 (StationRepository 에 등록 되지 않은 역은 자동으로 신규 추가)
     */
    private static void initLineStation(StationRepository stationRepository, Line line,
        String inputStation) {
        Station station = findByStation(stationRepository, inputStation);
        if (station != null) {
            line.addLineStation(station);
            return;
        }
        Station newStation = new Station(inputStation);
        stationRepository.addStation(newStation);
        line.addLineStation(newStation);
        return;
    }

    /**
     * 1번째 역 관리 화면
     */
    private static void stationManagement(StationRepository stationRepository, Scanner scanner) {
        System.out.println(newLine + "## 역 관리 화면" + newLine
            + "1. 역 등록" + newLine + "2. 역 삭제" + newLine
            + "3. 역 조회" + newLine + "B. 돌아가기" + newLine);
        System.out.println("## 원하는 기능을 선택하세요.");
        String func = scanner.nextLine();
        if (func.equals("1")) {
            addStation(stationRepository, scanner);
        }
        if (func.equals("2")) {
            deleteStation(stationRepository, scanner);
        }
        if (func.equals("3")) {
            printAllStation(stationRepository);
        }
        if (func.equalsIgnoreCase("B")) {
            return;
        }
    }

    /**
     * 1번째 역 관리 화면 - 1 역 등록
     */
    private static void addStation(StationRepository stationRepository, Scanner scanner) {
        System.out.println("## 등록할 역 이름을 입력하세요.");
        String inputStation = scanner.next();
        Station station = findByStation(stationRepository, inputStation);
        if (station != null) {
            System.out.println("[ERROR] 이미 등록된 역 이름입니다. ");
            return;
        }
        stationRepository.addStation(new Station(inputStation));
        System.out.println("[INFO] 지하철 역이 등록되었습니다.");
        // 테스트 출력
        System.out.println(
            stationRepository.stations().get(stationRepository.stations().size() - 1)
                .getName());
    }

    /**
     * 1번째 역 관리 화면 - 2 역 삭제
     */
    private static void deleteStation(StationRepository stationRepository, Scanner scanner) {
        System.out.println("## 삭제할 역 이름을 입력하세요.");
        // todo : 노선에 등록된 역은 삭제할 수 없다
        stationRepository.deleteStation(scanner.next());
        System.out.println("[INFO] 지하철 역이 삭제되었습니다.");
        // 테스트 출력
        printAllStation(stationRepository);
    }

    /**
     * 1번째 역 관리 화면 - 3 역 조회
     */
    private static void printAllStation(StationRepository stationRepository) {
        System.out.println("## 역 목록");
        List<Station> stations = stationRepository.stations();
        for (int i = 0; i < stations.size(); i++) {
            System.out.println("[INFO] " + stations.get(i).getName());
        }
    }

    /**
     * 2번째 노선 관리 화면
     *
     * @param lineRepository
     */
    private static void lineManagement(StationRepository stationRepository,
        LineRepository lineRepository, Scanner scanner) {
        System.out.println(newLine + "## 노선 관리 화면" + newLine
            + "1. 노선 등록" + newLine + "2. 노선 삭제" + newLine
            + "3. 노선 조회" + newLine + "B. 돌아가기" + newLine);
        System.out.println("## 원하는 기능을 선택하세요.");
        String func = scanner.nextLine();
        if (func.equals("1")) {
            addCheckLineAndInitStation(stationRepository, lineRepository, scanner);
        }
        if (func.equals("2")) {
            deleteLine(lineRepository, scanner);
        }
        if (func.equals("3")) {
            printAllLine(lineRepository);
        }
        if (func.equalsIgnoreCase("B")) {
            return;
        }
    }

    /**
     * 2번째 노선 관리 화면 - 1 노선 등록 - 이름 입력과 점검 하기
     */
    private static void addCheckLineAndInitStation(StationRepository stationRepository,
        LineRepository lineRepository, Scanner scanner) {
        System.out.println(newLine + "## 등록할 노선 이름을 입력하세요.");
        String inputLineName = scanner.next();
        Line byLine = findByLine(lineRepository, inputLineName);
        if (byLine != null) {
            System.out.println("[ERROR] 이미 등록된 노선 이름입니다.");
            return;
        }
        System.out.println(newLine + "## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        Station firstStation = findByStation(stationRepository, scanner.next());
        System.out.println(newLine + "## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        Station lastStation = findByStation(stationRepository, scanner.next());
        if (firstStation == null || lastStation == null) {
            System.out.println("[ERROR] 등록된 역만 노선의 구간에 넣을 수 있습니다.");
            return;
        }
        addLine(lineRepository, inputLineName, firstStation, lastStation);
        System.out.println(newLine + "[INFO] 지하철 노선이 등록되었습니다.");
        // 테스트 출력 1개
//        Line line = addLine(lineRepository, inputLineName, firstStation, lastStation);
//        System.out.println(lineRepository.lines().get(lineRepository.lines().size() - 1).getName());
//        List<Station> lineStations = line.getLineStations();
//        for (int i = 0; i < lineStations.size(); i++) {
//            System.out.println("[노선의 역] " + lineStations.get(i).getName());
//        }
    }

    /**
     * 2번째 노선 관리 화면 - 1 노선 등록 - 최종 등록
     */
    private static Line addLine(LineRepository lineRepository, String inputLineName,
        Station firstStation, Station lastStation) {
        Line line = new Line(inputLineName);
        line.addLineStation(firstStation);
        line.addLineStation(lastStation);
        lineRepository.addLine(line);
        return line;
    }

    /**
     * 2번째 노선 관리 화면 - 2 노선 삭제
     */
    private static void deleteLine(LineRepository lineRepository, Scanner scanner) {
        System.out.println(newLine + "## 삭제할 노선 이름을 입력하세요.");
        lineRepository.deleteLineByName(scanner.next());
        // todo : 삭제할 노선이 일치하지 않거나 없으면 err
        System.out.println(newLine + "[INFO] 지하철 노선이 삭제되었습니다.");
        // 테스트 출력
        List<Line> lines = lineRepository.lines();
        for (int i = 0; i < lines.size(); i++) {
            System.out.println("[INFO] " + lines.get(i).getName());
        }
        return;
    }

    /**
     * 2번째 노선 관리 화면 - 3 노선 조회
     */
    private static void printAllLine(LineRepository lineRepository) {
        System.out.println(newLine + "## 노선 목록");
        List<Line> lines = lineRepository.lines();
        for (int i = 0; i < lines.size(); i++) {
            System.out.println("[INFO] " + lines.get(i).getName());
        }
        return;
    }

    /**
     * 3번째 구간 관리 화면
     *
     * @param lineRepository
     */
    private static void lineSectionManagement(LineRepository lineRepository, Scanner scanner) {
        List<Line> lines = lineRepository.lines();
        System.out.println(newLine + "## 구간 관리 화면" + newLine
            + "1. 구간 등록" + newLine
            + "2. 구간 삭제" + newLine
            + "B. 돌아가기" + newLine);
        System.out.println("## 원하는 기능을 선택하세요.");
        String func = scanner.nextLine();
        if (func.equals("1")) {
            addLineSection(scanner, lines);
        }
        if (func.equals("2")) {
            deleteLineSection(scanner, lines);
        }
        if (func.equalsIgnoreCase("B")) {
            return;
        }
    }

    /**
     * 3번째 구간 관리 화면 - 1 구간 등록
     *
     * @param lines
     */
    private static void addLineSection(Scanner scanner, List<Line> lines) {
        System.out.println("## 노선을 입력하세요.");
        String inputLineName = scanner.next();
        System.out.println("## 역이름을 입력하세요.");
        String inputStationName = scanner.next();
        System.out.println("## 순서를 입력하세요.");
        int inputIndex = scanner.nextInt();
        for (Line line : lines) {
            if (line.getName().equals(inputLineName)) {
                line.addLineStation(inputIndex - 1, new Station(inputStationName)); // Temp
                // 해당 노선의 역 테스트 출력
                for (Station station : line.getLineStations()) {
                    System.out.println(station);
                }
            }
        }
        System.out.println("[INFO] 구간이 등록되었습니다.");
    }

    /**
     * 3번째 구간 관리 화면 - 2 구간 삭제
     *
     * @param lines
     */
    private static void deleteLineSection(Scanner scanner, List<Line> lines) {
        System.out.println("## 삭제할 구간의 노선을 입력하세요.");
        String deleteLineName = scanner.next();
        System.out.println("## 삭제할 구간의 역을 입력하세요.");
        String deleteStationName = scanner.next();
        for (Line line : lines) {
            if (line.getName().equals(deleteLineName)) {
                line.deleteLineStation(deleteStationName);
                // 해당 노선의 역 테스트 출력
                for (Station station : line.getLineStations()) {
                    System.out.println("[남은역]" + station);
                }
            }
        }
        System.out.println("[INFO] 구간이 삭제되었습니다.");
    }

    /**
     * 4번째 지하철 노선도 출력
     *
     * @param lineRepository
     */
    private static void printAllSubwayMap(LineRepository lineRepository) {
        System.out.println();
        System.out.println("## 지하철 노선도");
        List<Line> lines = lineRepository.lines();
        for (int i = 0; i < lines.size(); i++) {
            System.out.println("[INFO] " + lines.get(i).getName());
            System.out.println("[INFO] ---");
            List<Station> lineStations = lines.get(i).getLineStations();
            for (int j = 0; j < lineStations.size(); j++) {
                System.out.println("[INFO] " + lineStations.get(j).getName());
            }
            System.out.println();
        }
    }
}
