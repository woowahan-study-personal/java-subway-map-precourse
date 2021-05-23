package subway;

import java.util.Scanner;
import subway.domain.Subway;

/*
 TO-DO: 아래의 사전 등록 정보로 "반드시" 초기 설정을 하기

 1. 지하철역으로 교대역, 강남역, 역삼역, 남부터미널역, 양재역, 양재시민의숲역, 매봉역이 등록되어 있다.
 2. 지하철 노선으로 2호선, 3호선, 신분당선이 등록되어 있다.
 3. 노선에 역이 아래와 같이 등록되어 있다.(왼쪽 끝이 상행 종점)
   - 2호선: 교대역 - 강남역 - 역삼역
   - 3호선: 교대역 - 남부터미널역 - 양재역 - 매봉역
   - 신분당선: 강남역 - 양재역 - 양재시민의숲역
 */

public class Application {

    private static Subway init() {
        Subway subway = new Subway();

        subway.addStation("교대역");
        subway.addStation("강남역");
        subway.addStation("역삼역");
        subway.addStation("남부터미널역");
        subway.addStation("양재역");
        subway.addStation("양재시민의숲역");
        subway.addStation("매봉역");
        
        subway.addLine("2호선", "교대역", "강남역");
        subway.addLine("3호선", "교대역", "남부터미널역");
        subway.addLine("신분당선", "강남역", "양재역");
        
        subway.addStationToLine("2호선", "역삼역", 2);
        subway.addStationToLine("3호선", "양재역", 2);
        subway.addStationToLine("3호선", "매봉역", 3);
        subway.addStationToLine("신분당선", "양재시민의숲역", 2);

        return subway;
    }

    private static void runApplication(Scanner sc) {
        Subway subway = init();
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        runApplication(scanner);
    }
}
