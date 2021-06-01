package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import subway.AppStatusCode;

public class StationRepository {

    private final static List<Station> stations = new ArrayList<>();

    public List<Station> getStations() {
        return Collections.unmodifiableList(stations);
    }

    private List<Station> searchStation(String stationName) {
        return stations.stream().filter(station -> station.getName().equals(stationName))
            .collect(Collectors.toList());
    }

    public Station getStation(String stationName) {
        if (!isStationExists(stationName)) {
            return null;
        }

        return searchStation(stationName).get(0);
    }

    public boolean isStationExists(String stationName) {
        return stations.stream().anyMatch(station -> station.getName().equals(stationName));
    }

    public int addStation(Station station) throws IllegalArgumentException {
        if (isStationExists(station.getName())) {
            return AppStatusCode.contentAlreadyExistsCode();
        }

        stations.add(station);

        return AppStatusCode.requestApprovedCode();
    }

    public int deleteStation(String stationName) {
        if (stations.removeIf(station -> Objects.equals(station.getName(), stationName))) {
            return AppStatusCode.requestApprovedCode();
        }

        return AppStatusCode.notFoundCode();
    }
}
