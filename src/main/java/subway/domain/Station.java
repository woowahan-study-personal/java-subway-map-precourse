package subway.domain;

public class Station {

    private static final int minimumLength = 2;
    private static final int maximumLength = 8;
    private final String name;

    private void nameValidation(String name) throws IllegalArgumentException {
        if (name.length() < minimumLength || name.length() > maximumLength) {
            throw new IllegalArgumentException("[ERROR]: 이름의 범위가 2 ~ 8 이내인 경우만 허용합니다.");
        }
    }

    public Station(String name) {
        nameValidation(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
