package subway.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

public class Line {

    private String name;
    private List<Station> stations = new LinkedList<>();

    private Line(String name) {
        this.name = name;
    }

    public Line(String name, Station from, Station to) {
        nameValidation(name);
        this.name = name;
        this.stations.add(from);
        this.stations.add(to);
    }

    private void nameValidation(String name) {
        if (name.length() < 2 || name.length() > 8) {
            // 현재 단계에서는 Exception을 던지는 것으로 진행함.
            throw new IllegalArgumentException("[ERROR]: 이름의 범위가 2 ~ 8 이내인 경우만 허용합니다.");
        }
    }

    private boolean isAlreadyInListValidation(Station station) {
        return this.stations.indexOf(station) != -1;
    }

    public Line clone() {
        Line line = new Line(this.getName());

        ListIterator<Station> it = stations.listIterator();

        while (it.hasNext()) {
            line.addStation(it.nextIndex(), it.next().clone());
        }

        return line;
    }

    public String getName() {
        return name;
    }

    public List<String> getLineStationNameList() {
        List<String> stationNameList = new LinkedList<>();

        for (Station station: this.stations) {
            stationNameList.add(station.getName());
        }

        return stationNameList;
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
