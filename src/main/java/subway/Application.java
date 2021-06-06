package subway;

import java.util.List;
import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        String newLine = System.lineSeparator();
        // 초기 데이터 입력
        StationRepository stationRepository = new StationRepository();
        LineRepository lineRepository = new LineRepository();

        // System.out.println(stationRepository.stations());
        stationRepository.addStation(new Station("교대역"));
        stationRepository.addStation(new Station("강남역"));
        stationRepository.addStation(new Station("역삼역"));
        stationRepository.addStation(new Station("남부터미널역"));
        stationRepository.addStation(new Station("양재역"));
        stationRepository.addStation(new Station("양재시민의숲역"));
        stationRepository.addStation(new Station("매봉역"));
        // stationRepository.stations().forEach(System.out::println);
        // TODO: str이 아닌 Station 객체로 더 잘 넣어보자
        Line line_a = new Line("2호선");
        line_a.addLineStation("교대역");
        line_a.addLineStation("강남역");
        line_a.addLineStation("역삼역");
        lineRepository.addLine(line_a);
        Line line_b = new Line("3호선");
        line_b.addLineStation("교대역");
        line_b.addLineStation("남부터미널역");
        line_b.addLineStation("양재역");
        line_b.addLineStation("매봉역");
        lineRepository.addLine(line_b);
        Line line_c = new Line("신분당선");
        line_c.addLineStation("강남역");
        line_c.addLineStation("양재역");
        line_c.addLineStation("양재시민의숲역");
        lineRepository.addLine(line_c);

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
                stationManagement(stationRepository, scanner, newLine);
            }
            // B -2. 노선 관리
            if (main_func.equals("2")) {
                lineManagement(lineRepository, scanner, newLine);
            }
            // B -3. 구간 관리
            if (main_func.equals("3")) {
                lineSectionManagement(scanner, newLine);
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
     * 1번째 역 관리 화면
     *
     * @param stationRepository
     */
    private static void stationManagement(StationRepository stationRepository, Scanner scanner,
        String newLine) {
        System.out.println(newLine + "## 역 관리 화면" + newLine
            + "1. 역 등록" + newLine
            + "2. 역 삭제" + newLine
            + "3. 역 조회" + newLine
            + "B. 돌아가기" + newLine);
        System.out.println("## 원하는 기능을 선택하세요.");
        String func = scanner.nextLine();
        if (func.equals("1")) {
            System.out.println("## 등록할 역 이름을 입력하세요.");
            stationRepository.addStation(new Station(scanner.next()));
            System.out.println("[INFO] 지하철 역이 등록되었습니다.");
            // 테스트 출력
            System.out.println(
                stationRepository.stations().get(stationRepository.stations().size() - 1)
                    .getName());
        }
        if (func.equals("2")) {
            System.out.println("## 삭제할 역 이름을 입력하세요.");
            stationRepository.deleteStation(scanner.next());
            System.out.println("[INFO] 지하철 역이 삭제되었습니다.");
            // 테스트 출력
            List<Station> stations = stationRepository.stations();
            for (int i = 0; i < stations.size(); i++) {
                System.out.println("[INFO] " + stations.get(i).getName());
            }
        }
        if (func.equals("3")) {
            System.out.println("## 역 목록");
            List<Station> stations = stationRepository.stations();
            for (int i = 0; i < stations.size(); i++) {
                System.out.println("[INFO] " + stations.get(i).getName());
            }
        }
        if (func.equalsIgnoreCase("B")) {
            return;
        }
    }

    /**
     * 2번째 노선 관리 화면
     *
     * @param lineRepository
     */
    private static void lineManagement(LineRepository lineRepository, Scanner scanner,
        String newLine) {
        System.out.println(newLine + "## 노선 관리 화면" + newLine
            + "1. 노선 등록" + newLine
            + "2. 노선 삭제" + newLine
            + "3. 노선 조회" + newLine
            + "B. 돌아가기" + newLine);
        System.out.println("## 원하는 기능을 선택하세요.");
        String func = scanner.nextLine();
        if (func.equals("1")) {
            System.out.println();
            System.out.println("## 등록할 노선 이름을 입력하세요.");
            // TODO : 이미 등록된 노선이름 Err
            Line line = new Line(scanner.next());
            lineRepository.addLine(line);
            // TODO : 등록된 역이름만 넣도록 점검
            System.out.println();
            System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
            line.addLineStation(scanner.next());

            System.out.println();
            System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
            line.addLineStation(scanner.next());

            System.out.println();
            System.out.println("[INFO] 지하철 노선이 등록되었습니다.");
            // 테스트 출력 1개
            System.out.println(
                lineRepository.lines().get(lineRepository.lines().size() - 1)
                    .getName());
            List<String> lineStations = line.getLineStations();
            for (int i = 0; i < lineStations.size(); i++) {
                System.out.println("[노선의 역] " + lineStations.get(i));
            }
            return;
            // ??? 메인두번반복???
        }
        if (func.equals("2")) {
            System.out.println();
            System.out.println("## 삭제할 노선 이름을 입력하세요.");
            lineRepository.deleteLineByName(scanner.next());
            // ToDO : 삭제할 노선이 일치하지 않거나 없으면
            System.out.println();
            System.out.println("[INFO] 지하철 노선이 삭제되었습니다.");
            // 테스트 출력
            List<Line> lines = lineRepository.lines();
            for (int i = 0; i < lines.size(); i++) {
                System.out.println("[INFO] " + lines.get(i).getName());
            }
            return;
        }
        if (func.equals("3")) {
            System.out.println();
            System.out.println("## 노선 목록");
            List<Line> lines = lineRepository.lines();
            for (int i = 0; i < lines.size(); i++) {
                System.out.println("[INFO] " + lines.get(i).getName());
            }
            return;
        }
        if (func.equalsIgnoreCase("B")) {
            return;
        }
    }

    /**
     * 3번째 구간 관리 화면
     */
    private static void lineSectionManagement(Scanner scanner, String newLine) {
        System.out.println(newLine + "## 구간 관리 화면" + newLine
            + "1. 구간 등록" + newLine
            + "2. 구간 삭제" + newLine
            + "B. 돌아가기" + newLine);
        System.out.println("## 원하는 기능을 선택하세요.");
        String func = scanner.nextLine();
        if (func.equals("1")) {
            System.out.println("## 노선을 입력하세요.");
            System.out.println("## 역이름을 입력하세요.");
            // String st = scanner.next();
            System.out.println("## 순서를 입력하세요.");
            // int idx = scanner.nextInt();
            System.out.println("[INFO] 구간이 등록되었습니다.");
        }
        if (func.equals("2")) {
            System.out.println("## 삭제할 구간의 노선을 입력하세요.");
            System.out.println("## 삭제할 구간의 역을 입력하세요.");
            System.out.println("[INFO] 구간이 삭제되었습니다.");
        }
        if (func.equalsIgnoreCase("B")) {
            return;
        }
    }

    /**
     * 4번째 지하철 노선도 출력
     * @param lineRepository
     */
    private static void printAllSubwayMap(LineRepository lineRepository) {
        System.out.println();
        System.out.println("## 지하철 노선도");
        List<Line> lines = lineRepository.lines();
        for (int i = 0; i < lines.size(); i++) {
            System.out.println("[INFO] " + lines.get(i).getName());
            System.out.println("[INFO] ---");
            List<String> lineStations = lines.get(i).getLineStations();
            for (int j = 0; j < lineStations.size(); j++) {
                System.out.println("[INFO] " + lineStations.get(j));
            }
            System.out.println();
        }
    }
}
