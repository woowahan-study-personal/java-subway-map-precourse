package subway;

import subway.domain.Subway;

public class AppInitializer {

    private static void addInitStations(Subway subway) {
        subway.addStation("교대역");
        subway.addStation("강남역");
        subway.addStation("역삼역");
        subway.addStation("남부터미널역");
        subway.addStation("양재역");
        subway.addStation("양재시민의숲역");
        subway.addStation("매봉역");
    }

    private static void addInitLines(Subway subway) {
        subway.addLine("2호선", "교대역", "강남역");
        subway.addLine("3호선", "교대역", "남부터미널역");
        subway.addLine("신분당선", "강남역", "양재역");
    }

    private static void addInitPaths(Subway subway) {
        subway.addStationToLine("2호선", "역삼역", 2);
        subway.addStationToLine("3호선", "양재역", 2);
        subway.addStationToLine("3호선", "매봉역", 3);
        subway.addStationToLine("신분당선", "양재시민의숲역", 2);
    }

    public static Subway appInitializer() {
        Subway subway = new Subway();

        addInitStations(subway);
        addInitLines(subway);
        addInitPaths(subway);

        return subway;
    }
}
