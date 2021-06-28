package subway.management;

import subway.View;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class ManageSection {

    public static ManageSection instance = new ManageSection();

    public void addLineSection() {
        String inputLineName = View.getScanMsg("## 노선을 입력하세요.");
        Line line = LineRepository.findByLine(inputLineName)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 노선의 이름입니다."));

        String inputStationName = View.getScanMsg("## 역이름을 입력하세요.");
        Station station = StationRepository.findByStation(inputStationName)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 역입니다."));

        int inputIndex = View.getIndex("## 순서를 입력하세요.");
        line.addLineStation(inputIndex - 1, station);
        View.infoMsg("구간이 등록되었습니다.");
    }

    public void deleteLineSection() {
        String deleteLineName = View.getScanMsg("## 삭제할 구간의 노선을 입력하세요.");
        Line line = LineRepository.findByLine(deleteLineName)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않은 노선 이름입니다."));

        String deleteStationName = View.getScanMsg("## 삭제할 구간의 역을 입력하세요.");
        if (line.deleteLineStation(deleteStationName)) {
            View.infoMsg("구간이 삭제되었습니다.");
            return;
        }
        throw new IllegalArgumentException("해당 노선 구간에 존재하지 않은 역입니다.");
    }
}
