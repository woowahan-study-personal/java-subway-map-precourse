package subway.domain;

import java.util.Objects;
import subway.exception.StationException;
import subway.exception.SubwayException;

public class Name {

    private static final int MIN_NAME_SIZE = 2;
    private static final int MAX_NAME_SIZE = 10;

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name.trim();
    }

    private void validate(String name) {
        if (Objects.isNull(name)) {
            throw new SubwayException(StationException.INVALID_STATION_NAME);
        }
        name = name.trim();
        if (name.length() < MIN_NAME_SIZE || name.length() > MAX_NAME_SIZE) {
            throw new SubwayException(StationException.INVALID_STATION_NAME);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }
}
