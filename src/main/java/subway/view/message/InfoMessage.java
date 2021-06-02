package subway.view.message;

public class InfoMessage {

    private InfoMessage() {
    }

    private static final String INFO_HEADER = "[INFO] ";

    private static final String SUBMITTED_STATION = "지하철 역이 등록되었습니다.";
    private static final String DELETED_STATION = "지하철 역이 삭제되었습니다.";

    private static final String SUBMITTED_LINE = "지하철 노선이 등록되었습니다.";
    private static final String DELETED_LINE = "지하철 노선이 삭제되었습니다.";

    private static final String SUBMITTED_PATH = "구간이 등록되었습니다.";
    private static final String DELETED_PATH = "구간이 삭제되었습니다.";

    public static String getInfoHeader() {
        return INFO_HEADER;
    }

    public static String SubmittedStationInfoMessage() {
        return INFO_HEADER + SUBMITTED_STATION;
    }

    public static String DeletedStationInfoMessage() {
        return INFO_HEADER + DELETED_STATION;
    }

    public static String SubmittedLineInfoMessage() {
        return INFO_HEADER + SUBMITTED_LINE;
    }

    public static String DeletedLineInfoMessage() {
        return INFO_HEADER + DELETED_LINE;
    }

    public static String SubmittedPathInfoMessage() {
        return INFO_HEADER + SUBMITTED_PATH;
    }

    public static String DeletedPathInfoMessage() {
        return INFO_HEADER + DELETED_PATH;
    }
}
