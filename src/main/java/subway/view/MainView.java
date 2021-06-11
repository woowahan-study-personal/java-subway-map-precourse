package subway.view;

import java.util.List;
import java.util.Scanner;
import subway.dto.LineDto;
import subway.dto.StationDto;

public class MainView {

    private final Scanner scanner;

    public MainView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getUserMenuChoiceNumber() {
        System.out.println("## 메인 화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료");

        choiceFunction();
        return scanner.nextLine();
    }

    public static void choiceFunction() {
        System.out.println();
        System.out.println("## 원하는 기능을 선택하세요.");
    }

    public static void badChoiceInput() {
        System.out.println("[ERROR] 선택할 수 없는 기능입니다.");
    }

    public void printSubway(List<LineDto> lineDtos) {
        System.out.println("## 지하철 노선도");
        for (LineDto lineDto : lineDtos) {
            printLineInfo(lineDto);
            System.out.println();
        }
    }

    private void printLineInfo(LineDto lineDto) {
        System.out.println(lineDto.getName());
        System.out.println("---");
        for (StationDto stationDto : lineDto.getStations()) {
            System.out.println(stationDto.getName());
        }
    }
}
