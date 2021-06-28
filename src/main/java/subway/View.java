package subway;

import java.util.List;
import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class View {

    public static String newLine = System.lineSeparator();
    private static Scanner scanner;

    public static void setScanner(Scanner scanner) {
        View.scanner = scanner;
    }

    public static String getScanMsg(String printMsg) {
        printMessage(printMsg);
        return scanner.next();
    }

    public static int getIndex(String printMsg) {
        printMessage(printMsg);
        return scanner.nextInt();
    }

    public static void printMessage(String printMsg) {
        System.out.println(printMsg);
    }

    public static void mainView() {
        System.out.println(newLine + "## 메인 화면" + newLine
            + "1. 역 관리" + newLine
            + "2. 노선 관리" + newLine
            + "3. 구간 관리" + newLine
            + "4. 지하철 노선도 출력" + newLine
            + "Q. 종료" + newLine);
    }

    public static void stationManagementView() {
        System.out.println(newLine + "## 역 관리 화면" + newLine
            + "1. 역 등록" + newLine + "2. 역 삭제" + newLine
            + "3. 역 조회" + newLine + "B. 돌아가기" + newLine);
    }

    public static void lineManagementView() {
        System.out.println(newLine + "## 노선 관리 화면" + newLine
            + "1. 노선 등록" + newLine + "2. 노선 삭제" + newLine
            + "3. 노선 조회" + newLine + "B. 돌아가기" + newLine);
    }

    public static void lineSectionManagementView() {
        System.out.println(newLine + "## 구간 관리 화면" + newLine
            + "1. 구간 등록" + newLine
            + "2. 구간 삭제" + newLine
            + "B. 돌아가기" + newLine);
    }

    public static void printAllStation() {
        printMessage("## 역 목록");
        List<Station> stations = StationRepository.stations();
        for (Station station : stations) {
            infoMsg(station.getName());
        }
    }

    public static void printAllSubwayMap() {
        printMessage(newLine + "## 지하철 노선도");
        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            infoMsg(line.getName());
            infoMsg("---");
            List<Station> lineStations = line.getLineStations();
            for (Station lineStation : lineStations) {
                infoMsg(lineStation.getName());
            }
            System.out.println();
        }
    }

    public static void infoMsg(String msg) {
        System.out.println("[INFO] " + msg);
    }

    public static void errMsg(String msg) {
        System.out.println("[ERROR] " + msg);
    }
}
