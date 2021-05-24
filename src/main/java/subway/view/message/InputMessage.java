package subway.view.message;

public class InputMessage {

    private static final String inputHeader = "## ";
    private static final String askFunctionInput = "원하는 기능을 선택하세요.";
    private static final String askStationNameInput = "역 이름을 입력하세요";
    private static final String askLineNameInput = "노선 이름을 입력하세요.";
    private static final String askFromStationNameForAdd = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String askToStationNameForAdd = "등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String askStationOrder = "순서를 입력하세요.";

    private InputMessage() {
    }

    public static String askStationNameMessageForAdd() {
        return inputHeader + "등록할 " + askStationNameInput;
    }

    public static String askStationNameMessageForDelete() {
        return inputHeader + "삭제할 " + askStationNameInput;
    }

    public static String askLineNameMessageForAdd() {
        return inputHeader + "등록할 " + askLineNameInput;
    }

    public static String askLineNameMessageForDelete() {
        return inputHeader + "삭제할 " + askLineNameInput;
    }

    public static String askLineNameMessage() {
        return inputHeader + askLineNameInput;
    }

    public static String askStationNameMessage() {
        return inputHeader + askStationNameInput;
    }

    public static String askFunctionInputMessage() {
        return inputHeader + askFunctionInput;
    }

    public static String askFromStationNameForAddMessage() {
        return inputHeader + askFromStationNameForAdd;
    }

    public static String askToStationNameForAddMessage() {
        return inputHeader + askToStationNameForAdd;
    }

    public static String askStationOrderMessage() {
        return inputHeader + askStationOrder;
    }
}
