package subway.view;

import java.util.List;
import java.util.Scanner;
import subway.dto.StationDto;

public class StationView {

    public final Scanner scanner;

    public StationView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getUserMenuChoiceNumber() {
        System.out.println("## 역 관리 화면");
        System.out.println("1. 역 등록");
        System.out.println("2. 역 삭제");
        System.out.println("3. 역 조회");
        System.out.println("B. 돌아가기");

        DefaultView.choiceFunction();
        return getNextLine();
    }

    private String getNextLine() {
        String value = scanner.nextLine();
        System.out.println();

        return value;
    }

    public void printStations(List<StationDto> stationDtos) {
        System.out.println("## 역 목록");
        for (StationDto stationDto : stationDtos) {
            System.out.println(stationDto.getName());
        }
        System.out.println();
    }

    public String getAddStationName() {
        System.out.println("## 등록할 역 이름을 입력하세요.");
        return getNextLine();
    }

    public String getDeleteStationName() {
        System.out.println("## 삭제할 역 이름을 입력하세요.");
        return getNextLine();
    }

    public void printAddStationOk() {
        System.out.println("[INFO] 지하철 역이 등록되었습니다.");
        System.out.println();
    }

    public void printDeleteStationOk() {
        System.out.println("[INFO] 지하철 역이 삭제되었습니다.");
        System.out.println();
    }
}
