package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import subway.AppStatusCode;

public class Subway {

    private final StationRepository stationRepository = new StationRepository();
    private final LineRepository lineRepository = new LineRepository();

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
        List<String> stationList = new ArrayList<>();

        for (Station station : stationRepository.getStations()) {
            stationList.add(station.getName());
        }

        return stationList;
    }

    public List<String> getLineNameList() {
        List<String> lineList = new ArrayList<>();

        for (Line line : lineRepository.getLines()) {
            lineList.add(line.getName());
        }

        return lineList;
    }

    public List<Line> getLineList() {
        return lineRepository.getLines();
    }

    public int addStation(String stationName) throws IllegalArgumentException {
        try {
            return stationRepository.addStation(new Station(stationName));
        } catch (IllegalArgumentException e) {
            return AppStatusCode.contentRangeFailedCode();
        }
    }

    public int deleteStation(String stationName) {
        Station station = stationRepository.getStation(stationName);

        if (Objects.isNull(station)) {
            return AppStatusCode.notFoundCode();
        }

        unLinkStationInLine(station);

        return stationRepository.deleteStation(station.getName());
    }

    public int addLine(String name, String from, String to) throws IllegalArgumentException {
        Station fromStation = stationRepository.getStation(from);
        Station toStation = stationRepository.getStation(to);

        if (Objects.isNull(fromStation) || Objects.isNull(toStation)) {
            return AppStatusCode.notFoundCode();
        }

        try {
            return lineRepository.addLine(new Line(name, fromStation, toStation));
        } catch (IllegalArgumentException e) {
            return AppStatusCode.contentRangeFailedCode();
        }
    }

    public int deleteLine(String lineName) {
        return lineRepository.deleteLineByName(lineName);
    }

    public int addStationToLine(String lineName, String stationName, int pathIndex) {
        if (isOkayToAddStation(lineName, stationName)) {
            return lineRepository.addStationToLine(lineRepository.getModifiableLine(lineName),
                stationRepository.getStation(stationName), pathIndex);
        }

        return AppStatusCode.notFoundCode();
    }

    public int deleteStationInLine(String lineName, String stationName) {
        Line line = lineRepository.getModifiableLine(lineName);
        Station station = stationRepository.getStation(stationName);

        if (Objects.isNull(line) || Objects.isNull(station)) {
            return AppStatusCode.notFoundCode();
        }

        return lineRepository.deleteStationInLine(line, station);
    }
}
