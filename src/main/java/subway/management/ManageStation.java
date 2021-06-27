package subway.management;

import java.util.Optional;
import java.util.Scanner;
import subway.Check;
import subway.View;
import subway.domain.Station;
import subway.domain.StationRepository;

public class ManageStation {

    public static void addStation(Scanner scanner) {
        String inputStation = View.getScanMsg(scanner, "## 등록할 역 이름을 입력하세요.");
        if (!Check.validNameStr(inputStation)) {
            return;
        }
        Optional<Station> station = Check.findByStation(inputStation);
        if (station.isPresent()) {
            View.errMsg("이미 등록된 역 이름입니다. ");
            return;
        }
        StationRepository.addStation(new Station(inputStation));
        View.infoMsg("지하철 역이 등록되었습니다.");
    }

    public static void deleteStation(Scanner scanner) {
        String inputStation = View.getScanMsg(scanner, "## 삭제할 역 이름을 입력하세요.");
        StationRepository.deleteStation(inputStation);
        View.infoMsg("지하철 역이 삭제되었습니다.");
    }

}
