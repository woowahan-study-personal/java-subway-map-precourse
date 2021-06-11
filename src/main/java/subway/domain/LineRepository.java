package subway.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import subway.exception.LineException;
import subway.exception.SubwayException;

public class LineRepository {

    private static final Map<String, Line> lines = new HashMap<>();

    public static List<Line> lines() {
        return new ArrayList<>(lines.values());
    }

    public static void addLine(Line line) {
        if (lines.containsKey(line.getName())) {
            throw new SubwayException(LineException.DUPLICATE_LINE);
        }
        lines.put(line.getName(), line);
    }

    public static void deleteLineByName(String name) {
        if (!lines.containsKey(name)) {
            throw new SubwayException(LineException.NOT_FOUND_LINE);
        }
        lines.remove(name);
    }

    public static void clear() {
        lines.clear();
    }
}
