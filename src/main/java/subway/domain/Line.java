package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {

    private static final int MIN_LINE_NAME_LENGTH = 2;
    private static final int MAX_LINE_NAME_LENGTH = 5;
    private final String name;
    private final List<Station> stationsOfLine = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Station> stationsOfLine() {
        return Collections.unmodifiableList(stationsOfLine);
    }

    public void addStation(Station station) {
        stationsOfLine.add(station);
    }

    public void addStation(Station station, int index) {
        stationsOfLine.add(index, station);
    }

    public static boolean isValidName(String lineName) {
        return lineName.length() >= MIN_LINE_NAME_LENGTH && lineName.length() <= MAX_LINE_NAME_LENGTH;
    }

    public static boolean isUnique(String lineName) {
        for (Line line : LineRepository.lines()) {
            if (line.getName().equals(lineName)) {
                return false;
            }
        }
        return true;
    }

    public void deletePathByName(String name) {
        stationsOfLine.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
