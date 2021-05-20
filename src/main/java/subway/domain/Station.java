package subway.domain;

public class Station {

    private String name;

    public Station(String name) {
        nameValidation(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현

    private void nameValidation(String name) {
        if (name.length() < 2 || name.length() > 5) {
            throw new IllegalArgumentException("[ERROR]: 이름의 범위가 2 ~ 5 이내인 경우만 허용합니다.");
        }
    }
}
