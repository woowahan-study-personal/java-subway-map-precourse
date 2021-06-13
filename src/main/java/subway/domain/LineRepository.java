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

    public static boolean isDeleteStation(Station station) {
        return lines().stream().filter(line -> line.isContainStation(station))
            .anyMatch(Line::isNotDeleteSize);
    }

    public static void deleteLineInStation(Station station) {
        for (Line line : lines()) {
            line.ifRemoveStation(station);
        }
    }

    public static void addSection(String lineName, Station station, int index) {
        Line line = findByName(lineName);
        line.addStation(index, station);
    }

    private static Line findByName(String name) {
        if (!lines.containsKey(name)) {
            throw new SubwayException(LineException.NOT_FOUND_LINE);
        }
        return lines.get(name);
    }

    public static void deleteSection(String lineName, Station station) {
        Line line = findByName(lineName);
        line.removeStation(station);
    }
}
