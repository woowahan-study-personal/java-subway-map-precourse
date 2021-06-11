package subway.exception;

public enum LineException implements SubwayMapException {
    DUPLICATE_LINE("중복된 노선입니다."),
    NOT_FOUND_LINE("존재하지 않는 노선입니다.");

    private final String message;

    LineException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
