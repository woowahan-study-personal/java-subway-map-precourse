package subway.view.message;

public class InputMessage {

    private static final String INPUT_HEADER = "## ";
    private static final String ASK_FUNCTION_INPUT = "원하는 기능을 선택하세요.";
    private static final String ASK_STATION_NAME_INPUT = "역 이름을 입력하세요";
    private static final String ASK_LINE_NAME_INPUT = "노선 이름을 입력하세요.";
    private static final String ASK_FROM_STATION_NAME_FOR_ADD = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String ASK_TO_STATION_NAME_FOR_ADD = "등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String ASK_STATION_ORDER = "순서를 입력하세요.";

    private InputMessage() {
    }

    public static String askStationNameMessageForAdd() {
        return INPUT_HEADER + "등록할 " + ASK_STATION_NAME_INPUT;
    }

    public static String askStationNameMessageForDelete() {
        return INPUT_HEADER + "삭제할 " + ASK_STATION_NAME_INPUT;
    }

    public static String askLineNameMessageForAdd() {
        return INPUT_HEADER + "등록할 " + ASK_LINE_NAME_INPUT;
    }

    public static String askLineNameMessageForDelete() {
        return INPUT_HEADER + "삭제할 " + ASK_LINE_NAME_INPUT;
    }

    public static String askLineNameMessage() {
        return INPUT_HEADER + ASK_LINE_NAME_INPUT;
    }

    public static String askStationNameMessage() {
        return INPUT_HEADER + ASK_STATION_NAME_INPUT;
    }

    public static String askFunctionInputMessage() {
        return INPUT_HEADER + ASK_FUNCTION_INPUT;
    }

    public static String askFromStationNameForAddMessage() {
        return INPUT_HEADER + ASK_FROM_STATION_NAME_FOR_ADD;
    }

    public static String askToStationNameForAddMessage() {
        return INPUT_HEADER + ASK_TO_STATION_NAME_FOR_ADD;
    }

    public static String askStationOrderMessage() {
        return INPUT_HEADER + ASK_STATION_ORDER;
    }
}
