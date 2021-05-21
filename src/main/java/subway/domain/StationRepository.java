package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StationRepository {

    private final List<Station> stations = new ArrayList<>();

    public List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public List<Station> searchStation(String stationName) {
        return stations.stream().filter(station -> station.getName().equals(stationName))
            .collect(Collectors.toList());
    }

    public void addStation(Station station) {
        // TO-DO: 만약에 같은 이름을 가진 station이 있다면 [ERROR]를 낸다.
        stations.add(station);
    }

    public boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
