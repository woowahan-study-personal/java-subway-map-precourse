package subway;

import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        StationRepository stationRepository = new StationRepository();
        LineRepository lineRepository = new LineRepository();
        
        // System.out.println(stationRepository.stations());
        stationRepository.addStation(new Station("교대역"));
        stationRepository.addStation(new Station("강남역"));
        stationRepository.addStation(new Station("역삼역"));
        // stationRepository.stations().forEach(System.out::println);

        lineRepository.addLine(new Line("2호선"));
        lineRepository.addLine(new Line("3호선"));
        lineRepository.addLine(new Line("신분당선"));

        boolean flag = true;
        while (flag) {
            // A 메인화면
            System.out.println("## 메인 화면\n"
                + "1. 역 관리\n"
                + "2. 노선 관리\n"
                + "3. 구간 관리\n"
                + "4. 지하철 노선도 출력\n"
                + "Q. 종료");
            System.out.println("## 원하는 기능을 선택하세요.");
            int main_func = scanner.nextInt();
            // B -1. 역관리
            if (main_func == 1) {
                System.out.println("## 역 관리 화면\n"
                    + "1. 역 등록\n"
                    + "2. 역 삭제\n"
                    + "3. 역 조회\n"
                    + "B. 돌아가기");
                System.out.println("## 원하는 기능을 선택하세요.");
                int func = scanner.nextInt();
                if (func == 1) {
                    System.out.println("## 등록할 역 이름을 입력하세요.");

                    stationRepository.addStation(new Station(scanner.next()));
                    System.out.println("[INFO] 지하철 역이 등록되었습니다.");
                    // 테스트 출력
                    System.out.println(
                        stationRepository.stations().get(stationRepository.stations().size()-1)
                            .getName());
                    // A 메인화면 돌아가기/재귀
                }
                if (func == 2) {
                    System.out.println("## 삭제할 역 이름을 입력하세요.");

                    stationRepository.deleteStation(scanner.next());
                    System.out.println("[INFO] 지하철 역이 삭제되었습니다.");
                    // 테스트 출력
                    for (int i = 0; i < stationRepository.stations().size(); i++) {
                        System.out
                            .println("[INFO] " + stationRepository.stations().get(i).getName());
                    }
                }
                if (func == 3) {
                    System.out.println("## 역 목록");
                    for (int i = 0; i < stationRepository.stations().size(); i++) {
                        System.out
                            .println("[INFO] " + stationRepository.stations().get(i).getName());
                    }
                }
                // A 메인화면 돌아가기/재귀
            }
            // B -2. 노선 관리
            if(main_func == 2) {
                System.out.println("## 노선 관리 화면\n"
                    + "1. 노선 등록\n"
                    + "2. 노선 삭제\n"
                    + "3. 노선 조회\n"
                    + "B. 돌아가기");
                System.out.println("## 원하는 기능을 선택하세요.");
                int func = scanner.nextInt();
                if (func == 1) {
                    System.out.println("## 등록할 노선 이름을 입력하세요.");
                    Line line = new Line(scanner.next());
                    lineRepository.addLine(line);
                    // To DO !!!
                    System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
                    line.addLineStation(scanner.next());
                    System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
                    line.addLineStation(scanner.next());
                    System.out.println("[INFO] 지하철 노선이 등록되었습니다.");
                    // 테스트 출력 1개
                    System.out.println(
                        lineRepository.lines().get(lineRepository.lines().size()-1)
                            .getName());
                    for (int i = 0; i < line.getLineStations().size(); i++) {
                        System.out
                            .println("[노선의 역] " + line.getLineStations().get(i));
                    }
                    // A 메인화면 돌아가기/재귀
                }
                if (func == 2) {
                    System.out.println("## 삭제할 노선 이름을 입력하세요.");

                    lineRepository.deleteLineByName(scanner.next());
                    System.out.println("[INFO] 지하철 노선이 삭제되었습니다.");
                    // 테스트 출력
                    for (int i = 0; i < lineRepository.lines().size(); i++) {
                        System.out
                            .println("[INFO] " + lineRepository.lines().get(i).getName());
                    }
                }
                if (func == 3) {
                    System.out.println("## 노선 목록");
                    for (int i = 0; i < lineRepository.lines().size(); i++) {
                        System.out
                            .println("[INFO] " + lineRepository.lines().get(i).getName());
                    }
                }
            }


            flag = false;
        }
    }
}
