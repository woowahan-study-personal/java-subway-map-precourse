package subway.domain;

import java.util.LinkedList;
import java.util.List;

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

    private void isAlreadyInListValidation(Station station) {
        if (this.stations.indexOf(station) != -1) {
            // 현재 단계에서는 Exception을 던지는 것으로 진행함.
            throw new IllegalArgumentException("[ERROR]: 해당 역이 이미 경로에 등록되었습니다.");
        }
    }

    public String getName() {
        return name;
    }

    public void addStation(int pathIndex, Station station) {
        isAlreadyInListValidation(station);
        this.stations.add(station);
    }
}
