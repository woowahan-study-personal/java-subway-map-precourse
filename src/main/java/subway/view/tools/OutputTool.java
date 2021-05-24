package subway.view.tools;

import java.util.List;

public class OutputTool {

    private OutputTool() {
    }

    public static void printStringList(List<String> stringList) {
        for (String string: stringList) {
            System.out.println(string);
        }

        System.out.println();
    }

    public static void printStringListWithHeader(List<String> stringList, String header) {
        for (String string: stringList) {
            System.out.println(header + string);
        }

        System.out.println();
    }
}
