package subway.domain;

public class Subway {

    StationRepository stationRepository = new StationRepository();
    LineRepository lineRepository = new LineRepository();

    public Subway() {
    }

    public void addStation(String stationName) {
        stationRepository.addStation(stationName);
    }

    public void addLine(String name, String from, String to) {
        // TO-DO: 지하철 노선을 추가하는 로직을 구현한다
    }

    private boolean isOkayToAddStation(String lineName, String stationName) {
        return lineRepository.isLineExists(lineName) && stationRepository
            .isStationExists(stationName);
    }

    public void addStationToLine(String lineName, String stationName, int pathIndex) {
        // TO-DO: 구간을 등록하는 로직을 구현한다. 아래의 흐름도를 참조해가며 구현에 참조하도록 한다.

        // 1) 노선을 탐색한다. 만약에 노선 이름에 해당되는 객체가 없으면 해당 노선이 없다는 메시지를 출력한다.
        // 2) 추가할 역 이름을 입력한다. 이때, 역 이름에 해당되는 객체가 없다면 해당 역이 없다는 메시지를 출력하고 종료한다.
        // 3) 그 다음 순서에 해당되는 정수를 입력하도록 한다.

        // 노선 객체 1) 연동
        // 역 객체 2) 연동

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