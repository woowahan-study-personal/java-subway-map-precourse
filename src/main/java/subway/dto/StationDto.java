package subway.dto;

import java.util.List;
import java.util.stream.Collectors;
import subway.domain.Station;

public class StationDto {

    private final String name;

    public StationDto(String name) {
        this.name = name;
    }

    public static StationDto of(Station station) {
        return new StationDto(station.getName());
    }

    public static List<StationDto> of(List<Station> stations) {
        return stations.stream()
            .map(StationDto::of)
            .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }
}
