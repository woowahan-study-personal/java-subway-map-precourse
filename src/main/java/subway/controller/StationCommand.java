package subway.controller;

import java.util.Scanner;

public class StationCommand extends AbstractCommand {

    private final Scanner scanner;

    public StationCommand(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Command execute() {
        return null;
    }
}
