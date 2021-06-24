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
        // 노선과 해당 노선의 역을 추가하기
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

        /**
         * 메인 화면
         */
        boolean flag = true;
        while (flag) {
            // A 메인화면
            View.mainView();
            String main_func = View.getSelectNumber(scanner);
            // B -1. 역관리
            if (main_func.equals("1")) {
                stationManagement(scanner);
            }
            // B -2. 노선 관리
            if (main_func.equals("2")) {
                lineManagement(scanner);
            }
            // B -3. 구간 관리
            if (main_func.equals("3")) {
                lineSectionManagement(scanner);
            }
            // B -4. 지하철 노선도 출력
            if (main_func.equals("4")) {
                View.printAllSubwayMap();
            }
            if (main_func.equalsIgnoreCase("Q")) {
                flag = false;
            }
        }
    }

    /**
     * StationRepository 에서 역 찾기
     *
     * @param StationRepository 역저장소
     * @param stationName       역이름
     * @return 찾은 역 or null
     */
    private static Station findByStation(String stationName) {
        List<Station> stations = StationRepository.stations();
        for (int i = 0; i < stations.size(); i++) {
            if (stations.get(i).getName().equals(stationName)) {
//                System.out.println("[찾았다] " + stations.get(i).getName());
                return stations.get(i);
            }
        }
        return null;
    }

    /**
     * LineRepository 에서 노선 찾기
     *
     * @param LineRepository 노선저장소
     * @param lineName       노선이름
     * @return 찾는 노선 or null
     */
    private static Line findByLine(String lineName) {
        List<Line> lines = LineRepository.lines();
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).getName().equals(lineName)) {
                return lines.get(i);
            }
        }
        return null;
    }

    /**
     * 입력 받은 이름 값이 유효한 길이 확인 여부
     */
    private static boolean validNameStr(String str) {
        if (str.length() >= 2 && str.length() <= 5) {
            return true;
        }
        return false;
    }

    /**
     * 초기 값으로 노선 구간에 역 추가하기 (StationRepository 에 등록 되지 않은 역은 자동으로 신규 추가)
     */
    private static void initLineStation(Line line,
        String inputStation) {
        Station station = findByStation(inputStation);
        if (station != null) {
            line.addLineStation(station);
            return;
        }
        Station newStation = new Station(inputStation);
        StationRepository.addStation(newStation);
        line.addLineStation(newStation);
        return;
    }

    /**
     * 1번째 역 관리 화면
     */
    private static void stationManagement(Scanner scanner) {
        View.stationManagementView();
        String func = View.getSelectNumber(scanner);
        if (func.equals("1")) {
            addStation(scanner);
        }
        if (func.equals("2")) {
            deleteStation(scanner);
        }
        if (func.equals("3")) {
            View.printAllStation();
        }
        if (func.equalsIgnoreCase("B")) {
            return;
        }
    }


    /**
     * 1번째 역 관리 화면 - 1 역 등록
     */
    private static void addStation(Scanner scanner) {
        System.out.println("## 등록할 역 이름을 입력하세요.");
        String inputStation = scanner.next();
        if (!validNameStr(inputStation)) {
            return;
        }
        Station station = findByStation(inputStation);
        if (station != null) {
            View.errMsg("이미 등록된 역 이름입니다. ");
            return;
        }
        StationRepository.addStation(new Station(inputStation));
        View.infoMsg("지하철 역이 등록되었습니다.");
        // 테스트 출력
        System.out.println(
            StationRepository.stations().get(StationRepository.stations().size() - 1).getName());
    }

    /**
     * 1번째 역 관리 화면 - 2 역 삭제
     */
    private static void deleteStation(Scanner scanner) {
        System.out.println("## 삭제할 역 이름을 입력하세요.");
        // todo : 노선에 등록된 역은 삭제할 수 없다
        StationRepository.deleteStation(scanner.next());
        View.infoMsg("지하철 역이 삭제되었습니다.");
        // 테스트 출력
        View.printAllStation();
    }

    /**
     * 1번째 역 관리 화면 - 3 역 조회
     */

    /**
     * 2번째 노선 관리 화면
     *
     * @param LineRepository
     */
    private static void lineManagement(Scanner scanner) {
        View.lineManagementView();
        String func = View.getSelectNumber(scanner);
        if (func.equals("1")) {
            addCheckLineAndInitStation(scanner);
        }
        if (func.equals("2")) {
            deleteLine(scanner);
        }
        if (func.equals("3")) {
            printAllLine();
        }
        if (func.equalsIgnoreCase("B")) {
            return;
        }
    }

    /**
     * 2번째 노선 관리 화면 - 1 노선 등록 - 이름 입력과 점검 하기
     */
    private static void addCheckLineAndInitStation(Scanner scanner) {
        System.out.println(newLine + "## 등록할 노선 이름을 입력하세요.");
        String inputLineName = scanner.next();
        Line byLine = findByLine(inputLineName);
        if (byLine != null) {
            View.errMsg("이미 등록된 노선 이름입니다.");
            return;
        }
        System.out.println(newLine + "## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        Station firstStation = findByStation(scanner.next());
        System.out.println(newLine + "## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        Station lastStation = findByStation(scanner.next());
        if (firstStation == null || lastStation == null) {
            View.errMsg("등록된 역만 노선의 구간에 넣을 수 있습니다.");
            return;
        }
        addLine(inputLineName, firstStation, lastStation);
        View.infoMsg("지하철 노선이 등록되었습니다.");
        // 테스트 출력 1개
//        Line line = addLine(LineRepository, inputLineName, firstStation, lastStation);
//        System.out.println(LineRepository.lines().get(LineRepository.lines().size() - 1).getName());
//        List<Station> lineStations = line.getLineStations();
//        for (int i = 0; i < lineStations.size(); i++) {
//            System.out.println("[노선의 역] " + lineStations.get(i).getName());
//        }
    }

    /**
     * 2번째 노선 관리 화면 - 1 노선 등록 - 최종 등록
     */
    private static Line addLine(String inputLineName,
        Station firstStation, Station lastStation) {
        Line line = new Line(inputLineName);
        line.addLineStation(firstStation);
        line.addLineStation(lastStation);
        LineRepository.addLine(line);
        return line;
    }

    /**
     * 2번째 노선 관리 화면 - 2 노선 삭제
     */
    private static void deleteLine(Scanner scanner) {
        System.out.println(newLine + "## 삭제할 노선 이름을 입력하세요.");
        LineRepository.deleteLineByName(scanner.next());
        // todo : 삭제할 노선이 일치하지 않거나 없으면 err
        View.infoMsg("지하철 노선이 삭제되었습니다.");
        // 테스트 출력
        List<Line> lines = LineRepository.lines();
        for (int i = 0; i < lines.size(); i++) {
            System.out.println("[INFO] " + lines.get(i).getName());
        }
        return;
    }

    /**
     * 2번째 노선 관리 화면 - 3 노선 조회
     */
    private static void printAllLine() {
        System.out.println(newLine + "## 노선 목록");
        List<Line> lines = LineRepository.lines();
        for (int i = 0; i < lines.size(); i++) {
            System.out.println("[INFO] " + lines.get(i).getName());
            View.infoMsg(lines.get(i).getName());
        }
        return;
    }

    /**
     * 3번째 구간 관리 화면
     *
     * @param LineRepository
     */
    private static void lineSectionManagement(Scanner scanner) {
        List<Line> lines = LineRepository.lines();
        View.lineSectionManagementView();
        String func = View.getSelectNumber(scanner);
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
        View.infoMsg("구간이 등록되었습니다.");
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
        View.infoMsg("구간이 삭제되었습니다.");
    }

    /**
     * 4번째 지하철 노선도 출력
     *
     * @param LineRepository
     */

}
