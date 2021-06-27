package subway;

import java.util.List;
import java.util.Optional;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class Check {

    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 5;

    public static Optional<Station> findByStation(String stationName) {
        List<Station> stations = StationRepository.stations();
        for (Station station : stations) {
            if (station.getName().equals(stationName)) {
                return Optional.of(station);
            }
        }
        return Optional.empty();
    }

    public static Optional<Line> findByLine(String lineName) {
        for (Line line : LineRepository.lines()) {
            if (line.getName().equals(lineName)) {
                return Optional.of(line);
            }
        }
        return Optional.empty();
    }

    public static boolean validNameStr(String validName) {
        return validName.length() >= MIN_NAME_LENGTH && validName.length() <= MAX_NAME_LENGTH;
    }

}
