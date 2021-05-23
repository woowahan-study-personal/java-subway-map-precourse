package subway.domain;

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

    public void addStation(String stationName) {
        stationRepository.addStation(new Station(stationName));
    }

    public void deleteStation(String stationName) {
        Station station = stationRepository.getStation(stationName);
        unLinkStationInLine(station);

        stationRepository.deleteStation(station.getName());
    }

    public void addLine(String name, String from, String to) {
        Station fromStation = stationRepository.getStation(from);
        Station toStation = stationRepository.getStation(to);
        lineRepository.addLine(new Line(name, fromStation, toStation));
    }

    public void addStationToLine(String lineName, String stationName, int pathIndex) {
        if (isOkayToAddStation(lineName, stationName)) {
            lineRepository.addStationToLine(lineRepository.getModifiableLine(lineName),
                stationRepository.getStation(stationName), pathIndex);
        }
    }

    public void deleteLine(String lineName) {
        lineRepository.deleteLineByName(lineName);
    }
}

/*
    ## 구간 관리 화면
    1. 구간 등록
    2. 구간 삭제
    B. 돌아가기

    ## 원하는 기능을 선택하세요.
    1

    ## 노선을 입력하세요.
    2호선

    ## 역이름을 입력하세요.
    잠실역

    ## 순서를 입력하세요.
    2

    [INFO] 구간이 등록되었습니다.
 */