package subway.domain;

public class Station {
    private String name;
    private int usedCount;

    public Station(String name) {
        this.name = name;
        this.usedCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getUsedCount() {
        return usedCount;
    }

    public void plusUsedCount() {
        this.usedCount++;
    }

    public void minusUsedCount() {
        this.usedCount--;
    }

    // 추가 기능 구현
    public static boolean isValidName(String name) {
        if (name.length() >= 2 && name.length() < 5) {
            return true;
        }
        return false;
    }

    public static boolean isUnique(String name) {
        for (Station station : StationRepository.stations()) {
            if (station.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }
}
