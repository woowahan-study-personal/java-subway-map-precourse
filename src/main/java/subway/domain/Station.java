package subway.domain;

public class Station {

    private static final int MIN_STATION_NAME_LENGTH = 2;
    private static final int MAX_STATION_NAME_LENGTH = 5;
    private final String name;
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

    public static boolean isValidName(String name) {
        return name.length() >= MIN_STATION_NAME_LENGTH && name.length() < MAX_STATION_NAME_LENGTH;
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
