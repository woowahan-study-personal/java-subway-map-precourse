package subway.view.message;

public class ErrorMessage {

    private static final String errorHeader = "[ERROR] ";

    private static final String failedRequest = "선택할 수 없는 기능입니다.";

    private static final String stationAlreadyExists = "이미 등록된 역입니다.";
    private static final String lineAlreadyExists = "이미 등록된 노선입니다.";
    private static final String stationAlreadyExistsInLine = "해당 역은 이미 노선에 존재합니다.";

    public String failedRequestErrorMessage() {
        return errorHeader + failedRequest;
    }

    public String stationAlreadyExistsErrorMessage() {
        return errorHeader + stationAlreadyExists;
    }

    public String lineAlreadyExistsErrorMessage() {
        return errorHeader + lineAlreadyExists;
    }

    public String stationAlreadyExistsInLineErrorMessage() {
        return errorHeader + stationAlreadyExistsInLine;
    }
}
