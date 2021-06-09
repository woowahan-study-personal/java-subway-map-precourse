package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private String name;
    private List<Station> stationsOfLine = new ArrayList<>();

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
        if (lineName.length() >=2 && lineName.length() <= 5) {
            return true;
        }
        return false;
    }

    public static boolean isUnique(String lineName) {
        for (Line line : LineRepository.lines()) {
            if (line.equals(lineName)) {
                return false;
            }
        }
        return true;
    }

    // 추가 기능 구현
}
