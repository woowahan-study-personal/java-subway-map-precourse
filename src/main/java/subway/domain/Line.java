package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final Name name;
    private final List<Station> stations;

    public Line(String name) {
        this(name, new ArrayList<>());
    }

    public Line(String name, List<Station> stations) {
        this.name = new Name(name);
        this.stations = new ArrayList<>(stations);
    }

    public String getName() {
        return name.getName();
    }

    // 추가 기능 구현
}
