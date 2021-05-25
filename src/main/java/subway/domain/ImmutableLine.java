package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class ImmutableLine {
    private final String name;
    private final List<Station> stations;

    public ImmutableLine(String name, List<Station> stations) {
        this.name = name;
        this.stations = stations;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getLineStationNameList() {
        List<String> stationNameList = new ArrayList<>();

        for (Station station : this.stations) {
            stationNameList.add(station.getName());
        }

        return stationNameList;
    }
}
