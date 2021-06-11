package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.exception.LineException;
import subway.exception.StationException;
import subway.exception.SubwayException;

@DisplayName("StationRepositoryTest 테스트")
class StationRepositoryTest {

    private static final Station GANGNAM_STATIIN = new Station("강남역");
    private static final Station JAMSIL_STATION = new Station("잠실역");

    @BeforeEach
    void setUp() {
        StationRepository.clear();
    }

    @Test
    @DisplayName("역을 추가한다.")
    void addStation() {
        // given

        // when
        StationRepository.addStation(GANGNAM_STATIIN);

        // then
        assertThat(StationRepository.stations()).hasSize(1);
        assertThat(StationRepository.findByName("강남역")).isEqualTo(GANGNAM_STATIIN);
    }

    @Test
    @DisplayName("중복된 역을 추가하면 에러가 발생한다.")
    void addStationWhenDuplicateStation() {
        // given
        StationRepository.addStation(GANGNAM_STATIIN);
        // when

        // then
        assertThatThrownBy(() -> StationRepository.addStation(GANGNAM_STATIIN))
            .isInstanceOf(SubwayException.class)
            .hasMessage(StationException.DUPLICATE_STATION.getMessage());
    }

    @Test
    @DisplayName("역을 삭제한다.")
    void deleteStation() {
        // given
        StationRepository.addStation(GANGNAM_STATIIN);
        // when

        // then
        assertThatCode(() -> StationRepository.deleteStation(GANGNAM_STATIIN.getName()))
            .doesNotThrowAnyException();
        assertThat(StationRepository.stations()).hasSize(0);
    }

    @Test
    @DisplayName("역을 삭제한다.")
    void deleteStationWhenNotExistStation() {
        // given

        // when

        // then
        assertThatThrownBy(() -> StationRepository.deleteStation(GANGNAM_STATIIN.getName()))
            .isInstanceOf(SubwayException.class)
            .hasMessage(StationException.NOT_FOUND_STATION.getMessage());
    }

    @Test
    @DisplayName("역 삭제할때 노선에 포함된 역이 2개 이하면 에러 발생")
    void deleteStationWhenLineInStationSize2() {
        // given
        StationRepository.addStation(GANGNAM_STATIIN);
        StationRepository.addStation(JAMSIL_STATION);

        Line line = new Line("2호선", GANGNAM_STATIIN, JAMSIL_STATION);
        LineRepository.addLine(line);

        // when

        // then
        assertThatThrownBy(() -> StationRepository.deleteStation(GANGNAM_STATIIN.getName()))
            .isInstanceOf(SubwayException.class)
            .hasMessage(LineException.INVALID_STATION_DELETE.getMessage());
    }
}