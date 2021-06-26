package subway.view;

import java.util.Arrays;
import java.util.List;
import subway.domain.Line;
import subway.domain.Station;

public class PathView {

    public static void printPathManage() {
        List<String> texts = Arrays
            .asList("## 구간 관리 화면", "1. 구간 등록", "2. 구간 삭제", "B. 돌아가기");
        for (String text : texts) {
            System.out.println(text);
        }
    }

    public static void printEnrollPath() {
        System.out.println("## 노선을 입력하세요.");
    }

    public static void printEnrollPathStation() {
        System.out.println("## 역이름을 입력하세요.");
    }

    public static void printEnrollPathStationIndex() {
        System.out.println("## 순서를 입력하세요.");
    }

    public static void printSuccessEnrollPath() {
        System.out.println("[INFO] 구간이 등록되었습니다.");
    }

    public static void printDeletePathLine() {
        System.out.println("## 삭제할 구간의 노선을 입력하세요.");
    }

    public static void printDeletePathStation() {
        System.out.println("## 삭제할 구간의 역을 입력하세요.");
    }

    public static void printSuccessDeletePath() {
        System.out.println("[INFO] 구간이 삭제되었습니다.");
    }

    public static void printFailDeletePath() {
        System.out.println("[ERROR] 구간이 2개 이하이므로 삭제할 수 없습니다.");
    }

    public static void printAllPaths(Line line) {
        System.out.println("[INFO] " + line.getName());
        System.out.println("[INFO] ---");
        for (Station station : line.stationsOfLine()) {
            System.out.println("[INFO] " + station.getName());
        }
        System.out.println();
    }


}
