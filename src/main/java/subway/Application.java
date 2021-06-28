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

    public static void main(String[] args) {
        new Application().start();
    }

    private void start() {
        View.setScanner(new Scanner(System.in));

        boolean isRunning = true;
        Init.initSubwayInfo();
        while (isRunning) {
            View.mainView();
            String main_func = View.getScanMsg(MAIN_INFO_MSG);
            if (FIRST.equals(main_func)) {
                stationManagement();
            }
            if (SECOND.equals(main_func)) {
                lineManagement();
            }
            if (THIRD.equals(main_func)) {
                lineSectionManagement();
            }
            if (FOURTH.equals(main_func)) {
                View.printAllSubwayMap();
            }
            if (QUIT.equalsIgnoreCase(main_func)) {
                isRunning = false;
            }
        }
    }

    private void stationManagement() {
        while (true) {
            if (stationView()) return;
        }
    }

    private boolean stationView() {
        try {
            View.stationManagementView();
            String func = View.getScanMsg(MAIN_INFO_MSG);
            if (FIRST.equals(func)) {
                ManageStation.instance.addStation();
                return true;
            }
            if (SECOND.equals(func)) {
                ManageStation.instance.deleteStation();
                return true;
            }
            if (THIRD.equals(func)) {
                View.printAllStation();
                return true;
            }
            if (BACK.equalsIgnoreCase(func)) {
                return true;
            }
            throw new IllegalArgumentException("선택할 수 없는 기능입니다.");
        } catch (IllegalArgumentException e) {
            View.errMsg(e.getMessage());
        }
        return false;
    }

    private void lineManagement() {
        while (true) {
            if (lineView()) return;
        }
    }

    private boolean lineView() {
        try {
            View.lineManagementView();
            String func = View.getScanMsg(MAIN_INFO_MSG);
            if (FIRST.equals(func)) {
                ManageLine.instance.addCheckLineAndInitStation();
                return true;
            }
            if (SECOND.equals(func)) {
                ManageLine.instance.deleteLine();
                return true;
            }
            if (THIRD.equals(func)) {
                ManageLine.instance.printAllLine();
                return true;
            }
            if (BACK.equalsIgnoreCase(func)) {
                return true;
            }
            View.errMsg("선택할 수 없는 기능입니다.");
        } catch (IllegalArgumentException e) {
            View.errMsg(e.getMessage());
        }
        return false;
    }

    private void lineSectionManagement() {
        while (true) {
            if (lineSectionView()) return;
        }
    }

    private boolean lineSectionView() {
        try {
            View.lineSectionManagementView();
            String func = View.getScanMsg(MAIN_INFO_MSG);
            if (FIRST.equals(func)) {
                ManageSection.instance.addLineSection();
                return true;
            }
            if (SECOND.equals(func)) {
                ManageSection.instance.deleteLineSection();
                return true;
            }
            if (BACK.equalsIgnoreCase(func)) {
                return true;
            }
            View.errMsg("선택할 수 없는 기능입니다.");
        } catch (IllegalArgumentException e) {
            View.errMsg(e.getMessage());
        }
        return false;
    }

}
