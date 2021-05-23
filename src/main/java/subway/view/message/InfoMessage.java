package subway.view.message;

public class InfoMessage {

    private static final String infoHeader = "[INFO] ";

    private static final String submittedStation = "지하철 역이 등록되었습니다.";
    private static final String deletedStation = "지하철 역이 삭제되었습니다.";

    private static final String submittedLine = "지하철 노선이 등록되었습니다.";
    private static final String deletedLine = "지하철 노선이 삭제되었습니다.";

    private static final String submittedPath = "구간이 등록되었습니다.";
    private static final String deletedPath = "구간이 삭제되었습니다.";

    public String SubmittedStationInfoMessage() {
        return infoHeader + submittedStation;
    }

    public String DeletedStationInfoMessage() {
        return infoHeader + deletedStation;
    }

    public String SubmittedLineInfoMessage() {
        return infoHeader + submittedLine;
    }

    public String DeletedLineInfoMessage() {
        return infoHeader + deletedLine;
    }

    public String SubmittedPathInfoMessage() {
        return infoHeader + submittedPath;
    }

    public String DeletedPathInfoMessage() {
        return infoHeader + deletedPath;
    }
}
