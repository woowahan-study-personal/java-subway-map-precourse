package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StationRepository {

    private final List<Station> stations = new ArrayList<>();

    public List<Station> stations() {
        List<Station> stations =  new ArrayList<>();

        for (Station station : this.stations) {
            stations.add(station.clone());
        }

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

        if (searchResult.size() == 0) {
            return null;
        }

        return searchResult.get(0);
    }

    public boolean addStation(Station station) {
        if (isStationExists(station.getName())) {
            return false;
        }

        stations.add(station);
        return true;
    }

    public boolean deleteStation(String stationName) {
        return stations.removeIf(station -> Objects.equals(station.getName(), stationName));
    }
}
