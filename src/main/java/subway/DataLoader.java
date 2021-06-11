package subway;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class DataLoader {

    public void init() {
        initStation();
        initLine();
    }

    private void initStation() {
        List<String> stationNames
            = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
        for (String stationName: stationNames) {
            StationRepository.addStation(new Station(stationName));
        }
    }

    private void initLine() {
        List<Line> lines = createLines();
        for (Line line : lines) {
            LineRepository.addLine(line);
        }
    }

    private List<Line> createLines() {
        List<Line> lines = new ArrayList<>();

        Line line2 = createLine("2호선", Arrays.asList("교대역", "강남역", "역삼역"));
        lines.add(line2);

        Line line3 = createLine("3호선", Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역"));
        lines.add(line3);

        Line lineSinbundang = createLine("신분당선", Arrays.asList("강남역", "양재역", "매봉역"));
        lines.add(lineSinbundang);

        return lines;
    }

    private Line createLine(String name, List<String> lineStationNames) {
        List<Station> line2Stations = new ArrayList<>();
        for (String stationName: lineStationNames) {
            line2Stations.add(StationRepository.findByName(stationName));
        }
        return new Line(name, line2Stations);
    }
}
