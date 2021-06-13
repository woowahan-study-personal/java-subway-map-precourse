package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import subway.exception.StationException;
import subway.exception.SubwayException;

@DisplayName("StationTest 테스트")
class StationTest {

    @DisplayName("역을 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"두자", "열글자까지는에러안남"})
    void createStation(String name) {
        // given

        // when

        // then
        assertThatCode(() -> new Station(name))
            .doesNotThrowAnyException();
    }

    @DisplayName("역 이름이 2글자 이상 10글자 이하가 아니라면 에러가 발생한다.")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"한", "열글자가넘어가면에러가발생한다"})
    void createNameWhenInvalidName(String name) {
        // given

        // when

        // then
        assertThatThrownBy(() -> new Station(name))
            .isInstanceOf(SubwayException.class)
            .hasMessage(StationException.INVALID_STATION_NAME.getMessage());
    }
}