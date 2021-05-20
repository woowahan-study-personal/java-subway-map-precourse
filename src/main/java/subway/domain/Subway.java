package subway.domain;

public class Subway {

    StationRepository stationRepository = new StationRepository();
    LineRepository lineRepository = new LineRepository();

    public Subway() {
    }

    public void addStation(String name) {
        stationRepository.addStation(new Station(name));
    }

    public void addLine(String name, String from, String to) {

    }
}
