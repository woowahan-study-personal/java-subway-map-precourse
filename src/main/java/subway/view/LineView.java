package subway.view;

import java.util.Arrays;
import java.util.List;
import subway.domain.Line;

public class LineView {

    public static void printPathManage() {
        List<String> texts = Arrays
            .asList("## 노선 관리 화면", "1. 노선 등록", "2. 노선 삭제", "3. 노선 조회", "B. 돌아가기");
        for (String text : texts) {
            System.out.println(text);
        }
    }

    public static void printAllPath(List<Line> lines) {
        System.out.println("[INFO] 노선 목록");
        for (Line line : lines) {
            System.out.println("[INFO] " + line.getName());
        }
    }

    public static void printEnrollLine() {
        System.out.println("## 등록할 노선 이름을 입력하세요.");
    }

    public static void printEnrollStartLine() {
        System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
    }

    public static void printEnrollEndLine() {
        System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
    }

    public static void printNotValidName() {
        System.out.println("[ERROR] 노선 이름은 2 ~ 5자 이내여야 합니다.");
    }

    public static void printNotUnique() {
        System.out.println("[ERROR] 중복된 이름의 노선이 존재합니다.");
    }

    public static void printSuccessEnroll() {
        System.out.println("[INFO] 지하철 노선이 등록되었습니다.");
    }

    public static void printDeleteLine() {
        System.out.println("## 삭제할 노선 이름을 입력하세요.");
    }

    public static void printSuccessDelete() {
        System.out.println("[INFO] 지하철 노선이 삭제되었습니다.");
    }

}
