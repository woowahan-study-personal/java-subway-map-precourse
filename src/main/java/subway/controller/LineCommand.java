package subway.controller;

import java.util.Scanner;

public class LineCommand extends AbstractCommand {

    private final Scanner scanner;

    public LineCommand(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Command execute() {
        return null;
    }
}
