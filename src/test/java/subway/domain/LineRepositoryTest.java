package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.exception.LineException;
import subway.exception.SubwayException;

@DisplayName("LineRepositoryTest")
class LineRepositoryTest {

    private static final Station GANGNAME_STATION = new Station("강남역");
    private static final Station SINLIM_STATION = new Station("신림역");
    private static final Line LINE2 = new Line("2호선", GANGNAME_STATION, SINLIM_STATION);

    @BeforeEach
    void setUp() {
        LineRepository.clear();
        StationRepository.clear();
    }

    @Test
    @DisplayName("노선을 추가한다.")
    void addLine() {
        // given

        // when
        LineRepository.addLine(LINE2);

        // then
        assertThat(LineRepository.lines()).hasSize(1);
    }

    @Test
    @DisplayName("중복된 노선을 추가하면 에러가 발생한다.")
    void addLineWhenDuplicateLine() {
        // given

        // when
        LineRepository.addLine(LINE2);

        // then
        assertThatThrownBy(() -> LineRepository.addLine(LINE2))
            .isInstanceOf(SubwayException.class)
            .hasMessage(LineException.DUPLICATE_LINE.getMessage());
    }

    @Test
    @DisplayName("노선을 삭제한다.")
    void deleteLine() {
        // given
        LineRepository.addLine(LINE2);

        // when

        // then
        assertThatCode(() -> LineRepository.deleteLineByName(LINE2.getName()))
            .doesNotThrowAnyException();
        assertThat(LineRepository.lines()).hasSize(0);
    }

    @Test
    @DisplayName("존재하지 않는 노선을 삭제하면 에러가 발생한다.")
    void deleteLineWhenNotExistLine() {
        // given

        // when

        // then
        assertThatThrownBy(() -> LineRepository.deleteLineByName(LINE2.getName()))
            .isInstanceOf(SubwayException.class)
            .hasMessage(LineException.NOT_FOUND_LINE.getMessage());
    }

    @Test
    @DisplayName("노선에 구간을 추가한다.")
    void addSection() {
        // given
        StationRepository.addStation(GANGNAME_STATION);
        StationRepository.addStation(SINLIM_STATION);
        LineRepository.addLine(LINE2);

        // when
        LineRepository.addSection(LINE2.getName(), new Station("잠실역"), 0);

        // then
        Line line = LineRepository.findByName(LINE2.getName());
        assertThat(line.getStations()).hasSize(3);
    }

    @Test
    @DisplayName("노선에 구간을 삭제한다.")
    void deleteSection() {
        // given
        StationRepository.addStation(GANGNAME_STATION);
        StationRepository.addStation(SINLIM_STATION);
        LineRepository.addLine(new Line("2호선", GANGNAME_STATION, SINLIM_STATION));

        Station station = new Station("잠실역");

        LineRepository.addSection(LINE2.getName(), station, 0);

        // when
        LineRepository.deleteSection(LINE2.getName(), station);

        // then
        Line line = LineRepository.findByName(LINE2.getName());
        assertThat(line.getStations()).hasSize(2);
    }
}