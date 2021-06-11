package subway.exception;

public enum LineException implements SubwayMapException {
    DUPLICATE_LINE("중복된 노선입니다."),
    NOT_FOUND_LINE("존재하지 않는 노선입니다."),
    ILLEGAL_INDEX("유효하지 않은 인덱스입니다,"),
    NOT_FOUND_LINE_IN_STATION("노선 안에 존재하지 않는 역입니다."),
    INVALID_STATION_DELETE("노선은 최소 2개의 역을 가지고 있어야 합니다.");

    private final String message;

    LineException(String message) {
        this.message = message; }

    @Override
    public String getMessage() {
        return message;
    }
}
