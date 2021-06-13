package subway.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import subway.exception.LineException;
import subway.exception.StationException;
import subway.exception.SubwayException;

public class StationRepository {

    private static final Map<String, Station> stations = new HashMap<>();

    public static List<Station> stations() {
        return new ArrayList<>(stations.values());
    }

    public static void addStation(Station station) {
        if (stations.containsKey(station.getName())) {
            throw new SubwayException(StationException.DUPLICATE_STATION);
        }
        stations.put(station.getName(), station);
    }

    public static void deleteStation(String name) {
        validateDeleteStation(name);
        stations.remove(name);
        LineRepository.deleteLineInStation(stations.get(name));
    }

    private static void validateDeleteStation(String name) {
        if (!stations.containsKey(name)) {
            throw new SubwayException(StationException.NOT_FOUND_STATION);
        }
        if (LineRepository.isDeleteStation(stations.get(name))) {
            throw new SubwayException(LineException.INVALID_STATION_DELETE);
        }
    }

    public static Station findByName(String name) {
        if (stations.containsKey(name)) {
            return stations.get(name);
        }
        throw new SubwayException(StationException.NOT_FOUND_STATION);
    }

    public static void clear() {
        stations.clear();
    }
}
