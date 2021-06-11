package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import subway.exception.StationException;
import subway.exception.SubwayException;

public class StationRepository {

    private static final Map<String, Station> stations = new HashMap<>();

    public static List<Station> stations() {
        return new ArrayList<>(stations.values());
    }

    public static void addStation(Station station) {
        stations.put(station.getName(), station);
    }

    public static void deleteStation(String name) {
        if (!stations.containsKey(name)) {
            throw new SubwayException(StationException.NOT_FOUND_STATION);
        }
        // LINE 처리하기
        stations.remove(name);
    }

    public static Station findByName(String name) {
        if (stations.containsKey(name)) {
            return stations.get(name);
        }
        throw new SubwayException(StationException.NOT_FOUND_STATION);
    }
}
