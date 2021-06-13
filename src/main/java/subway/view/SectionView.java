package subway.view;

import java.util.Scanner;

public class SectionView {

    private final Scanner scanner;

    public SectionView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getUserMenuChoiceNumber() {
        System.out.println("## 구간 관리 화면");
        System.out.println("1. 구간 등록");
        System.out.println("2. 구간 삭제");
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
        System.out.println("## 노선을 입력하세요.");
        return getNextLine();
    }

    public String getStationName() {
        System.out.println("## 역이름을 입력하세요.");
        return getNextLine();
    }

    public String getIndex() {
        System.out.println("## 순서를 입력하세요.");
        return getNextLine();
    }

    public void printAddSectionOk() {
        System.out.println("[INFO] 구간이 등록되었습니다.");
        System.out.println();
    }

    public void printDeleteSectionOk() {
        System.out.println("[INFO] 구간이 삭제되었습니다.");
        System.out.println();
    }
}
