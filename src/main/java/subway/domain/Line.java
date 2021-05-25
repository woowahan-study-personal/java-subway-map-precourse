package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import subway.AppStatusCode;

public class Line {

    private static final int minimumLength = 2;
    private static final int maximumLength = 8;

    private final String name;
    private List<Station> stations = new ArrayList<>();

    private Line(String name) {
        this.name = name;
    }

    private void nameValidation(String name) {
        if (name.length() < minimumLength || name.length() > maximumLength) {
            throw new IllegalArgumentException("[ERROR]: 이름의 범위가 2 ~ 8 이내인 경우만 허용합니다.");
        }
    }

    public Line(String name, Station from, Station to) throws IllegalArgumentException {
        nameValidation(name);
        this.name = name;
        this.stations.add(from);
        this.stations.add(to);
    }

    // TO-DO: 현재 이 방식은 과다한 비용을 지출하고 있는 코드이다. 이를 수정해야 한다.
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
        List<String> stationNameList = new ArrayList<>();

        for (Station station : this.stations) {
            stationNameList.add(station.getName());
        }

        return stationNameList;
    }

    private boolean isAlreadyInListValidation(Station station) {
        return this.stations.indexOf(station) != -1;
    }

    public int addStation(int pathIndex, Station station) {
        if (isAlreadyInListValidation(station)) {
            return AppStatusCode.contentAlreadyExistsCode();
        }

        this.stations.add(pathIndex, station);

        return AppStatusCode.requestApprovedCode();
    }

    public int removeStation(Station targetStation) {
        if (stations
            .removeIf(station -> Objects.equals(station.getName(), targetStation.getName()))) {
            return AppStatusCode.requestApprovedCode();
        }

        return AppStatusCode.notFoundCode();
    }
}
