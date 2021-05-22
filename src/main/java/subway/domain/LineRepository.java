package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LineRepository {

    private final List<Line> lines = new ArrayList<>();

    public List<Line> lines() {
        // 수정이 불가능한 상태의 lines를 반환해야 한다. 노선 리스트 출력에 사용될 예정이다.
        return Collections.unmodifiableList(lines);
    }

    private List<Line> searchLine(String lineName) {
        return lines.stream().filter(line -> line.getName().equals(lineName))
            .collect(Collectors.toList());
    }

    public void addLine(Line line) {
        if (isLineExists(line.getName())) {
            throw new IllegalArgumentException("[ERROR]: 해당 노선은 이미 등록되었습니다.");
        }

        lines.add(line);
    }

    public boolean isLineExists(String lineName) {
        return searchLine(lineName).size() > 0;
    }

    public void addStationToLine(Line line, Station station, int pathIndex) {
        line.addStation(pathIndex, station);
    }

    public Line getUnModifiableLine(String name) {
        // TO-DO: 출력에 사용할 Line에 대한 것으로, 수정이 불가능한 객체가 되어야 한다.
        return null;
    }

    public Line getModifiableLine(String name) {
        return searchLine(name).get(0);
    }

    public boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }
}
