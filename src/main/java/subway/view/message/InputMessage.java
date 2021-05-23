package subway.view.message;

public class InputMessage {

    private InputMessage() {
    }

    private static final String askFunctionInput = "원하는 기능을 선택하세요.";
    private static final String askStationNameInput = "역 이름을 입력하세요";
    private static final String askLineNameInput = "노선 이름을 입력하세요.";

    public static String askStationNameMessageForAdd() {
        return "등록할 " + askStationNameInput;
    }

    public static String askStationNameMessageForDelete() {
        return "삭제할 " + askStationNameInput;
    }

    public static String askLineNameMessageForAdd() {
        return "등록할 " + askLineNameInput;
    }

    public static String askLineNameMessageForDelete() {
        return "삭제할 " + askLineNameInput;
    }

    public static String askStationNameMessage() {
        return askStationNameInput;
    }

    public static String askLineNameMessage() {
        return askLineNameInput;
    }

    public static String askFunctionInputMessage() {
        return askFunctionInput;
    }
}
