package subway.exception;

public enum StationException implements SubwayMapException {
    NOT_FOUND_STATION("해당 역을 찾을 수 없습니다."),
    INVALID_STATION_NAME("유효한 역 이름이 아닙니다."),
    DUPLICATE_STATION("중복된 역입니다.");

    private final String message;

    StationException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
