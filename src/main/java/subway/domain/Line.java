package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class Line {

    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현 - 노선의 역 CRD
    /**
     * 노선의 역 : List<Station>
     */
    private List<Station> lineStations = new ArrayList<>();

    public List<Station> getLineStations() {
        return Collections.unmodifiableList(lineStations);
    }

    public void addLineStation(Station station) {
        lineStations.add(station);
    }

    public void addLineStation(int index, Station station) {
        lineStations.add(index, station);
    }

    public boolean deleteLineStation(String name) {
        return lineStations.removeIf(station -> Objects.equals(station, name));
    }
}
