package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class LineRepository {

    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static Optional<Line> findByLine(String lineName) {
        for (Line line : lines) {
            if (line.getName().equals(lineName)) {
                return Optional.of(line);
            }
        }
        return Optional.empty();
    }
}
