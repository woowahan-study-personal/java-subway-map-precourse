package subway.view.message;

public class ErrorMessage {

    private ErrorMessage() {
    }

    private static final String ERROR_HEADER = "[ERROR] ";

    private static final String FAILED_REQUEST = "요청을 처리할 수 없습니다.";
    private static final String REQUIRES_INTEGER_ONLY = "정수만 입력하실 수 있습니다";
    private static final String CONTENT_LENGTH_OUT_OF_RANGE = "이름의 범위가 2 ~ 8 이내인 경우만 허용합니다.";
    private static final String CANNOT_FOUND = "요청하신 데이터를 찾을 수 없습니다.";

    private static final String STATION_ALREADY_EXISTS = "이미 등록된 역입니다.";
    private static final String LINE_ALREADY_EXISTS = "이미 등록된 노선입니다.";
    private static final String STATION_ALREADY_EXISTS_IN_LINE = "해당 역은 이미 노선에 존재합니다.";


    public static String failedRequestErrorMessage() {
        return ERROR_HEADER + FAILED_REQUEST;
    }

    public static String requiresIntegerOnlyMessage() {
        return ERROR_HEADER + REQUIRES_INTEGER_ONLY;
    }

    public static String contentLengthOutOfRangeMessage() {
        return ERROR_HEADER + CONTENT_LENGTH_OUT_OF_RANGE;
    }

    public static String cannotFoundMessage() {
        return ERROR_HEADER + CANNOT_FOUND;
    }

    public static String stationAlreadyExistsErrorMessage() {
        return ERROR_HEADER + STATION_ALREADY_EXISTS;
    }

    public static String lineAlreadyExistsErrorMessage() {
        return ERROR_HEADER + LINE_ALREADY_EXISTS;
    }

    public static String stationAlreadyExistsInLineErrorMessage() {
        return ERROR_HEADER + STATION_ALREADY_EXISTS_IN_LINE;
    }
}
