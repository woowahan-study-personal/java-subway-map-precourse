package subway.view.message;

public class InputMessage {

    private static final String askFunctionInput = "원하는 기능을 선택하세요.";
    private static final String askStationNameInput = "역 이름을 입력하세요";
    private static final String askLineNameInput = "노선 이름을 입력하세요.";

    public String askStationNameMessageForAdd() {
        return "등록할 " + askStationNameInput;
    }

    public String askStationNameMessageForDelete() {
        return "삭제할 " + askStationNameInput;
    }

    public String askLineNameMessageForAdd() {
        return "등록할 " + askLineNameInput;
    }

    public String askLineNameMessageForDelete() {
        return "삭제할 " + askLineNameInput;
    }

    public String askStationNameMessage() {
        return askStationNameInput;
    }

    public String askLineNameMessage() {
        return askLineNameInput;
    }

    public String askFunctionInputMessage() {
        return askFunctionInput;
    }
}
