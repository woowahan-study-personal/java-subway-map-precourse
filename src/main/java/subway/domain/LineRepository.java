package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {

    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static void deleteLineByName(String name) {
        lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static Line getLine(String lineName) throws Exception {
        for (Line line : lines) {
            if (line.getName().equals(lineName)) {
                return line;
            }
        }
        throw new Exception("[ERROR] 해당호선은 존재하지 않습니다.");
    }
}
