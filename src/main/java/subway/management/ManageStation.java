package subway.management;

import java.util.Optional;
import subway.Validator;
import subway.View;
import subway.domain.Station;
import subway.domain.StationRepository;

public class ManageStation {

    final public static ManageStation instance = new ManageStation();

    public void addStation() {
        String inputStation = View.getScanMsg("## 등록할 역 이름을 입력하세요.");
        if (!Validator.isValidNameStr(inputStation)) {
            return;
        }
        Optional<Station> station = StationRepository.findByStation(inputStation);
        if (station.isPresent()) {
            throw new IllegalArgumentException("이미 등록된 역 이름입니다.");
        }
        StationRepository.addStation(new Station(inputStation));
        View.infoMsg("지하철 역이 등록되었습니다.");
    }

    public void deleteStation() {
        String inputStation = View.getScanMsg("## 삭제할 역 이름을 입력하세요.");
        if (StationRepository.deleteStation(inputStation)) {
            View.infoMsg("지하철 역이 삭제되었습니다.");
            return;
        }
        throw new IllegalArgumentException("존재하지 않은 역입니다.");
    }

}
