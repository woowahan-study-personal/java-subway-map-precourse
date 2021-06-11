package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.exception.StationException;
import subway.exception.SubwayException;

@DisplayName("StationRepositoryTest 테스트")
class StationRepositoryTest {

    @BeforeEach
    void setUp() {
        StationRepository.clear();
    }

    @Test
    @DisplayName("역을 추가한다.")
    void addStation() {
        // given
        Station station = new Station("강남역");
        StationRepository.addStation(station);
        // when

        // then
        assertThat(StationRepository.stations()).hasSize(1);
        assertThat(StationRepository.findByName("강남역")).isEqualTo(station);
    }

    @Test
    @DisplayName("중복된 역을 추가하면 에러가 발생한다.")
    void addStationWhenDuplicateStation() {
        // given
        Station station = new Station("강남역");
        StationRepository.addStation(station);
        // when

        // then
        assertThatThrownBy(() -> StationRepository.addStation(station))
            .isInstanceOf(SubwayException.class)
            .hasMessage(StationException.DUPLICATE_STATION.getMessage());
    }

    @Test
    @DisplayName("역을 삭제한다.")
    void deleteStation() {
        // given
        Station station = new Station("강남역");
        StationRepository.addStation(station);
        // when

        // then
        assertThatCode(() -> StationRepository.deleteStation("강남역"))
            .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("역을 삭제한다.")
    void deleteStationWhenNotExistStation() {
        // given

        // when

        // then
        assertThatThrownBy(() -> StationRepository.deleteStation("강남역"))
            .isInstanceOf(SubwayException.class)
            .hasMessage(StationException.NOT_FOUND_STATION.getMessage());
    }
}