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

    private List<Station> searchStation(String stationName) {
        return stations.stream().filter(station -> station.getName().equals(stationName))
            .collect(Collectors.toList());
    }

    public boolean isStationExists(String stationName) {
        return searchStation(stationName).size() > 0;
    }

    public Station getStation(String stationName) {
        List<Station> searchResult = searchStation(stationName);
        return searchResult.get(0);
    }

    public void addStation(String stationName) {
        if (isStationExists(stationName)) {
            throw new IllegalArgumentException("[ERROR]: 해당 역은 이미 등록되었습니다.");
        }

        stations.add(new Station(stationName));
    }

    public boolean deleteStation(String stationName) {
        // TO-DO: 역이 삭제되면, 역과 연결된 노선들은 전부 위치를 조정해야 한다. 해당 로직이 동작되도록 작업이 필요하다.
        // 역을 삭제하는 로직이 Subway 클래스를 통해 불러들여져야 할 것으로 보인다.

        return stations.removeIf(station -> Objects.equals(station.getName(), stationName));
    }
}
