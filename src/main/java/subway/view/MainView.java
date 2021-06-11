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

        DefaultView.choiceFunction();
        String value = scanner.nextLine();
        System.out.println();

        return value;
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
