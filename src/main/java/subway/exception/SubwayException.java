package subway.exception;

public class SubwayException extends RuntimeException {

    public SubwayException(SubwayMapException subwayMapException) {
        super(subwayMapException.getMessage());
    }
}
