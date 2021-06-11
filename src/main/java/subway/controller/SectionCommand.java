package subway.controller;

import java.util.Scanner;

public class SectionCommand extends AbstractCommand {

    private final Scanner scanner;

    public SectionCommand(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Command execute() {
        return null;
    }
}
