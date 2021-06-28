package subway.management;

import java.util.Optional;
import subway.View;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class ManageLine {

    final public static ManageLine instance = new ManageLine();
    private final static String newLine = System.lineSeparator();

    private static void addLine(String inputLineName, Station firstStation, Station lastStation) {
        Line line = new Line(inputLineName);
        line.addLineStation(firstStation);
        line.addLineStation(lastStation);
        LineRepository.addLine(line);
    }

    public void addCheckLineAndInitStation() {
        String inputLineName = View.getScanMsg(newLine + "## 등록할 노선 이름을 입력하세요.");
        Optional<Line> byLine = LineRepository.findByLine(inputLineName);
        if (byLine.isPresent()) {
            throw new IllegalArgumentException("이미 등록된 노선 이름입니다.");
        }
        String inFirstStName = View.getScanMsg(newLine + "## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        Optional<Station> firstStation = StationRepository.findByStation(inFirstStName);
        String inLastStName = View.getScanMsg(newLine + "## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        Optional<Station> lastStation = StationRepository.findByStation(inLastStName);
        if (firstStation.isEmpty() || lastStation.isEmpty()) {
            View.errMsg("등록된 역만 노선의 구간에 넣을 수 있습니다.");
            return;
        }
        addLine(inputLineName, firstStation.get(), lastStation.get());
        View.infoMsg("지하철 노선이 등록되었습니다.");
    }

    public void deleteLine() {
        String inputLineName = View.getScanMsg(newLine + "## 삭제할 노선 이름을 입력하세요.");
        LineRepository.deleteLineByName(inputLineName);
        View.infoMsg("지하철 노선이 삭제되었습니다.");
    }

    public void printAllLine() {
        View.printMessage(newLine + "## 노선 목록");
        for (Line line : LineRepository.lines()) {
            View.infoMsg(line.getName());
        }
    }

}
