package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Subway {

    private StationRepository stationRepository = new StationRepository();
    private LineRepository lineRepository = new LineRepository();

    public Subway() {
    }

    private boolean isOkayToAddStation(String lineName, String stationName) {
        return lineRepository.isLineExists(lineName) && stationRepository
            .isStationExists(stationName);
    }

    private void unLinkStationInLine(Station station) {
        lineRepository.deleteStationInAllLines(station);
    }

    public List<String> getStationNameList() {
        List<String> stationList =  new ArrayList<>();

        for (Station station : stationRepository.stations()) {
            stationList.add(station.getName());
        }
        return stationList;
    }

    public List<String> getLineNameList() {
        List<String> lineList = new ArrayList<>();

        for (Line line : lineRepository.lines()) {
            lineList.add(line.getName());
        }

        return lineList;
    }

    public List<Line> getLineList() {
        return lineRepository.lines();
    }

    public boolean addStation(String stationName) {
        return stationRepository.addStation(new Station(stationName));
    }

    public boolean deleteStation(String stationName) {
        Station station = stationRepository.getStation(stationName);
        unLinkStationInLine(station);

        return stationRepository.deleteStation(station.getName());
    }

    public boolean addLine(String name, String from, String to) {
        Station fromStation = stationRepository.getStation(from);
        Station toStation = stationRepository.getStation(to);

        if (fromStation == null || toStation == null) {
            return false;
        }

        return lineRepository.addLine(new Line(name, fromStation, toStation));
    }

    public boolean deleteLine(String lineName) {
        return lineRepository.deleteLineByName(lineName);
    }

    public boolean addStationToLine(String lineName, String stationName, int pathIndex) {
        if (isOkayToAddStation(lineName, stationName)) {
            return lineRepository.addStationToLine(lineRepository.getModifiableLine(lineName),
                stationRepository.getStation(stationName), pathIndex);
        }

        return false;
    }

    public boolean deleteStationInLine(String lineName, String stationName) {
        return lineRepository.deleteStationInLine(lineRepository.getModifiableLine(lineName),
            stationRepository.getStation(stationName));
    }
}
