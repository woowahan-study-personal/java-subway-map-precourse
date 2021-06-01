package subway;

public class AppStatusCode {

    private static final int outOfRange = -1;
    private static final int notFound = 0;
    private static final int requestApproved = 1;
    private static final int contentRangeFailed = 2;
    private static final int contentAlreadyExists = 3;

    private AppStatusCode() {
    }

    public static int outOfRangeCode() {
        return outOfRange;
    }

    public static int notFoundCode() {
        return notFound;
    }

    public static int requestApprovedCode() {
        return requestApproved;
    }

    public static int contentRangeFailedCode() {
        return contentRangeFailed;
    }

    public static int contentAlreadyExistsCode() {
        return contentAlreadyExists;
    }
}
