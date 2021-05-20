package subway.domain;

import java.util.LinkedList;

public class Line {

    private String name;
    private LinkedList<String> stations = new LinkedList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
