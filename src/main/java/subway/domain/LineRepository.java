package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LineRepository {

    private final List<Line> lines = new ArrayList<>();

    public List<Line> lines() {
        List<Line> lines =  new ArrayList<>();

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
        return searchLine(lineName).size() > 0;
    }

    public boolean addLine(Line line) {
        if (isLineExists(line.getName())) {
            return false;
        }

        lines.add(line);

        return true;
    }

    public boolean addStationToLine(Line line, Station station, int pathIndex) {
        return line.addStation(pathIndex, station);
    }

    public Line getModifiableLine(String name) {
        return searchLine(name).get(0);
    }

    public void deleteStationInAllLines(Station station) {
        for (Line line: lines) {
            line.removeStation(station);
        }
    }

    public boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public boolean deleteStationInLine(Line line, Station station) {
        return line.removeStation(station);
    }
}
