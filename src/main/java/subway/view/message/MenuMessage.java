package subway.view.message;

import java.util.Arrays;
import java.util.List;

public class MenuMessage {

    private static final String menuHeader = "## ";

    private static final String mainMenuPage = "메인 화면";
    private static final String stationManagementPage = "역 관리 화면";
    private static final String lineManagementPage = "노선 관리 화면";
    private static final String pathManagementPage = "구간 관리 화면";

    private static final String stationListPage = "역 목록";
    private static final String lineListPage = "노선 목록";
    private static final String subwayListPage = "지하철 노선도";

    private static final List<String> mainMenuCommandsList = Arrays
        .asList("1. 역 관리", "2. 노선 관리", "3. 구간 관리", "4. 지하철 노선도 출력", "Q. 종료");
    private static final List<String> stationManagementCommandsList = Arrays
        .asList("1. 역 등록", "2. 역 삭제", "3. 역 조회", "B. 돌아가기");
    private static final List<String> lineManagementCommandsList = Arrays
        .asList("1. 노선 등록", "2. 노선 삭제", "3. 노선 조회", "B. 돌아가기");
    private static final List<String> pathManagementCommandsList = Arrays
        .asList("1. 구간 등록", "2. 구간 삭제", "B. 돌아가기");

    public String mainMenuPageMessage() {
        return menuHeader + mainMenuPage;
    }

    public String stationManagementPageMessage() {
        return menuHeader + stationManagementPage;
    }

    public String lineManagementPageMessage() {
        return menuHeader + lineManagementPage;
    }

    public String pathManagementPageMessage() {
        return menuHeader + pathManagementPage;
    }

    public String stationListPageMessage() {
        return menuHeader + stationListPage;
    }

    public String lineListPageMessage() {
        return menuHeader + lineListPage;
    }

    public String subwayListPageMessage() {
        return menuHeader + subwayListPage;
    }

    public List<String> mainMenuCommandsMessageList() {
        return mainMenuCommandsList;
    }

    public List<String> stationManagementCommandsMessageList() {
        return stationManagementCommandsList;
    }

    public List<String> lineManagementCommandsMessageList() {
        return lineManagementCommandsList;
    }

    public List<String> pathManagementCommandsMessageList() {
        return pathManagementCommandsList;
    }
}
