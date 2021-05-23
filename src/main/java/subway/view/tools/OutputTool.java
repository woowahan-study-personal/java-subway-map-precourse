package subway.view.tools;

import java.util.List;

public class OutputTool {

    private OutputTool() {
    }

    public static void printStringList(List<String> stringList) {
        for (String string: stringList) {
            System.out.println(string);
        }
    }
}
