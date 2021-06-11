package subway.view;

public class DefaultView {

    public static void printError(String errorMessage) {
        System.out.println("[ERROR] "+ errorMessage);
        System.out.println();
    }

    public static void choiceFunction() {
        System.out.println();
        System.out.println("## 원하는 기능을 선택하세요.");
    }

    public static void badChoiceInput() {
        System.out.println("[ERROR] 선택할 수 없는 기능입니다.");
    }
}
