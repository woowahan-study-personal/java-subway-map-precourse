package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import subway.exception.LineException;
import subway.exception.StationException;
import subway.exception.SubwayException;

public class Line {

    private static final int MIN_STATION_SIZE = 2;

    private final Name name;
    private final List<Station> stations;

    public Line(String name, Station upStation, Station downStation) {
        this(name, Arrays.asList(upStation, downStation));
    }

    public Line(String name, List<Station> stations) {
        this.name = new Name(name);
        this.stations = new ArrayList<>(stations);
    }

    public void addStation(int index, Station station) {
        validateIndex(index);
        validateAddStation(station);
        index = Math.min(stations.size(), index);
        stations.add(index, station);
    }

    private void validateIndex(int index) {
        if (index < 0) {
            throw new SubwayException(LineException.ILLEGAL_INDEX);
        }
    }

    private void validateAddStation(Station station) {
        if (stations.contains(station)) {
            throw new SubwayException(StationException.DUPLICATE_STATION);
        }
    }

    public void removeStation(Station station) {
        validateRemoveStation(station);
        validateDeleteSize();

        stations.remove(station);
    }

    private void validateRemoveStation(Station station) {
        if (!stations.contains(station)) {
            throw new SubwayException(LineException.NOT_FOUND_LINE_IN_STATION);
        }
    }

    private void validateDeleteSize() {
        if (stations.size() <= MIN_STATION_SIZE) {
            throw new SubwayException(LineException.INVALID_STATION_DELETE);
        }
    }

    public String getName() {
        return name.getName();
    }

    public List<Station> getStations() {
        return new ArrayList<>(stations);
    }
}
