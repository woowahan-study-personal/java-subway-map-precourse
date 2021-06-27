package subway.management;

import java.util.Optional;
import java.util.Scanner;
import subway.Check;
import subway.View;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;

public class ManageSection {

    public static void addLineSection(Scanner scanner) {
        String inputLineName = View.getScanMsg(scanner, "## 노선을 입력하세요.");
        String inputStationName = View.getScanMsg(scanner, "## 역이름을 입력하세요.");
        int inputIndex = View.getIndex(scanner, "## 순서를 입력하세요.");
        for (Line line : LineRepository.lines()) {
            if (line.getName().equals(inputLineName)) {
                line.addLineStation(inputIndex - 1, new Station(inputStationName)); // Temp
            }
        }
        View.infoMsg("구간이 등록되었습니다.");
    }

    public static void deleteLineSection(Scanner scanner) {
        String deleteLineName = View.getScanMsg(scanner, "## 삭제할 구간의 노선을 입력하세요.");
        Optional<Line> line = Check.findByLine(deleteLineName);
        if (line.isEmpty()) {
            View.errMsg("존재하지 않은 노선 이름입니다.");
            return;
        }
        String deleteStationName = View.getScanMsg(scanner, "## 삭제할 구간의 역을 입력하세요.");
        if (line.get().deleteLineStation(deleteStationName)) {
            View.infoMsg("구간이 삭제되었습니다.");
            return;
        }
        View.errMsg("해당 노선 구간에 존재하지 않은 역입니다.");
    }
}
