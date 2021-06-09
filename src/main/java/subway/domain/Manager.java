package subway.domain;

public class Manager {

    private LineRepository lineRepository = new LineRepository();
    private StationRepository stationRepository = new StationRepository();

    public void addNewLine(String lineName, String start, String end) {
        Line line = new Line(lineName);
        line.addStation(stationRepository.getStation(start));
        line.addStation(stationRepository.getStation(end));
        lineRepository.addLine(line);
    }

    public void addStation(String stationName) {
        stationRepository.addStation(new Station(stationName));
    }

    public void addStationToLine(String lineName, String stationName, int index) {
        Line line = LineRepository.getLine(lineName);
        line.addStation(StationRepository.getStation(stationName), index);
    }

}
