package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import subway.AppStatusCode;

public class LineRepository {

    private final static List<Line> lines = new ArrayList<>();

    public List<Line> lines() {
        List<Line> lines = new ArrayList<>();

        for (Line line : this.lines) {
            lines.add(line.clone());
        }

        return Collections.unmodifiableList(lines);
    }

    private List<Line> searchLine(String lineName) {
        return lines.stream().filter(line -> line.getName().equals(lineName))
            .collect(Collectors.toList());
    }

    public boolean isLineExists(String lineName) {
        return lines.stream().anyMatch(line -> line.getName().equals(lineName));
    }

    public int addLine(Line line) throws IllegalArgumentException {
        if (isLineExists(line.getName())) {
            return AppStatusCode.contentAlreadyExistsCode();
        }

        lines.add(line);

        return AppStatusCode.requestApprovedCode();
    }

    public int addStationToLine(Line line, Station station, int pathIndex)
        throws IllegalArgumentException {

        line.addStation(pathIndex, station);

        return AppStatusCode.requestApprovedCode();
    }

    public Line getModifiableLine(String name) {
        return searchLine(name).get(0);
    }

    public void deleteStationInAllLines(Station station) {
        for (Line line : lines) {
            line.removeStation(station);
        }
    }

    public int deleteLineByName(String name) {
        if (lines.removeIf(line -> Objects.equals(line.getName(), name))) {
            AppStatusCode.requestApprovedCode();
        }

        return AppStatusCode.notFoundCode();
    }

    public int deleteStationInLine(Line line, Station station) {
        return line.removeStation(station);
    }
}
