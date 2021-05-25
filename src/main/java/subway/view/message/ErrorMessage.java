package subway.view.message;

public class ErrorMessage {

    private ErrorMessage() {
    }

    private static final String errorHeader = "[ERROR] ";

    private static final String failedRequest = "요청을 처리할 수 없습니다.";
    private static final String requiresIntegerOnly = "정수만 입력하실 수 있습니다";
    private static final String contentLengthOutOfRange = "이름의 범위가 2 ~ 8 이내인 경우만 허용합니다.";
    private static final String cannotFound = "요청하신 데이터를 찾을 수 없습니다.";

    private static final String stationAlreadyExists = "이미 등록된 역입니다.";
    private static final String lineAlreadyExists = "이미 등록된 노선입니다.";
    private static final String stationAlreadyExistsInLine = "해당 역은 이미 노선에 존재합니다.";


    public static String failedRequestErrorMessage() {
        return errorHeader + failedRequest;
    }

    public static String stationAlreadyExistsErrorMessage() {
        return errorHeader + stationAlreadyExists;
    }

    public static String lineAlreadyExistsErrorMessage() {
        return errorHeader + lineAlreadyExists;
    }

    public static String stationAlreadyExistsInLineErrorMessage() {
        return errorHeader + stationAlreadyExistsInLine;
    }

    public static String cannotFoundMessage() {
        return errorHeader + cannotFound;
    }

    public static String contentLengthOutOfRangeMessage() {
        return errorHeader + contentLengthOutOfRange;
    }

    public static String requiresIntegerOnlyMessage() {
        return errorHeader + requiresIntegerOnly;
    }
}
