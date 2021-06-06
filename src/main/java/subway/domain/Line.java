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
     * 노선의 역 TODO : Station of StationRepository 변경
     */
     private List<String> lineStations = new ArrayList<>();

    public List<String> getLineStations() {
        return Collections.unmodifiableList(lineStations);
    }

    public void addLineStation(String name) {
        lineStations.add(name);
    }

    public void addLineStation(int index, String name) {
        lineStations.add(index, name);
    }

    public boolean deleteLineStation(String name) {
        return lineStations.removeIf(station -> Objects.equals(station, name));
    }
}
