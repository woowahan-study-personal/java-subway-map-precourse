package subway.view;

import java.util.List;
import java.util.Scanner;
import subway.dto.LineDto;

public class LineView {

    private final Scanner scanner;

    public LineView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getUserMenuChoiceNumber() {
        System.out.println("## 노선 관리 화면");
        System.out.println("1. 노선 등록");
        System.out.println("2. 노선 삭제");
        System.out.println("3. 노선 조회");
        System.out.println("B. 돌아가기");

        DefaultView.choiceFunction();
        return getNextLine();
    }

    private String getNextLine() {
        String value = scanner.nextLine();
        System.out.println();

        return value;
    }

    public String getLineName() {
        System.out.println("## 등록할 노선 이름을 입력하세요.");
        return getNextLine();
    }

    public String getUpStationName() {
        System.out.println("## 등록할 노선의 상행 좀점역 이름을 입력하세요.");
        return getNextLine();
    }

    public String getDownStationName() {
        System.out.println("## 등록할 노선의 하행 좀점역 이름을 입력하세요.");
        return getNextLine();
    }

    public void printLines(List<LineDto> lineDtos) {
        System.out.println("노선 목록");
        for (LineDto lineDto : lineDtos) {
            System.out.println(lineDto.getName());
        }
        System.out.println();
    }
}
