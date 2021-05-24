package subway.view.message;

public class InfoMessage {

    private InfoMessage() {
    }

    private static final String infoHeader = "[INFO] ";

    private static final String submittedStation = "지하철 역이 등록되었습니다.";
    private static final String deletedStation = "지하철 역이 삭제되었습니다.";

    private static final String submittedLine = "지하철 노선이 등록되었습니다.";
    private static final String deletedLine = "지하철 노선이 삭제되었습니다.";

    private static final String submittedPath = "구간이 등록되었습니다.";
    private static final String deletedPath = "구간이 삭제되었습니다.";

    public static String getInfoHeader() {
        return infoHeader;
    }

    public static String SubmittedStationInfoMessage() {
        return infoHeader + submittedStation;
    }

    public static String DeletedStationInfoMessage() {
        return infoHeader + deletedStation;
    }

    public static String SubmittedLineInfoMessage() {
        return infoHeader + submittedLine;
    }

    public static String DeletedLineInfoMessage() {
        return infoHeader + deletedLine;
    }

    public static String SubmittedPathInfoMessage() {
        return infoHeader + submittedPath;
    }

    public static String DeletedPathInfoMessage() {
        return infoHeader + deletedPath;
    }
}
