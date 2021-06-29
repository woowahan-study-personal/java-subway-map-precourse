package subway.view;

import java.util.Arrays;
import java.util.List;

public class CommonView {

    public static void printMain() {
        List<String> texts = Arrays
            .asList("## 메인 화면", "1. 역 관리", "2. 노선 관리", "3. 구간 관리", "4. 지하철 노선도 출력", "Q. 종료");
        for (String text : texts) {
            System.out.println(text);
        }
    }

    public static void printRequireOption() {
        System.out.println("## 원하는 기능을 선택하세요.");
    }
}
