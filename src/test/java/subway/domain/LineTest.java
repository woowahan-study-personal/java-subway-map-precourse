package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import subway.exception.LineException;
import subway.exception.StationException;
import subway.exception.SubwayException;

@DisplayName("LineTest")
class LineTest {

    private static final Station GANGNAME_STATION = new Station("강남역");
    private static final Station SINLIM_STATION = new Station("신림역");
    private static final Station JAMSIL_STATION = new Station("잠실역");

    @DisplayName("노선을 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"두자", "열글자까지는에러안남"})
    void createStation(String name) {
        // given

        // when

        // then
        assertThatCode(() -> new Line(name, GANGNAME_STATION, SINLIM_STATION))
            .doesNotThrowAnyException();
    }

    @DisplayName("노선 이름이 2글자 이상 10글자 이하가 아니라면 에러가 발생한다.")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"한", "열글자가넘어가면에러가발생한다"})
    void createNameWhenInvalidName(String name) {
        // given

        // when

        // then
        assertThatThrownBy(() -> new Line(name, GANGNAME_STATION, SINLIM_STATION))
            .isInstanceOf(SubwayException.class)
            .hasMessage(StationException.INVALID_STATION_NAME.getMessage());
    }

    @Test
    @DisplayName("노선에 역을 추가한다.")
    void addStation() {
        // given
        Line line = new Line("2호선", GANGNAME_STATION, SINLIM_STATION);

        // when
        line.addStation(5, JAMSIL_STATION);

        // then
        assertThat(line.getStations()).hasSize(3);
    }

    @Test
    @DisplayName("노선에 등록된 역을 다시 등록하면 에러가 발생한다.")
    void addStationWhenDuplicateStation() {
        // given
        Line line = new Line("2호선", GANGNAME_STATION, SINLIM_STATION);
        line.addStation(5, JAMSIL_STATION);
        // when

        // then
        assertThatThrownBy(() -> line.addStation(0, JAMSIL_STATION))
            .isInstanceOf(SubwayException.class)
            .hasMessage(StationException.DUPLICATE_STATION.getMessage());
    }

    @Test
    @DisplayName("음수 인덱스로 추가하면 에러가 발생한다.")
    void addStationWhenIllegalIndex() {
        // given
        Line line = new Line("2호선", GANGNAME_STATION, SINLIM_STATION);
        // when

        // then
        assertThatThrownBy(() -> line.addStation(-1, JAMSIL_STATION))
            .isInstanceOf(SubwayException.class)
            .hasMessage(LineException.ILLEGAL_INDEX.getMessage());
    }

    @Test
    @DisplayName("노선에 포함된 역을 삭제한다.")
    void deleteStation() {
        // given
        Line line = new Line("2호선", GANGNAME_STATION, SINLIM_STATION);
        line.addStation(5, JAMSIL_STATION);

        // when
        line.removeStation(JAMSIL_STATION);

        // then
        assertThat(line.getStations()).hasSize(2);
    }

    @Test
    @DisplayName("노선에 포함된 역이 2개일때 역을 삭제하면 에러가 발생한다.")
    void deleteStationWhenStationSize2() {
        // given
        Line line = new Line("2호선", GANGNAME_STATION, SINLIM_STATION);
        // when

        // then
        assertThatThrownBy(() -> line.removeStation(GANGNAME_STATION))
            .isInstanceOf(SubwayException.class)
            .hasMessage(LineException.INVALID_STATION_DELETE.getMessage());
    }

    @Test
    @DisplayName("역에 포함되지 않은 역을 삭제하면 에러가 발생한다.")
    void deleteStationWhenNotInStation() {
        // given
        Line line = new Line("2호선", GANGNAME_STATION, SINLIM_STATION);
        line.addStation(5, JAMSIL_STATION);
        // when

        // then
        assertThatThrownBy(() -> line.removeStation(new Station("역삼역")))
            .isInstanceOf(SubwayException.class)
            .hasMessage(LineException.NOT_FOUND_LINE_IN_STATION.getMessage());
    }
}