package subway.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Line {

    private String name;
    private List<Station> stations = new LinkedList<>();

    public Line(String name) {
        this.name = name;
    }

    public Line(String name, Station from, Station to) {
        nameValidation(name);
        this.name = name;
        this.stations.add(from);
        this.stations.add(to);
    }

    private void nameValidation(String name) {
        if (name.length() < 2 || name.length() > 5) {
            // 현재 단계에서는 Exception을 던지는 것으로 진행함.
            throw new IllegalArgumentException("[ERROR]: 이름의 범위가 2 ~ 5 이내인 경우만 허용합니다.");
        }
    }

    private boolean isAlreadyInListValidation(Station station) {
        return this.stations.indexOf(station) != -1;
    }

    public String getName() {
        return name;
    }

    public boolean addStation(int pathIndex, Station station) {
        if (isAlreadyInListValidation(station)) {
            return false;
        }

        this.stations.add(pathIndex, station);
        return true;
    }

    public boolean removeStation(Station targetStation) {
        return stations
            .removeIf(station -> Objects.equals(station.getName(), targetStation.getName()));
    }
}
