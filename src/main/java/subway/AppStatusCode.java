package subway;

public class AppStatusCode {

    private static final int OUT_OF_RANGE = -1;
    private static final int NOT_FOUND = 0;
    private static final int REQUEST_APPROVED = 1;
    private static final int CONTENT_RANGE_FAILED = 2;
    private static final int CONTENT_ALREADY_EXISTS = 3;

    private AppStatusCode() {
    }

    public static int outOfRangeCode() {
        return OUT_OF_RANGE;
    }

    public static int notFoundCode() {
        return NOT_FOUND;
    }

    public static int requestApprovedCode() {
        return REQUEST_APPROVED;
    }

    public static int contentRangeFailedCode() {
        return CONTENT_RANGE_FAILED;
    }

    public static int contentAlreadyExistsCode() {
        return CONTENT_ALREADY_EXISTS;
    }
}
