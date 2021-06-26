package subway;

import java.util.List;
import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class View {

    public static String newLine = System.lineSeparator();

    static String getScanMsg(Scanner scanner, String printMsg) {
        printMessage(printMsg);
        return scanner.next();
    }

    static int getIndex(Scanner scanner, String printMsg) {
        printMessage(printMsg);
        return scanner.nextInt();
    }

    static void printMessage(String printMsg) {
        System.out.println(printMsg);
    }

    static void mainView() {
        System.out.println(newLine + "## 메인 화면" + newLine
            + "1. 역 관리" + newLine
            + "2. 노선 관리" + newLine
            + "3. 구간 관리" + newLine
            + "4. 지하철 노선도 출력" + newLine
            + "Q. 종료" + newLine);
    }

    static void stationManagementView() {
        System.out.println(newLine + "## 역 관리 화면" + newLine
            + "1. 역 등록" + newLine + "2. 역 삭제" + newLine
            + "3. 역 조회" + newLine + "B. 돌아가기" + newLine);
    }

    static void lineManagementView() {
        System.out.println(newLine + "## 노선 관리 화면" + newLine
            + "1. 노선 등록" + newLine + "2. 노선 삭제" + newLine
            + "3. 노선 조회" + newLine + "B. 돌아가기" + newLine);
    }

    static void lineSectionManagementView() {
        System.out.println(newLine + "## 구간 관리 화면" + newLine
            + "1. 구간 등록" + newLine
            + "2. 구간 삭제" + newLine
            + "B. 돌아가기" + newLine);
    }

    static void printAllStation() {
        System.out.println("## 역 목록");
        List<Station> stations = StationRepository.stations();
        for (int i = 0; i < stations.size(); i++) {
            System.out.println("[INFO] " + stations.get(i).getName());
        }
    }

    static void printAllSubwayMap() {
        System.out.println(newLine + "## 지하철 노선도");
        List<Line> lines = LineRepository.lines();
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

    static void infoMsg(String msg) {
        System.out.println("[INFO] " + msg);
    }

    static void errMsg(String msg) {
        System.out.println("[ERROR] " + msg);
    }
}
