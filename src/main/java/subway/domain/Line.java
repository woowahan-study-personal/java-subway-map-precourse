package subway.domain;

import java.util.LinkedList;

public class Line {

    private String name;
    private LinkedList<Station> stations = new LinkedList<>();

    public Line(String name) {
        this.name = name;
    }

    public Line(String name, Station from, Station to) {
        nameValidation(name);
        this.name = name;
        this.stations.add(from);
        this.stations.add(to);
    }

    public String getName() {
        return name;
    }

    private void nameValidation(String name) {
        if (name.length() < 2 || name.length() > 5) {
            throw new IllegalArgumentException("[ERROR]: 이름의 범위가 2 ~ 5 이내인 경우만 허용합니다.");
        }
    }

}
