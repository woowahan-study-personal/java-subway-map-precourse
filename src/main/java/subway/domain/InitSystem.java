package subway.domain;

public class InitSystem {

    private final StationRepository stationRepository = new StationRepository();
    private final LineRepository lineRepository = new LineRepository();

    public void initStations() {
        stationRepository.addStation(new Station("교대역"));
        stationRepository.addStation(new Station("강남역"));
        stationRepository.addStation(new Station("역삼역"));
        stationRepository.addStation(new Station("남부터미널역"));
        stationRepository.addStation(new Station("양재역"));
        stationRepository.addStation(new Station("양재시민의숲역"));
        stationRepository.addStation(new Station("매봉역"));
    }

}
