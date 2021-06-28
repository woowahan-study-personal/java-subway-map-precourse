package subway;

public class Validator {

    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 5;

    public static boolean isValidNameStr(String validName) {
        return validName.length() >= MIN_NAME_LENGTH && validName.length() <= MAX_NAME_LENGTH;
    }

}
