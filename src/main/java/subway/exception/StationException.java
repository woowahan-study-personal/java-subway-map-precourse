package subway.exception;

public enum StationException implements SubwayMapException {
    NOT_FOUND_STATION("해당 역을 찾을 수 없습니다.");

    private final String message;

    StationException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
