package subway;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.LineRepository;
import subway.domain.StationRepository;

class DataLoaderTest {

    @Test
    @DisplayName("프로그램이 올라가면 역과 노선이 등록된다.")
    public void loadDataWhenOnMemory() {
        // given
        new DataLoader().init();

        // when

        // then
        assertThat(StationRepository.stations()).hasSize(7);
        assertThat(LineRepository.lines()).hasSize(3);
    }

}