package subway.view;

import java.util.Arrays;
import java.util.List;
import subway.domain.Station;

public class StationView {

    public static void printStationManage() {
        List<String> texts = Arrays
            .asList("## 역 관리 화면", "1. 역 등록", "2. 역 삭제", "3. 역 조회", "B. 돌아가기");
        for (String text : texts) {
            System.out.println(text);
        }
    }

    public static void printEnrollStation() {
        System.out.println("## 등록할 역 이름을 입력하세요.");
    }

    public static void printSuccessEnroll() {
        System.out.println("[INFO] 지하철 역이 등록되었습니다.");
    }

    public static void printDeleteStation() {
        System.out.println("## 삭제할 역 이름을 입력하세요.");
    }

    public static void printSuccessDelete() {
        System.out.println("[INFO] 지하철 역이 삭제되었습니다.");
    }

    public static void printAllStations(List<Station> stations) {
        for (Station station : stations) {
            System.out.println("[INFO] " + station.getName());
        }
    }

    public static void printNotValidStationName() {
        System.out.println("[ERROR] 역 이름은 2 ~ 5자 이내여야 합니다.");
    }

    public static void printNotUniqueStationName() {
        System.out.println("[ERROR] 중복된 지하철 역이 존재합니다.");
    }

    public static void printStationUsedInPath() {
        System.out.println("[ERROR] 노선에 추가된 역은 삭제 할 수 없습니다.");
    }

}
