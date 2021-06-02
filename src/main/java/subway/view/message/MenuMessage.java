package subway.view.message;

import java.util.Arrays;
import java.util.List;

public class MenuMessage {

    private MenuMessage() {
    }

    private static final String MENU_HEADER = "## ";

    private static final String MAIN_MENU_PAGE = "메인 화면";
    private static final String STATION_MANAGEMENT_PAGE = "역 관리 화면";
    private static final String LINE_MANAGEMENT_PAGE = "노선 관리 화면";
    private static final String PATH_MANAGEMENT_PAGE = "구간 관리 화면";

    private static final String STATION_LIST_PAGE = "역 목록";
    private static final String LINE_LIST_PAGE = "노선 목록";
    private static final String SUBWAY_LIST_PAGE = "지하철 노선도";

    private static final List<String> MAIN_MENU_COMMANDS_LIST = Arrays
        .asList("1. 역 관리", "2. 노선 관리", "3. 구간 관리", "4. 지하철 노선도 출력", "Q. 종료");
    private static final List<String> STATION_MANAGEMENT_COMMANDS_LIST = Arrays
        .asList("1. 역 등록", "2. 역 삭제", "3. 역 조회", "B. 돌아가기");
    private static final List<String> LINE_MANAGEMENT_COMMANDS_LIST = Arrays
        .asList("1. 노선 등록", "2. 노선 삭제", "3. 노선 조회", "B. 돌아가기");
    private static final List<String> PATH_MANAGEMENT_COMMANDS_LIST = Arrays
        .asList("1. 구간 등록", "2. 구간 삭제", "B. 돌아가기");

    public static String mainMenuPageMessage() {
        return MENU_HEADER + MAIN_MENU_PAGE;
    }

    public static String stationManagementPageMessage() {
        return MENU_HEADER + STATION_MANAGEMENT_PAGE;
    }

    public static String lineManagementPageMessage() {
        return MENU_HEADER + LINE_MANAGEMENT_PAGE;
    }

    public static String pathManagementPageMessage() {
        return MENU_HEADER + PATH_MANAGEMENT_PAGE;
    }

    public static String stationListPageMessage() {
        return MENU_HEADER + STATION_LIST_PAGE;
    }

    public static String lineListPageMessage() {
        return MENU_HEADER + LINE_LIST_PAGE;
    }

    public static String subwayListPageMessage() {
        return MENU_HEADER + SUBWAY_LIST_PAGE;
    }

    public static List<String> mainMenuCommandsMessageList() {
        return MAIN_MENU_COMMANDS_LIST;
    }

    public static List<String> stationManagementCommandsMessageList() {
        return STATION_MANAGEMENT_COMMANDS_LIST;
    }

    public static List<String> lineManagementCommandsMessageList() {
        return LINE_MANAGEMENT_COMMANDS_LIST;
    }

    public static List<String> pathManagementCommandsMessageList() {
        return PATH_MANAGEMENT_COMMANDS_LIST;
    }
}
