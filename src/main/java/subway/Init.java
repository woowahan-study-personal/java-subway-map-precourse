package subway;

import java.util.Optional;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class Init {

    public static void initSubwayInfo() {
        initLineInfo("2호선", "교대역", "강남역", "역삼역");
        initLineInfo("3호선", "교대역", "남부터미널역", "양재역", "매봉역");
        initLineInfo("신분당선", "강남역", "양재역", "양재시민의숲역");
    }

    public static void initLineInfo(String newLine, String station1, String station2,
        String station3) {
        Line line = new Line(newLine);
        initLineStation(line, station1);
        initLineStation(line, station2);
        initLineStation(line, station3);
        LineRepository.addLine(line);
    }

    public static void initLineInfo(String newLine, String station1, String station2,
        String station3, String station4) {
        Line line = new Line(newLine);
        initLineStation(line, station1);
        initLineStation(line, station2);
        initLineStation(line, station3);
        initLineStation(line, station4);
        LineRepository.addLine(line);
    }

    public static void initLineStation(Line line, String inputStation) {
        Optional<Station> station = StationRepository.findByStation(inputStation);
        if (station.isPresent()) {
            line.addLineStation(station.get());
            return;
        }
        Station newStation = new Station(inputStation);
        StationRepository.addStation(newStation);
        line.addLineStation(newStation);
    }
}
