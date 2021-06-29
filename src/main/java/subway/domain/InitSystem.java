package subway.domain;

public class InitSystem {

    private static void initStations(Manager manager) {
        manager.addStation("교대역");
        manager.addStation("강남역");
        manager.addStation("역삼역");
        manager.addStation("남부터미널역");
        manager.addStation("양재역");
        manager.addStation("양재시민의숲역");
        manager.addStation("매봉역");
    }

    private static void initLines(Manager manager) {
        manager.addNewLine("2호선", "교대역", "역삼역");
        manager.addNewLine("3호선", "교대역", "매봉역");
        manager.addNewLine("신분당선", "강남역", "양재시민의숲역");
    }

    private static void initStationToLine(Manager manager) {
        manager.addStationToLine("2호선", "강남역", 1);
        manager.addStationToLine("3호선", "남부터미널역", 1);
        manager.addStationToLine("3호선", "양재역", 2);
        manager.addStationToLine("신분당선", "양재역", 1);
    }

    public static void init(Manager manager) {
        initStations(manager);
        initLines(manager);
        initStationToLine(manager);
    }
}
