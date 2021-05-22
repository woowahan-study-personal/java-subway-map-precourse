package subway.domain;

public class Subway {

    StationRepository stationRepository = new StationRepository();
    LineRepository lineRepository = new LineRepository();

    public Subway() {
    }

    public void addStation(String stationName) {
        Station station = new Station(stationName);
        stationRepository.addStation(station);
    }

    public void addLine(String name, String from, String to) {
        Station fromStation = stationRepository.getStation(from);
        Station toStation = stationRepository.getStation(to);
        Line line = new Line(name, fromStation, toStation);

        lineRepository.addLine(line);
    }

    private boolean isOkayToAddStation(String lineName, String stationName) {
        return lineRepository.isLineExists(lineName) && stationRepository
            .isStationExists(stationName);
    }

    public void addStationToLine(String lineName, String stationName, int pathIndex) {
        if (isOkayToAddStation(lineName, stationName)) {
            lineRepository.addStationToLine(lineRepository.getModifiableLine(lineName),
                stationRepository.getStation(stationName), pathIndex);
        }
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