package subway.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import subway.domain.Line;

public class LineDto {

    private final String name;
    private final List<StationDto> stations;

    public LineDto(String name, List<StationDto> stations) {
        this.name = name;
        this.stations = stations;
    }

    public static LineDto of(Line line) {
        return new LineDto(line.getName(), StationDto.of(line.getStations()));
    }

    public static List<LineDto> of(List<Line> lines) {
        List<LineDto> lineDtos = new ArrayList<>();
        return lines.stream()
            .map(LineDto::of)
            .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public List<StationDto> getStations() {
        return stations;
    }
}
