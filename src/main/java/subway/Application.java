package subway;

import java.util.Scanner;
import subway.management.ManageLine;
import subway.management.ManageSection;
import subway.management.ManageStation;

public class Application {

    private static final String FIRST = "1";
    private static final String SECOND = "2";
    private static final String THIRD = "3";
    private static final String FOURTH = "4";
    private static final String QUIT = "Q";
    private static final String BACK = "B";
    private static final String MAIN_INFO_MSG = "## 원하는 기능을 선택하세요.";
    private static boolean FLAG = true;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Init.initSubwayInfo();
        while (FLAG) {
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
                FLAG = false;
            }
        }
    }

    private static void stationManagement(Scanner scanner) {
        while (true) {
            View.stationManagementView();
            String func = View.getScanMsg(scanner, MAIN_INFO_MSG);
            if (FIRST.equals(func)) {
                ManageStation.addStation(scanner);
                return;
            }
            if (SECOND.equals(func)) {
                ManageStation.deleteStation(scanner);
                return;
            }
            if (THIRD.equals(func)) {
                View.printAllStation();
                return;
            }
            if (BACK.equalsIgnoreCase(func)) {
                return;
            }
            View.errMsg("선택할 수 없는 기능입니다.");
        }
    }

    private static void lineManagement(Scanner scanner) {
        while (true) {
            View.lineManagementView();
            String func = View.getScanMsg(scanner, MAIN_INFO_MSG);
            if (FIRST.equals(func)) {
                ManageLine.addCheckLineAndInitStation(scanner);
                return;
            }
            if (SECOND.equals(func)) {
                ManageLine.deleteLine(scanner);
                return;
            }
            if (THIRD.equals(func)) {
                ManageLine.printAllLine();
                return;
            }
            if (BACK.equalsIgnoreCase(func)) {
                return;
            }
            View.errMsg("선택할 수 없는 기능입니다.");
        }
    }

    private static void lineSectionManagement(Scanner scanner) {
        while (true) {
            View.lineSectionManagementView();
            String func = View.getScanMsg(scanner, MAIN_INFO_MSG);
            if (FIRST.equals(func)) {
                ManageSection.addLineSection(scanner);
                return;
            }
            if (SECOND.equals(func)) {
                ManageSection.deleteLineSection(scanner);
                return;
            }
            if (BACK.equalsIgnoreCase(func)) {
                return;
            }
            View.errMsg("선택할 수 없는 기능입니다.");
        }
    }

}
